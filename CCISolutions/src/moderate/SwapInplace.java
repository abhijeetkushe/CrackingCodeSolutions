package moderate;

public class SwapInplace
{

	public static void main(String[] args)
	{
		int a = 20;
		int b = 34;
		
		System.out.println(a+" "+b);
	
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
//		a = a + b;
//		b = a - b;
//		a = a - b;

	

		System.out.println(a+" "+b);
	}

}