package recursion;

public class NthFibonacci {

	public static int fibonacciRec(int n)
	{
		if(n == 0 ) 
		{
			return 0;
		}else if(n == 1)
		{
			return 1;
		}
		else
		{
			return fibonacciRec(n - 1) + fibonacciRec(n - 2);
		}
			  
	}
	
	public static int fibonacci(int n)
	{
		int a = 0, b = 1;
		int i = 0, num = 0;
		while( i < n)
		{	
			num = a + b; 
			b = a;
			a = num;
			i++;
		}
		return num;
	}
	
	public static void main(String[] args)
	{
		System.out.println(fibonacciRec(3));
	}
	
}