package bits;

public class BitMask {

	public static int mask(int n ,int m, int i, int j) 
	{
		int mMask = ~0 ^ (((1 << (i+1)) -1) ^ ((1  << (j + 1)) - 1));

		return (n & mMask) |  (m << i);
	   
	}
	
	public static void main(String[] args)
	{
		int n = 0b10000000000;
		int m = 0b10101;
		System.out.println("m =" +Integer.toString(m, 2));
		System.out.println("n =" +Integer.toString(n, 2));
		System.out.println(Integer.toString(mask(n, m, 2, 6), 2));
	}

}