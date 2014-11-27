package sorting.search;

import java.util.Arrays;

public class MergeAB
{

	public static void main(String[] args)
	{
		int[] A = new int[10];
		A[0] = 0;
		A[1] = 2;
		A[2] = 4;
		A[3] = 6;
		A[4] = 8;

		int[] B = { 1, 3, 5, 7, 9 };

		merge(A, B, 5);
		System.out.println(Arrays.toString(A));
	}

	private static void merge(int[] A, int[] B, int m)
	{
		int n = A.length - 1;
		int i = m - 1;
		int j = B.length - 1;

		while (i >= 0 && j >= 0)
		{
			if (B[i] > A[j])
			{
				A[n] = B[j--];
			}
			else
			{
				A[n] = A[i--];
			}

			n--;
		}

		while (j >= 0)
		{
			A[n] = B[j--];
		}

	}

}
