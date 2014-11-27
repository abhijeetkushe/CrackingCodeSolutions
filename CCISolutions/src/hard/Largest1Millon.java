package hard;

import java.util.PriorityQueue;

public class Largest1Millon
{

	static int MILLION = (int) Math.pow(10, 6);

	private static void printLargestMillion(Integer[] billionNos)
	{
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int counter = 0;
		for (int i = 0; i < billionNos.length; i++)
		{
			if (counter == MILLION)
			{
				minHeap.remove();
				counter--;
			}

			minHeap.offer(billionNos[i]);
			counter++;

		}

	}

	private static void printLargestMillion2(Integer[] billions, int lo, int hi)
	{
		int pivot = partition(billions, 0, billions.length - 1);
		if (pivot < MILLION)
		{
			printLargestMillion2(billions, 0, pivot);
		}
		else if (pivot > MILLION)
		{
			printLargestMillion2(billions, pivot, 0);
		}
		else
		{
			print(billions, pivot, pivot - 1);
		}

	}
	private static void print(Integer[] billions, int pivot, int i)
	{
		// TODO Auto-generated method stub

	}

	// 4 5 2 1 7
	// 1 5 2 4 7
	// 1 2 5 4 7
	// 1 2 4 5 7
	private static int partition(Integer[] billionNos, int first, int last)
	{
		int lo = first, hi = last;
		int pivot = billionNos[first];
		while (lo < hi)
		{
			while (billionNos[first] > pivot)
				lo++;

			while (billionNos[last] < pivot)
				hi--;

			swap(billionNos, first, last);
		}
		swap(billionNos, lo, last);
		return pivot;
	}

	private static void swap(Integer[] billionNos, int a, int b)
	{
		billionNos[a] = billionNos[a] + billionNos[b];
		billionNos[b] = billionNos[a] - billionNos[b];
		billionNos[a] = billionNos[a] - billionNos[b];
	}

	public static void main(String[] args)
	{

	}

}
