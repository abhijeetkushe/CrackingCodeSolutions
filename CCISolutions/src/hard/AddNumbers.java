package hard;

public class AddNumbers
{

	public static void main(String[] args)
	{
		System.out.println(add(759, 674));

	}
	
//	1100 1101 = 0001 | 11000
//	
//323 1433 = 1110 
	//17 + 23  = 30 + 10
	//12 + 13  = 25 + 0
	//1100 1101 = 11001
	// 1100 & 1101 = 11000
	// 1100 | 1101 = 01101
	//1100 ^ 1101 = 0001
	//11 + 17 = 01011 10001 = 11010
    //00001 + 11010	
	private static int add(int a, int b)
	{
		if(b == 0) return a;
		int sum = a ^ b;
		int carry = a & b;
		return add(sum, carry);
	}
	
	
	
//	private static int add(int a, int b)
//	{
//
//		System.out.println(Integer.toString(a, 2));
//		System.out.println(Integer.toString(b, 2));
//
//		System.out.println(Integer.toString(a | b, 2));
//		System.out.println(Integer.toString(a & b, 2));
//		return ((a | b) & (a & b)) << 1;
//	}
}
