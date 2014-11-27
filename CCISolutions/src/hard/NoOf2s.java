package hard;

public class NoOf2s
{

	private static int noOf2sRec(int no)
	{
		if (no == 0)
			return 0;

		int pow = 1;

		while (pow * 10 < no)
		{
			pow *= 10;
		}

		int first = no / pow;
		int remainder = no % pow;

		int noOf2s = 0;
		if (first == 2)
		{
			noOf2s += remainder + 1;
		}
		else if (first > 2)
		{
			noOf2s += pow;
		}

		noOf2s += first * noOf2sRec(pow - 1) + noOf2sRec(remainder);
		return noOf2s;

	}

	// 10^0 prev = 0
	// 10^1, = 10*prev + 10^0
	// (no/10^1)prev + 10^1
	// 10^2, 10*prev + 10^1
	// 1000 10*prev + 10^2
	// 10000 10*prev + 10^3
	// log base 10 N
	private static int noOf2s(int no)
	{
		int acc = 0;

		while (true)
		{
			if (no == 0)
			{
				break;
			}

			// Log10 operation
			int noOf2sbase10 = 0;
			int base10 = 1;
			int pow = 0;
			while (base10 * 10 <= no)
			{
				noOf2sbase10 = 10 * noOf2sbase10 + (int) Math.pow(10, pow);
				base10 *= 10;
				pow++;

			}

			int first = no / base10;

			int remainder = no % base10;

			noOf2sbase10 = first * noOf2sbase10;

			if (first == 2)
			{
				noOf2sbase10 += remainder + 1;
			}
			else if (first > 2)
			{
				noOf2sbase10 += base10;
			}

			acc += noOf2sbase10;
			no = remainder;

		}
		return acc;

	}

	// 0 - 9 1
	// 10 - 19 1
	// 20 - 29 1 + 10
	// 3 1
	// 4 1
	// 5 1
	// 6 1
	// 7 1
	// 8 1
	// 9 1 (20)
	// 100-199 (20)
	// 200-299 100 + 20
	public static void main(String[] args)
	{
		int no = 538;
		System.out.println(noOf2sRec(no));

		System.out.println(noOf2s(no));
	}
}
