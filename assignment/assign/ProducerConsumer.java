class Thread1
{
    int number;
    boolean check =false;
    synchronized int get()
    {
        if (!check)
            try
            {
                wait();
            }
            catch (Exception e)
            {
                System.out.println("Exception occurs at : "+e);
            }
        System.out.println("Consumer got:" +number);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Exception occurs at : "+e);
        }
        check=false;
        notify();
        return number;
    }
    synchronized int put(int number)
    {
        if (check)
            try
            {
                wait();
            }
            catch (Exception e)
            {
                System.out.println("Exception occur at : "+e);
            }
        this.number=number;
        check=true;
        System.out.println("Producer put:"+number);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Exception occur at : "+e);
        }
        notify();
        return number;
    }
}

class Producer implements Runnable
{
    Thread1 t;
    Producer(Thread1 t)
    {
        this.t=t;
        new Thread(this,"Producer").start();
    }
    public void run()
    {
        int x=0;
        int i = 0;
        while (x<10)
        {
            t.put(i++);
            x++;
        }
    }
}

class Consumer implements Runnable
{
    Thread1 t;
    Consumer(Thread1 t)
    {
        this.t=t;
        new Thread(this,"Consumer").start();
    }
    public void run()
    {
        int x=0;
        while (x<10)
        {
            t.get();
            x++;
        }
    }
}

class  ProducerConsumer
{
    public static void main(String args[])
    {
        Thread1 t=new Thread1();
        new Producer(t);
        new Consumer(t);
    }
}
