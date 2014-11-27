package moderate;

public class Rand7
{

	static int rand5()
	{
		return 1;
	}

	public static void main(String[] args)
	{
		int no = 0;
		while (true)
		{
			no = (rand5() - 1) * 5 + rand5() - 1;
			if (no < 21)
			{
				System.out.println((no % 7) + 1);
			}
		}

	}
}
