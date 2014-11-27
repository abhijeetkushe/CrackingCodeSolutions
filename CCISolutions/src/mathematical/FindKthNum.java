package mathematical;

import java.util.ArrayList;
import java.util.List;

public class FindKthNum
{

	static int find(int k)
	{
		List<Integer> nums357 = new ArrayList<>();
		
		int count3 = 0;
		int count5 = 0;
		int count7 = 0;

		nums357.add(1);
		
		while(nums357.size() <  k)
		{
			int num = Math.min(nums357.get(count3) * 3, Math.min(nums357.get(count5) * 5, nums357.get(count7) * 7));
			
			if(num == nums357.get(count3) * 3) count3++;
			if(num == nums357.get(count5) * 5) count5++;
			if(num == nums357.get(count7) * 7) count7++;
			
			nums357.add(num);
		}
		
		return nums357.get(k - 1);
	}
	
	public static void main(String[] args)
	{
		System.out.println(find(13));
	}

}