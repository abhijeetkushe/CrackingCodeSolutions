package recursion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HaveSomeChange
{
	static int counter = 0;
	// private static Map<Integer, Integer> denoms = IntStream.of(25, 10, 5, 1)
	// .boxed()
	// .collect(Collectors.toMap(Function.<Integer> identity(), (i) -> counter++ ));
	private static List<Integer> denoms = IntStream.of(25, 10, 5, 1).boxed().collect(Collectors.toList());

	public static int makeChange(int n, int startDenom)
	{
		int count = 0;
		if (n == 0)
		{
			return 1;
		}
		else
		{
			for (int i = denoms.indexOf(startDenom); i < denoms.size(); i++)
			{
				int currDenom = denoms.get(i);
				if (currDenom <= n)
				{
					count += makeChange(n - currDenom, currDenom);
				}
			}

			return count;
		}
		// The above comple operation is equivalent to below
		// if (25 <= n && denom >= 25)
		// {
		// makeChange(n - 25, 25, count);
		// }
		//
		// if (10 <= n && denom >= 10)
		// {
		// makeChange(n - 10, 10, count);
		// }
		//
		// if (5 <= n && denom >= 5)
		// {
		// makeChange(n - 5, 5, count);
		// }
		//
		// if (1 <= n && denom >= 1)
		// {
		// makeChange(n - 1, 1, count);
		// }

	}

	public static void main(String[] args)
	{
		StringBuilder count = new StringBuilder(3);
		// makeChange(10, 25, count);
		System.out.println(makeChange(10, 25));
	}
}
