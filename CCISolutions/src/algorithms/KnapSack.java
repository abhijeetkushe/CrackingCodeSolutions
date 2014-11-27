package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSack
{

	static class Item
	{
		int weight;
		int profit;

		Item(int weight, int profit)
		{
			this.weight = weight;
			this.profit = profit;
		}

		@Override
		public String toString()
		{
			return "Item [weight=" + weight + ", profit=" + profit + "]";
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + profit;
			result = prime * result + weight;
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			if (profit != other.profit)
				return false;
			if (weight != other.weight)
				return false;
			return true;
		}

	}

	public static void main(String[] args)
	{
		List<Item> items = new ArrayList<>();
		items.add(new Item(10, 4));
		items.add(new Item(8, 2));
		items.add(new Item(4, 1));
		items.add(new Item(2, 5));
		items.add(new Item(1, 3));

		int maxWeight = 4;

		List<Item> solution = getSack(items, maxWeight);
		
		System.out.println(solution);
	}

	private static List<Item> getSack(List<Item> items, int maxWeight)
	{
		int[][] opt = new int[items.size()][maxWeight];
		boolean[][] soln = new boolean[items.size()][maxWeight];
		boolean[] taken = new boolean[items.size()];
		for (int n = 1; n < items.size(); n++)
		{
			Item item = items.get(n);
			for (int w = 1; w < maxWeight; w++)
			{
				int option1 = opt[n - 1][w];

				int option2 = Integer.MIN_VALUE;

				if (item.weight <= w)
				{
					option2 = item.profit + opt[n][w - item.weight];
				}
				opt[n][w] = Math.max(option1, option2);

				soln[n][w] = option2 > option1;
			}
		}

		for(int i = items.size() - 1, w = maxWeight - 1; i >=0; i--)
		{
			if(soln[i][w]) 
			{
				taken[i] = true;
				w -= items.get(i).weight; 
			}
		}
		
		List<Item> solution = new ArrayList<>();
		for(int i = 0; i< taken.length; i++)
		{
			if(taken[i])
			{
				solution.add(items.get(i));
			}
		}
		return solution;
	}

}
