package moderate;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SumPair
{

	static void printSumPairs2(int[] nos, int sum)
	{
		Arrays.sort(nos);

		int first = 0;
		int last = nos.length - 1;

		while (first < last)
		{
			int diff = sum - nos[first];
			if (diff == nos[last])
			{
				System.out.println(nos[first] + "," + nos[last]);
				first++;
				last--;
			}
			else if (diff < nos[last])
			{
				last--;
			}
			else
			{
				first++;
			}
		}
	}

	static void printSumPairs(int[] nos, int sum)
	{
		Map<Integer, Long> noCount = Arrays.stream(nos)
				.boxed()
				.collect(Collectors.groupingBy((no) -> no, Collectors.counting()));

		Arrays.stream(nos).forEach((no) -> {
			if (noCount.containsKey(sum - no))
			{
				System.out.println(no + "," + (sum - no));
			}
		});
	}

	public static void main(String[] args)
	{
		int[] nos = { 5, 6, 3, 2 };

		int sum = 11;

		printSumPairs2(nos, sum);

	}
}
