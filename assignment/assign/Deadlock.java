public class Deadlock
{
   public static Object locker1 = new Object();
   public static Object locker2 = new Object();

   public static void main(String args[])
   {
      Thread1 d1 = new Thread1();
      Thread2 d2 = new Thread2();
      d1.start();
      d2.start();
   }

   private static class Thread1 extends Thread
   {
      public void run()
	  {
         synchronized (locker1)
		 {
            System.out.println("Thread 1: Holding lock 1...");
            try
			{
				Thread.sleep(10);
			}
            catch (InterruptedException e) {}
            System.out.println("Thread 1: Waiting for lock 2...");

            synchronized (locker2)
			{
               System.out.println("Thread 1: Holding lock 1 & 2...");
            }
         }
      }
   }
   private static class Thread2 extends Thread
   {
      public void run()
	  {
         synchronized (locker2)
		 {
            System.out.println("Thread 2: Holding lock 2...");
            try
			{
				Thread.sleep(10);
			}
            catch (InterruptedException e) {}
            System.out.println("Thread 2: Waiting for lock 1...");

            synchronized (locker1)
			{
               System.out.println("Thread 2: Holding lock 1 & 2...");
            }
         }
      }
   }
}
