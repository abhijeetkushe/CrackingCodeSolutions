package mathematical;

import java.util.HashMap;
import java.util.Map;

public class BestLine
{
	static double epsilon = 0.0001;
	static class Point
	{
		double x,y;
		
		Point(double x, double y)
		{
			this.x = x;
			this.y = y;
		}
	}

	static class Line
	{
		double slope;
		double yintercept;
		boolean infiniteSlope = false;
		
		Line(Point a, Point b)
		{
			if(Math.abs(a.x - b.x) > epsilon)
			{
				slope = (a.y - b.y)/(a.x - b.x);	
				yintercept = a.y - a.x*slope;
			}else
			{
				infiniteSlope = true;
				yintercept = a.x;
			}	
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + (infiniteSlope ? 1231 : 1237);
			long temp;
			temp = Double.doubleToLongBits(slope);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(yintercept);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public String toString()
		{
			return "Line [slope=" + slope + ", yintercept=" + yintercept + ", infiniteSlope=" + infiniteSlope + "]";
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Line other = (Line) obj;
			if (infiniteSlope != other.infiniteSlope)
				return false;
			if (Double.doubleToLongBits(slope) != Double.doubleToLongBits(other.slope))
				return false;
			if (Double.doubleToLongBits(yintercept) != Double.doubleToLongBits(other.yintercept))
				return false;
			return true;
		}
		
	}


	static Line findBestLine(Point[] points)
	{
		Line bestLine = null;
		Map<Line, Integer> pointCount = new HashMap<>();
		for(int i = 0; i < points.length; i++)
		{
			for(int j = 0; j < points.length; j++)
			{
				Line line = new Line(points[i], points[j]);
				if(pointCount.containsKey(line))
				{
					pointCount.put(line, pointCount.get(line) + 1);
				}else
				{
					pointCount.put(line, 1);
				}
				
				if(bestLine == null || pointCount.get(line) > pointCount.get(bestLine))
				{
					bestLine = line;
				}
			}
		}
		
		
		return bestLine;
	}
	
	
	public static void main(String[] args)
	{
		Point[] points = {new Point(2,4), new Point(4,8), new Point(1,3), new Point(3,9), new Point(1,2)};
		
		System.out.println(findBestLine(points));
	}

}