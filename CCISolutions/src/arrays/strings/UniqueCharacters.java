package arrays.strings;

import java.util.Arrays;

public class UniqueCharacters
{

	public static boolean distinctCharsAscii(String str)
	{
		boolean[] uniqueCharCheck = new boolean[256];
		for (char c : str.toCharArray())
			if (uniqueCharCheck[c])
				return false;
			else
				uniqueCharCheck[c] = true;
		return true;
	}

	public static boolean distinctCharsAlphanumberic(String str)
	{
		long checker = 0;

		for (char c : str.toCharArray())
		{
			int val = value(c);
			if ((checker & (1 << val)) == 0)
				return false;
			else
				checker |= (1 << val);
		}
		return true;
	}

	private static int value(char c)
	{
		if (c >= 'a' && c <= 'z')
			return c - 'a';
		else if (c >= 'A' && c <= 'Z')
			return c - 'A' + 25;
		else
			return c - '0' + 51;

	}
}
