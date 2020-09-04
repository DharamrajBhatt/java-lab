import java.util.*;
public class TestArrayList
{
	static ArrayList<String> Switch(ArrayList<String> str1)
	{
		int j;
		for(int i = 0;i<str1.size()-1;i+=2)
		{
			j=i+1;
			Collections.swap(str1,i,j);
		}
			return str1;

	}


	static ArrayList<String> Hide(ArrayList<String> str1)
	{
		int j;
		for(int i = 0;i<str1.size();i++)
		{
			if(str1.get(i).length() % 2 == 0)
			{
				str1.set(i,"#");
			}
		}
			return str1;

	}

	static ArrayList<Integer> removeunfairnumber(ArrayList<Integer> num)
	{
		for(int i = 1;i<num.size();i++)
		{
			if(num.get(i) < num.get(i-1))
			{
				num.remove(i);
			}
			if(num.get(num.size()-1) < num.get(num.size()-2))
			{
				num.remove(num.size()-1);
			}
		}
		return num;
	}


	static void displayList(ArrayList<String> str1)
	{
		for(int i=0;i<str1.size();i++)
		{
			System.out.println(str1.get(i));

		}
	}

	public static void main(String[] args)
	{
		ArrayList<String> str1 = new ArrayList<String>();
		ArrayList<String> str2 = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		int i;
        str1.add("christ");
        str1.add("university");
        str1.add("bangalore");
        str1.add("karnataka");
        str1.add("india");


		str2 =Switch(str1);
		System.out.println("After Swapping the list is:");
		displayList(str2);

		str2 =Hide(str1);
		System.out.println("After Hiding the list is:");
		displayList(str2);


        num.add(5);
        num.add(4);
        num.add(7);
        num.add(3);
        num.add(6);


		num = removeunfairnumber(num);
		System.out.println("After removing Unfair numbers");
		for(i=0;i<num.size();i++)
		{
			System.out.println(num.get(i));

		}


	}
}
