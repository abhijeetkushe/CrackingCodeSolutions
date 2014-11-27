package mathematical;


public class InterceptionCheck
{
	static double epsilon = 0.000001;
	
	static class Line2
	{
		double yintercept, slope;
		public Line2(double yintercept, double slope)
		{
			this.yintercept = yintercept;
			this.slope = slope;
		}
		
		public boolean check(Line2 b)
		{
				return Math.abs(slope - b.slope) > epsilon || Math.abs(yintercept - b.yintercept) < epsilon; 
			
		}
		
	}
	
	static class Line
	{
		double x1, x2, y1, y2;
		
		Line(double x1, double x2, double y1, double y2)
		{
			this.x1 = x1; this.x2 = x2;
			this.y1 = y1; this.y2 = y2;
		}
		
		double slope()
		{
			return (double)(y2 - y1)/(x2 - x1);
		}
		
		public boolean equals(Line b)
		{
			return Math.abs(x1 - b.x1) < epsilon && Math.abs(x2 - b.x2) < epsilon  && Math.abs(y1 - b.y1) < epsilon && Math.abs(y2 - b.y2) < epsilon;
		}
	}

	private static boolean check(Line a, Line b)
	{
		return !a.equals(b) && Math.abs(a.slope() - b.slope()) > epsilon; 
	}

	public static void main(String[] args)
	{
		Line l1 = new Line(2.2322212, 3.2322221, 1.2322212 ,1.232221);
		Line l2 = new Line(2.2322211, 3.2322222, 1.2322213,1.232222);
	
		System.out.println(check(l1, l2));
		l1 = new Line(2.2322212, 3.2322221, 1.3222212 ,1.232221);
		l2 = new Line(2.2322211, 3.2322222, 23.2322213,1.232222);

		System.out.println(check(l1, l2));		
		
		Line2 l3 = new Line2(2.2322222, 5);
		Line2 l4 = new Line2(2.2322212, 5);
		System.out.println(l3.check(l4));
		
		l3 = new Line2(2.2322222, 5);
		l4 = new Line2(2.232232, 8);
		
		System.out.println(l3.check(l4));
	}
}