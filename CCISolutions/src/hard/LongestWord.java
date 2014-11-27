package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.util.Pair;

public class LongestWord
{

	private static class StringLengthComparator implements Comparator<String>
	{
		public int compare(String a, String b)
		{
			Integer aLength = Integer.valueOf(a.length());
			Integer bLength = Integer.valueOf(b.length());

			return bLength.compareTo(aLength);
		}
	}

	private static String longestWord(String[] words)
	{
		Comparator<String> stringLengthComparator = new StringLengthComparator();

		Arrays.sort(words, stringLengthComparator);

		Set<String> wordsSet = new HashSet<>(Arrays.asList(words));

		for (String word : words)
		{
			List<Pair<String, String>> pairs = pairs(word);

			for (Pair<String, String> pair : pairs)
			{
				if (wordsSet.contains(pair.getKey()) && wordsSet.contains(pair.getValue()))
				{
					return word;
				}
			}
		}

		return null;

	}
	private static List<Pair<String, String>> pairs(String word)
	{
		List<Pair<String, String>> pairs = new ArrayList<>();
		for (int i = 1; i < word.length(); i++)
		{
			pairs.add(new Pair<>(word.substring(0, i), word.substring(i, word.length())));
		}
		return pairs;
	}

	public static void main(String[] args)
	{
		String[] words = { "best", "es", "t", "abc", "a", "b", "c" };
		System.out.println(longestWord(words));
	}
}
