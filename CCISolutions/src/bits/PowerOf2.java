package bits;

public class PowerOf2
{
	public static void main(String[] args)
	{
		System.out.println(powerOf2(16));
		System.out.println(powerOf2(4));
		System.out.println(powerOf2(15));		
		System.out.println(powerOf2(2));
	}

	private static boolean powerOf2(int i)
	{
		return (i & (i-1)) == 0;
	}
}
