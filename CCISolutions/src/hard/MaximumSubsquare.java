package hard;

enum Color
{
	BLACK, WHITE
}

public class MaximumSubsquare
{
	static class Square
	{
		int x, y, side;

		@Override
		public String toString()
		{
			return "Square [x=" + x + ", y=" + y + ", side=" + side + "]";
		}

	}
	static Color W = Color.WHITE;
	static Color B = Color.BLACK;
	static Color[][] matrix = {
			{ W, W, W, W, W },
			{ W, B, B, W, W },
			{ W, B, B, B, W },
			{ W, B, B, B, W },
			{ W, B, W, B, W } };
	/*
	 * Top down sweep algorithm
	 */
	static Square findMaxSubsquare()
	{
		Square maxSubSquare = new Square();
		for (int rowNo = 0; (matrix.length - rowNo) > maxSubSquare.side; rowNo++)
		{
			Square subSquare = scanSubSquares(rowNo);
			if (subSquare.side > maxSubSquare.side)
			{
				maxSubSquare = subSquare;
			}
		}
		return maxSubSquare;
	}

	static boolean isSquare(int x, int y, int side)
	{

		for (int row = x; row < Math.min(x + side, matrix.length); row++)
		{
			if (matrix[row][y] != B || matrix[row][y + side - 1] != B)
			{
				return false;
			}
		}

		for (int col = y; col < Math.min(y + side, matrix.length); col++)
		{
			if (matrix[col][x] != B || matrix[col][x + side - 1] != B)
			{
				return false;
			}
		}

		return true;
	}
	static Square scanSubSquares(int rowNo)
	{
		Square maxsquare = new Square();

		int colLeft = -1;
		int colRight = -1;
		for (int col = 0; col < matrix.length; col++)
		{
			if (matrix[rowNo][col] == B)
			{
				if (colLeft < 0)
				{
					colLeft = col;
				}
			}
			else
			{
				if (colLeft >= 0)
				{
					colRight = col - 1;
				}
			}

			if (colLeft > -1 && colRight > -1)
			{
				Square square = findMaxSquare(colLeft, colRight, rowNo);

				if (square.side > maxsquare.side)
				{
					maxsquare = square;
				}
			}
		}

		return maxsquare;
	}
	private static Square findMaxSquare(int colLeft1, int colRight1, int rowNo)
	{
		Square maxsquare = new Square();
		int colLeft = colLeft1;
		int colRight = colRight1;
		while (colRight - colLeft > 0)
		{
			while (colRight >= colLeft)
			{
				int sideTemp = colRight - colLeft + 1;

				if (isSquare(rowNo, colLeft, sideTemp))
				{
					if (sideTemp > maxsquare.side)
					{
						maxsquare = new Square();
						maxsquare.x = rowNo;
						maxsquare.y = colLeft;
						maxsquare.side = sideTemp;
					}
				}

				colLeft++;
			}
			colRight--;
		}
		return maxsquare;
	}
	public static void main(String[] args)
	{
		Square maxSubsquare = findMaxSubsquare();
		System.out.println(maxSubsquare);
	}
}
