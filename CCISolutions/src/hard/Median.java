package hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Stream;

public class Median
{
	static Queue<Integer> minHeap;

	static Queue<Integer> maxHeap;

	static
	{
		minHeap = new PriorityQueue<>(new MinComparator());

		maxHeap = new PriorityQueue<>(new MaxComparator());
	}

	private static class MinComparator implements Comparator<Integer>
	{

		@Override
		public int compare(Integer o1, Integer o2)
		{

			return o1.compareTo(o2);
		}

	}

	private static class MaxComparator implements Comparator<Integer>
	{

		@Override
		public int compare(Integer o1, Integer o2)
		{

			return o2.compareTo(o1);
		}

	}

	private static void add(Stream<Integer> randomNos)
	{

		randomNos.forEach(no ->
		{

			System.out.print(no + " ");
			if (minHeap.size() == 0 || no < minHeap.peek())
			{
				maxHeap.add(no);
			}
				else
				{
					minHeap.offer(no);
				}

				int diff = minHeap.size() - maxHeap.size();

				if (Math.abs(diff) > 1)
				{
					if (diff < 0)
					{
						minHeap.offer(maxHeap.poll());
					}
					else
					{
						maxHeap.offer(minHeap.poll());
					}
				}
			});

	}
	private static int median()
	{
		int median = 0;

		if ((minHeap.size() + maxHeap.size()) % 2 == 0)
		{
			median = (minHeap.peek() + maxHeap.peek()) / 2;
		}
		else
		{
			if (maxHeap.size() > minHeap.size())
			{
				median = maxHeap.peek();
			}
			else
			{
				median = minHeap.peek();
			}
		}

		return median;
	}

	public static void main(String[] args)
	{
		add(new Random().ints(11, 1, 100).boxed());
		System.out.println();
		System.out.println(median());
	}
}
