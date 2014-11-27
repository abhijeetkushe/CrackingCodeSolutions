package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations
{

	public static List<String> permutations(String msg, int index)
	{
		if (index == msg.length() - 1)
		{
			List<String> oneChar = new ArrayList<String>();
			oneChar.add(String.valueOf(msg.charAt(index)));
			return oneChar;
		}
		char indexChar = msg.charAt(index);
		List<String> subPermutations = permutations(msg, index + 1);
		List<String> permutations = new ArrayList<>();
		for (String str : subPermutations)
		{
			for (int i = 0; i <= str.length(); i++)
			{
				StringBuilder sb = new StringBuilder(str);
				permutations.add(sb.insert(i, indexChar).toString());
			}
		}
		return permutations;
	}

	public static void main(String[] args)
	{
		String msg = "abcd";
		System.out.println(permutations(msg, 0));
	}
}
