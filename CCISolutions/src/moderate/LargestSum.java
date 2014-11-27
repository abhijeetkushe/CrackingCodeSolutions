package moderate;

import java.util.ArrayList;
import java.util.List;

public class LargestSum
{

	public static void main(String[] args)
	{
		
		int[] nos = { -2, -8, -3, -2, -4, -2, -10 };
		
		int sum = 0;
		int largestSum = 0;
		List<Integer> seq = new ArrayList<>();
		List<Integer> largestSeq = null;
		for(int no : nos)
		{
			sum += no;
			seq.add(no);
			if(sum > largestSum)
			{
				largestSum = sum;
				largestSeq = new ArrayList<>(seq);
			}
			else if(sum < 0)
			{
				sum = no;
				seq.clear();
				seq.add(no);
			}
		}
		
		System.out.println(largestSum + " "+largestSeq);
		
	}
	
	
	public static void main2(String[] args)
	{
		int[] nos = { 2, -8, 3, -2, 4, -10 };

		int largestSum = 0;

		List<Integer> largestSeq = new ArrayList<>();

		int sum = 0;
		List<Integer> seq = new ArrayList<>();
		for (int no : nos)
		{
			int prevsum = sum;
			sum += no;

			seq.add(no);

			if (sum < largestSum)
			{
				if(prevsum > largestSum)
				{	
					largestSum = prevsum;
				}
				sum = no;
				largestSeq = new ArrayList<>(seq);
				seq.clear();
				seq.add(no);
			}
		}

		System.out.println(largestSeq);
	}
}
