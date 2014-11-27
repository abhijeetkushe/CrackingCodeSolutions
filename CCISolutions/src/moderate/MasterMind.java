package moderate;

public class MasterMind
{

	static class Result
	{
		int hits;
		int psuedohits;

		@Override
		public String toString()
		{
			return "Result [hits=" + hits + ", psuedohits=" + psuedohits + "]";
		}

	}

	static Result checkOverlapping(String guess, String solution)
	{
		int solutionMask = 0;
		for (char c : solution.toCharArray())
		{
			solutionMask |= 1 << (1 + c - 'A');
		}

		Result res = new Result();

		for (int i = 0; i < 4; i++)
		{
			if (guess.charAt(i) == solution.charAt(i))
			{
				res.hits++;
			}
			else
			{
				if ((solutionMask & (1 << (1 + guess.charAt(i) - 'A'))) >= 1)
				{
					res.psuedohits++;
				}

			}

		}
		return res;
	}

	static Result checkNonOverlapping(String guess, String soln)
	{
		Result res = new Result();

		int guessUnMatchMask = 0, solnUnMatchMask = 0;

		for (int i = 0; i < 4; i++)
		{
			if (guess.charAt(i) == soln.charAt(i))
			{
				res.hits++;
			}
			else
			{
				guessUnMatchMask |= 1 << (1 + guess.charAt(i) - 'A');
				solnUnMatchMask |= 1 << (1 + soln.charAt(i) - 'A');
			}
		}

		res.psuedohits = onBits(guessUnMatchMask & solnUnMatchMask);
		return res;
	}

	private static int onBits(int i)
	{
		int onBits = 0;
		while (i > 0)
		{
			onBits += i % 2;
			i /= 2;
		}
		return onBits;
	}

	public static void main(String[] args)
	{
		Result resO = checkOverlapping("RGGB", "YRGB");
		Result resNO = checkNonOverlapping("RGGB", "YRGB");
		System.out.println(resO.toString());
		System.out.println(resNO.toString());
	}
}
