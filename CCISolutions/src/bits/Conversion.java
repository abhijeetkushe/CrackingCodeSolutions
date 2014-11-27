package bits;


public class Conversion
{

	public static int numberOfBits(int a, int b)
	{
		int c = a ^ b;
		int no = 0;
		while(c > 0)
		{
			if((c & 1) == 1){
			 no++;
			}
			c = c >> 1; 
		}
		return no;

		
	}

	public static void main(String[] args)
	{
		System.out.println(numberOfBits(31, 14));
		System.out.println(numberOfBits(0b11011, 0b10100));
	}

}
