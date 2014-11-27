package recursion;

import java.util.Arrays;

public class Paint
{
	public static void fill(int[][] screen, int x, int y, int color, StringBuilder sb)
	{
		if (x >= 0 && x < screen.length && y >= 0 && y < screen.length && screen[x][y] == 0)
		{
			screen[x][y] = color;
			fill(screen, x - 1, y, color, sb.append("*"));
			fill(screen, x + 1, y, color, sb.append("*"));
			fill(screen, x, y - 1, color, sb.append("*"));
			fill(screen, x, y + 1, color, sb.append("*"));

		}
	}

	public static void main(String[] args)
	{
		int[][] screen = { { 0, 0, 2, 0 }, { 1, 0, 2, 0 }, { 1, 0, 1, 0 }, { 1, 0, 0, 0 } };

		Arrays.asList(screen).forEach(row -> System.out.println(Arrays.toString(row)));
		StringBuilder sb = new StringBuilder();
		fill(screen, 1, 1, 1, sb.append("*"));
		System.out.println("============");
		Arrays.asList(screen).forEach(row -> System.out.println(Arrays.toString(row)));
		System.out.println("Number of recursions " + sb.length());
	}
}
