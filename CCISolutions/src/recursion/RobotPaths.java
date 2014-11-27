package recursion;

public class RobotPaths
{
	public static int possiblePaths(int[][] grid, int x, int y)
	{

		if(x == grid.length - 1 || y == grid.length -1)
		{
			return 1;
		}
		return possiblePaths(grid, x+ 1, y) + possiblePaths(grid,x, y+1);
		
//		if (x <= grid.length - 2 && y <= grid.length - 2)
//		{
//			if(x == y)
//			{
//				return 2 + possiblePaths(grid, x, y +1) + possiblePaths(grid, x + 1, y);
//			}else if(x > y) 
//			{
//				return 1 + possiblePaths(grid, x, y + 1);
//			}
//			{
//				return 1 + possiblePaths(grid, x + 1, y);
//			}
//		}
//		else 
//		{
//			return 0;
//		}

	}

	public static int possiblePaths2(int[][] grid, int x, int y)
	{

		int possiblePaths = 0;
		if (x != grid.length - 1 && grid[x + 1][y] == 0)
		{
			possiblePaths++;
		}
		if (y != grid.length - 1 && grid[x][y + 1] == 0)
		{
			possiblePaths++;
		}
		if (x < grid.length - 1)
		{
			possiblePaths += possiblePaths2(grid, x + 1, y);
		}
		if (y < grid.length - 1)
		{
			possiblePaths += possiblePaths2(grid, x, y + 1);
		}

		return possiblePaths;
	}

	public static void main(String[] args)
	{
		int[][] grid = new int[4][4];
		grid[1][3] = 1;
		grid[2][3] = 1;
		grid[3][2] = 1;
		System.out.println(possiblePaths(grid, 0, 0));
	}
}
