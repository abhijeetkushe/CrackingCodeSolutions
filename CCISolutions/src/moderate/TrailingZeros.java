package moderate;

public class TrailingZeros
{

	public static void main(String[] args)
	{
		int no = 15;
		int count = 0;
		
		for(int i = 5; no/i > 0; i*=5)
		{
			count+=no/i;
		}
		
		System.out.println(count);
	}

}