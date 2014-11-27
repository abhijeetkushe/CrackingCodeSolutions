package moderate;


public class FindMax
{

 	private static int max(int a, int b)
 	{
 		int c = a - b;
 		int k = c >> 31 & 1;
 		return a - k * c;  
 	}
 	 
	public static void main(String[] args)
	{
	
		int a = 10, b = 5;
		
		System.out.println(max(a, b));
	}
}