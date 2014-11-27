package moderate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFrequency
{
	
	
	public static void main(String[] args)
	{
		String book[] = {"acs", "asd"};
		
		String wordF = "and";
		
		Map<String, Long> wordCount = Arrays.stream(book).collect(Collectors.groupingBy((word) -> word, Collectors.counting()));
		
		Map<String, Integer> wordFreq = new HashMap<>();
		
		for(String word : book)
		{
			word = word.toLowerCase();
			if(word.trim() != "")
			{	
				if(wordFreq.containsKey(word))
				{
					wordFreq.put(word, wordFreq.get(word) + 1);
				}
				else
				{
					wordFreq.put(word,  1);
				}
			}	
		}
	}

}