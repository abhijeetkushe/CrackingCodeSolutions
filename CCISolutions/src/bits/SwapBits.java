package bits;

public class SwapBits
{

	public static int odd_even(int a)
	{
		return ((a & 0xAAAAAAAA)>>1)  | ((a & 0x55555555) <<1);
	}

	public static void main(String[] args)
	{
		System.out.println(Integer.toString(23, 2));
		System.out.println(Integer.toString(odd_even(23), 2));
	}
}