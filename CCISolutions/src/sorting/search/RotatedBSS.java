package sorting.search;

public class RotatedBSS
{

	public static int search(int[] arr, int no, int start, int end)
	{
		while (start <= end)
		{
			int m = (start + end) / 2;
			System.out.println(start + " " + m + " " + end);
			if (arr[m] == no)
			{
				return m;
			}

			if (arr[start] < arr[end])
			{
				if (no < arr[m])
				{
					end = m - 1;
				}
				else
				{

					start = m + 1;
				}

			}
			else if (arr[start] < arr[m])
			{
				//reset point right
				if (no > arr[start] && no < arr[m] )
				{
					end = m - 1;
				}
				else
				{
					start = m + 1;
				}

			}
			else
			{
				//reset point left
				if (no > arr[m] && no < arr[end])
				{
					start = m + 1;
				}
				else
				{
					end = m- 1;
				}

			}

		}

		return -1;

	}

	// 0,1,2,3,4,5,6,7,8,9
	// 1,2,3,4,5,6,7,8,9,0
	// 2,3,4,5,6,7,8,9,0,1
	// 9,0,1,2,3,4,5,6,7,8
	// 8,9,0,1,2,3,4,5,6,7

	public static void main(String[] args)
	{
		int[] nos = { 8, 9, 0, 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(search(nos, 9, 0, 9));
	}

}
