package sorting.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Circus
{
	static class Athlete
	{
		private Integer height, weight;

		Athlete(Integer height, Integer weight)
		{
			this.height = height;
			this.weight = weight;
		}

		@Override
		public String toString()
		{
			return "[height=" + height + ", weight=" + weight + "]";
		}

	}

	static class AtheleteComparator implements Comparator<Athlete>
	{
		public int compare(Athlete a, Athlete b)
		{
			int comp = a.height.compareTo(b.height);
			if (comp == 0)
			{
				return a.weight.compareTo(b.weight);
			}
			else
				return comp;
		}
	}

	private static List<Athlete> getAthletes(List<Athlete> athletes)
	{
		Collections.sort(athletes, new AtheleteComparator());

		List<Athlete> maxSequence = Collections.emptyList();
		int currentUnfitItem = 0;

		while (currentUnfitItem < athletes.size())
		{
			List<Athlete> sequence = new ArrayList<>();
			int nextUnFitItem = getSequence(currentUnfitItem, athletes, sequence);
			maxSequence = maxSequence(maxSequence, sequence);

			if (nextUnFitItem == currentUnfitItem)
				break;
			else
				currentUnfitItem = nextUnFitItem;

		}

		return maxSequence;

	}

	private static List<Athlete> maxSequence(List<Athlete> athletes1, List<Athlete> athletes2)
	{
		if (athletes1.size() > athletes2.size())
			return athletes1;
		else
			return athletes2;
	}

	private static int getSequence(int startFrom, List<Athlete> athletes, List<Athlete> sequence)
	{

		int prevWeight = 0;
		int nextUnfitItem = startFrom;
		if (startFrom < athletes.size())
		{
			for (int i = startFrom; i < athletes.size(); i++)
			{
				Athlete item = athletes.get(i);
				if (item.weight > prevWeight)
				{
					prevWeight = item.weight;
					sequence.add(item);
				}
				else
				{
					if(nextUnfitItem == startFrom)
						nextUnfitItem = i;
				}
			}
		}
		return nextUnfitItem;
	}

	public static void main(String[] args)
	{
		List<Athlete> allAthletes = Arrays.asList(new Athlete(65, 100),
				new Athlete(70, 150),
				new Athlete(56, 90),
				new Athlete(75, 190),
				new Athlete(72, 100),
				new Athlete(60, 95),
				new Athlete(63,70),
				new Athlete(68, 110));
		System.out.println(getAthletes(allAthletes));
	}
}
