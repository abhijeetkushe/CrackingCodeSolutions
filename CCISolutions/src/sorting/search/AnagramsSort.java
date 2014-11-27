package sorting.search;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramsSort
{
	static class AnagramSortComparator implements Comparator<String>
	{
		@Override
		public int compare(String a, String b)
		{
			char[] aChars = a.toCharArray();
			char[] bChars = b.toCharArray();
			
			Arrays.sort(aChars);
			Arrays.sort(bChars);
			
			return new String(aChars).compareTo(new String(bChars));
		} 
	}
	
	public static void main(String[] args)
	{
		String[] msgs = {"abc","cab","asd","sas","dsa"};
		
		Arrays.sort(msgs, new AnagramSortComparator());
		
		System.out.println(Arrays.toString(msgs));
	}
		
}
