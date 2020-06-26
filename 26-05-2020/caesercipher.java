import java.util.*;

class caesercipher{
	public StringBuffer decodeString(String enstr, int key)
	{
		StringBuffer text = new StringBuffer();
		for (int i=0;i<enstr.length();i++)
		{
			if (Character.isUpperCase(enstr.charAt(i)))
			{
				char ch = (char)(((int)enstr.charAt(i) + key - 65)% 26 + 65);
				text.append(ch);
			}
			else
			{
				char ch = (char)(((int)enstr.charAt(i) + key - 97)% 26 + 97);
				text.append(ch);
			}
		}
		return text;
	}
	public static void main(String[] args)
	{
		caesercipher obj = new caesercipher();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter encrypted string");
		String enstr = sc.next();
		System.out.println("Enter key value");
		int key = sc.nextInt();
		System.out.println("docoted string is");
		System.out.println(obj.decodeString(enstr,26-key).toString());
	}
}