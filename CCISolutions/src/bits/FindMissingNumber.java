package bits;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumber
{
	static class BitInteger
	{
		List<Integer> bits = new ArrayList<>(32);

		BitInteger(List<Integer> bits)
		{
			this.bits = bits;
			fill();
		}

		private void fill()
		{
			while (bits.size() <= 32)
			{
				bits.add(0);
			}
		}

	}

	static BitInteger toBitInteger(int i)
	{

		List<Integer> bits = new ArrayList<>(32);
		while (i > 0)
		{
			bits.add(i & 1);
			i = i >> 1;
		}
		return new BitInteger(bits);
	}

	public static int findMissingNumber(List<BitInteger> array, int column)
	{
		if (column > 32)
		{
			return 0;
		}

		List<BitInteger> oddIndices = new ArrayList<>();
		List<BitInteger> evenIndices = new ArrayList<>();

		array.forEach((bitInteger) -> {
			if (bitInteger.bits.get(column) == 0)
			{
				evenIndices.add(bitInteger);
			}
			else
			{
				oddIndices.add(bitInteger);
			}
		});

		if (evenIndices.size() <= oddIndices.size())
			return findMissingNumber(evenIndices, column + 1) << 1 | 0;
		else
			return findMissingNumber(oddIndices, column + 1) << 1 | 1;
	}

	//25 13-0s 12-1s
	//even 12  12
	//odd 13   11
	
	//24 12-0s 12-1s
	//even 11  12
	//odd 12   11
	
	
	public static void main(String[] args)
	{
		int missingNumber = 0b00101;
		List<BitInteger> integers = new ArrayList<>();
		for (int i = 0; i < 25; i++)
		{
			if (i != missingNumber)
				integers.add(toBitInteger(i));
		}
		int num = findMissingNumber(integers, 0);
		System.out.println(missingNumber == num);
	}

}
