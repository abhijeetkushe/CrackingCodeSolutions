package recursion;

import java.util.Arrays;

public class NQueens
{

	public static void placeQueens(int[][] board, int[] columnsForRows, int n)
	{
		if (n < 8)
		{	
			for (int i = 0; i < board.length; i++)
			{
				columnsForRows[n] = i;
				if (checkRow(board, columnsForRows, n))
				{
					placeQueens(board, columnsForRows, n + 1);
				}
			}
		}
	}	

	private static boolean checkRow(int[][] board, int[] columnsForRows, int n)
	{
		for (int i = 0; i < n; i++)
		{
			int diff = Math.abs(columnsForRows[i] - columnsForRows[n]);
			if (diff == 0 || diff == n - i)
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		int[][] chessBoard = new int[8][8];

		//Arrays.asList(chessBoard).forEach(row -> System.out.println(Arrays.toString(row)));
		int[] columnsForRows =  new int[chessBoard.length];
		placeQueens(chessBoard, columnsForRows, 0);
		System.out.println(Arrays.toString(columnsForRows));
		//Arrays.asList(chessBoard).forEach(row -> System.out.println(Arrays.toString(row)));
	}

}
