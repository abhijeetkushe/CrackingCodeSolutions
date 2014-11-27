package sysdesign.memorylimits;

import java.util.BitSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BillionIntegers
{
	static int findMissingNumberWithLimitedMemory(List<Integer> allNos)
	{
		int[] blocks = new int[(int) Math.pow(2, 3)];
		int block_max = (int) Math.pow(2, 7);

		allNos.stream().forEach((i) -> {
			int blockNo = i / block_max;
			blocks[blockNo]++;
		});

		int missing_block = findIndex(blocks, (counter) -> counter < block_max);

		BitSet bitVector = new BitSet(block_max);
		int low = missing_block * block_max;
		int high = (missing_block + 1) * block_max;
		allNos.stream().forEach((no) -> {
			if (no >= low && no < high)
			{
				bitVector.set(no - missing_block * block_max);

			}
		});
		return missing_block * block_max + bitVector.nextClearBit(0);
	}

	private static int findIndex(int[] arr, Predicate<Integer> check)
	{
		int missing_block = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (check.test(arr[i]))
			{
				missing_block = i;
			}
		}
		return missing_block;
	}

	static int findMissingNumber(List<Integer> allNos)
	{
		BitSet flags = new BitSet(10);
		allNos.stream().forEach((i) -> flags.set(i));
		return flags.nextClearBit(0);
	}

	public static void main(String[] args)
	{
		System.out.println(findMissingNumberWithLimitedMemory(IntStream.range(0, 1023).boxed().collect(Collectors.toList())));
	}
}
