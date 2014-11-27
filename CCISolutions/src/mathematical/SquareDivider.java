package mathematical;

public class SquareDivider
{
	static class Line
	{
		Point a, b;

		Line(Point a, Point b)
		{
			this.a = a;
			this.b = b;
		}

	}

	static class Point
	{
		double x, y;

		Point(double x, double y)
		{
			this.x = x;
			this.y = y;
		}
	}

	static class Square
	{
		double left;
		double right;
		double bottom;
		double top;

		Square(double left, double top, double size)
		{
			this.left = left;
			this.top = top;
			this.bottom = top + size;
			this.right = left + size;
		}

		Point middle()
		{
			return new Point((left + right) / 2, (top + bottom) / 2);
		}

		static Line divider(Square a, Square b)
		{
			Point middlea = a.middle();
			Point middleb = b.middle();

			if (middlea == middleb)
			{
				return new Line(new Point(a.left, a.top), new Point(a.right, a.bottom));
			}
			else
				return new Line(middlea, middleb);
		}

	}

	public static void main(String[] args)
	{

	}
}
