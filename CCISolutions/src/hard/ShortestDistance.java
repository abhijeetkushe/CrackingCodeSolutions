package hard;

public class ShortestDistance
{

	private static int shortestDistance(String[] words, String word1, String word2)
	{
		int min = -Integer.MAX_VALUE / 2;
		int word1Pos = min, word2Pos = min;
		for (int i = 0; i < words.length; i++)
		{
			if (words[i].equals(word1))
			{
				word1Pos = i;
				int distance = word1Pos - word2Pos;
				if (min > distance)
				{
					min = distance;
				}

			}
			else if (words[i].equals(word2))
			{
				word2Pos = i;
				int distance = word2Pos - word1Pos;
				if (min > distance)
				{
					min = distance;
				}
			}

		}

		return min;
	}

	public static void main(String[] args)
	{

	}
}
