package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchString
{

	static class SuffixTree
	{
		Map<Character, SuffixTree> branches = new HashMap<>();
		List<Integer> indexes = new ArrayList<>();
		char c;

		SuffixTree(char c, int index)
		{
			this.c = c;
			this.indexes.add(index);
		}
		SuffixTree()
		{}

		@Override
		public String toString()
		{
			return "SuffixTree [branches=" + branches + ", indexes=" + indexes + ", c=" + c + "]";
		}
		List<Integer> search(String keyword)
		{
			if (!branches.containsKey(keyword.charAt(0)))
			{
				return Collections.emptyList();
			}
			else
			{
				if (keyword.length() > 1)
				{
					return branches.get(keyword.charAt(0)).search(keyword.substring(1));
				}
				else
				{
					return branches.get(keyword.charAt(0)).indexes;
				}
			}

		}
		void add(String suffix, int i)
		{
			if (suffix == null || suffix.isEmpty())
			{
				return;
			}

			if (branches.containsKey(suffix.charAt(0)))
			{
				if (suffix.length() > 1)
				{
					branches.get(suffix.charAt(0)).add(suffix.substring(1), i);
				}
				else
				{
					branches.get(suffix.charAt(0)).indexes.add(i);
				}
			}
			else
			{
				SuffixTree subTree = new SuffixTree(suffix.charAt(0), i);
				branches.put(suffix.charAt(0), subTree);
				subTree.add(suffix.substring(1), i);
			}

		}
	}

	private static void searchString_Constant_Time(String s, String[] smallStrings)
	{
		SuffixTree tree = new SuffixTree();

		for (int i = s.length() - 1; i >= 0; i--)
		{
			tree.add(s.substring(i), i);
		}

		for (String str : smallStrings)
		{
			System.out.println(tree.search(str));
		}

	}

	public static void main(String[] args)
	{
		searchString_Constant_Time("bibs", new String[] { "i", "b", "bi", "bs" });
	}
}
