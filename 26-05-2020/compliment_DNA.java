import java.util.*;
//import java.lang.*;
class compliment_DNA
{
	public boolean checkinput(String inputDNA)
	{
		char[] arr = inputDNA.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			char ch = arr[i];
			if(!(ch == 'A' || ch == 'T' || ch == 'G' || ch == 'C' ))
			{
				return false;
			}
		}
		return true;
		
	}
	
	public StringBuffer reverse_compliment(String inputDNA){
		StringBuffer build = new StringBuffer();
		for(int i=0;i<inputDNA.length();i++){
			//char ch = inputDNA.charAt(i);
			if (inputDNA.charAt(i) == 'A')
			{
				build.append('T');
			}
			if (inputDNA.charAt(i) == 'T')
			{
				build.append('A');
			}
			if (inputDNA.charAt(i) == 'C')
			{
				build.append('G');
			}
			if (inputDNA.charAt(i) == 'G')
			{
				build.append('C');
			}
			
		}
		return build.reverse();
	}
	public static void main(String[] args){
		compliment_DNA obj = new compliment_DNA();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the DNA");
    	String inputDNA = sc.next();
    	inputDNA = inputDNA.toUpperCase();
    	boolean bool = obj.checkinput(inputDNA);
    	if(!(bool))
    	{
    		System.out.println("Invalid DNA String");
    	}
    	else
    	{
    		System.out.println( obj.reverse_compliment(inputDNA));
    	}
	}
}