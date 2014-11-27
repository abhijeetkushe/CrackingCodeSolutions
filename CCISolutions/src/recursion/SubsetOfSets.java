package recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubsetOfSets
{
	@SuppressWarnings("unchecked")
	private static void subsetsOfSetsRec(Queue<Integer> queue, HashSet<HashSet<Integer>> setOfSets)
	{
		if (queue.isEmpty())
		{
			setOfSets.add(new HashSet<>());
		}
		else
		{
			Integer elem = queue.remove();
			subsetsOfSetsRec(queue, setOfSets);
			HashSet<HashSet<Integer>> setOfSetsTemp = new HashSet<>();
			for (HashSet<Integer> subSet : setOfSets)
			{
				HashSet<Integer> subSetCopy = (HashSet<Integer>) subSet.clone();
				subSetCopy.add(elem);
				setOfSetsTemp.add(subSetCopy);
			}
			setOfSets.addAll(setOfSetsTemp);
		}

	}

	private static Set<Set<Integer>> subsetsOfSets(List<Integer> set)
	{
		Set<Set<Integer>> setOfSets = new HashSet<>();
		int max = 1 << set.size();
		for (int i = 0; i < max; i++)
		{
			int k = i;
			int index = 0;
			Set<Integer> tempSet = new HashSet<>();
			while (k > 0)
			{
				if ((k & 1) > 0)
				{
					tempSet.add(set.get(index));
				}
				k >>= 1;
				index++;
			}
			setOfSets.add(tempSet);
		}
		return setOfSets;

	}

	public static Set<HashSet<Integer>> subsetsOfSets(Set<Integer> set)
	{
		HashSet<HashSet<Integer>> setOfSets = new HashSet<>();
		subsetsOfSetsRec(new LinkedList<>(set), setOfSets);
		return setOfSets;
	}

	public static void main(String[] args)
	{
		List<Integer> set = IntStream.range(1, 10).boxed().collect(Collectors.<Integer> toList());
		System.out.println(subsetsOfSets(set));
	}
}
