package sysdesign.memorylimits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PrintDuplicates
{
	// nos = 1 to N <= 32000
	// 4KB memory 2^15 Bytes max 1024 * 8 numbers
	// Have to look a numbers at a time
	// 1 integer => 32 numbers
	// n integers => 2^32/25
	public static class BitVector
	{
		private int[] bitVector;

		public BitVector(int size)
		{
			this.bitVector = new int[size >> 5]; // Divide by 2^5 or 32
		}

		/**
		 * Sets the ith Bit
		 *
		 */
		public void set(int i)
		{
			int bracket = i >> 5;
			int bitNumber = i % 32;
			bitVector[bracket] |= 1 << (bitNumber);
		}

		public boolean get(int i)
		{
			int bracket = i >> 5;
			int bitNumber = i % 32;

			return ((bitVector[bracket] >> bitNumber) & 1) == 1;
		}

	}

	static void findDuplicates(Integer[] nos)
	{
		BitVector bitVector = new BitVector(32000);

		Arrays.stream(nos).forEach((no) -> {
			if (bitVector.get(no))
			{
				System.out.println(no);
			}
			else
			{
				bitVector.set(no);
			}
		});
	}

	public static void main(String[] args)
	{

		System.out.println(Integer.toString(286, 2));

		System.out.println(Integer.toString(~286, 2));
		
		List<Integer> nos = new ArrayList<Integer>(Arrays.asList(IntStream.range(1, 3000).boxed().toArray(Integer[]::new)))
		{
			{
				add(23);
				add(12);
				add(32);
				add(43);
				add(45);
				add(56);
				add(67);
			}
		};
		findDuplicates(nos.toArray(new Integer[nos.size()]));
	}
}
