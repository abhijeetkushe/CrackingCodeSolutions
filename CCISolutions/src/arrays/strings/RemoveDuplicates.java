package arrays.strings;

import java.util.Arrays;

public class RemoveDuplicates
{
	public static void removeDupeChars(char[] chars)
	{
		int tail = 1;

		for (int i = 1; i < chars.length; i++)
		{
			int j;
			for (j = 0; j < tail; j++)
				if (chars[i] == chars[j])
					break;

			if (j == tail)
			{
				chars[tail] = chars[i];
				tail++;
			}
		}
		chars[tail] = 0;
	}

	public static String removeDupesBuffer(char[] chars)
	{
		int tail = 1;
		boolean[] hits = new boolean[256];
		for (int j = 1; j < chars.length; j++)
			if (!hits[chars[j]])
			{
				chars[tail++] = chars[j];
				hits[chars[j]] = true;
			}
		
		return new String(Arrays.copyOfRange(chars, 0, tail));

	}
}
