package arrays.strings;

public class ZeroStriker
{
	static int[][] image = { {1, 2, 3, 4 }, {  1, 2, 3, 4 }, {  1, 2, 0, 4 }, {  1, 2, 3, 4 }, {  1, 2, 3, 4 } };

	public static void main(String[] args)
	{
		strikeOut(image);
	}
	
	private static void print(int[][] matrix)
	{
		int M = matrix.length;
		int N = matrix[0].length;
		StringBuilder sb = new StringBuilder(N * N);
		sb.append('\n');
		
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
				sb.append(image[i][j]).append(' ');
			sb.append('\n');
		}
		System.out.println(sb);
	}


	public static void strikeOut(int[][] matrix)
	{
		System.out.println("Before strike out");
		print(matrix);
		
		int[] M = new int[matrix.length];
		int[] N = new int[matrix[0].length];

		for (int m = 0; m < M.length; m++)
			for (int n = 0; n < N.length; n++)
				if (matrix[m][n] == 0)
				{
					M[m] = 1;
					N[n] = 1;
				}

		for (int m = 0; m < M.length; m++)
			for (int n = 0; n < N.length; n++)
				if (M[m] == 1 || N[n] == 1)
				{
					matrix[m][n] = 0;
				}

		System.out.println("After strike out");
		print(matrix);
	}

}
