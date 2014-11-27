package mathematical;

public class Operations
{

	static int add(int a, int b)
	{
		return a + b;
	}

	static int sub(int a, int b)
	{
		return add(a, neg(b));

	}

	static int neg(int a)
	{
		int d = a < 0 ? 1 : -1;
		int neg = a;
		while (a != 0)
		{
			neg += d;
			a += d;
		}
		return neg;

	}

	static int mul(int a, int b)
	{
		if (a < b)
			mul(b, a);
		int res = 0;
		int d = b < 0 ? 1 : -1;
		while (b != 0)
		{
			res = add(res, a);
			b += d;
		}

		return d == 1 ? neg(b) : b;
	}

	static class Result
	{
		int quotient;
		int remainder;

		Result(int quotient, int remainder)
		{
			this.quotient = quotient;
			this.remainder = remainder;
		}

	}

	static Result div(int a, int b)
	{		
		int modA = Math.abs(a);
		int modB = Math.abs(b);
		int res = modA;
		int quotient = 0;
		while(res != 0 && res > modB)
		{
			res = sub(res, modB);
			quotient++;
		}
		if(sign(a) != sign(b))
		{
			quotient = neg(quotient);
		}
		int remainder = sub(a, res);
		return new Result(quotient, remainder);
	}

	static int sign(int a)
	{
		if(a < 0) return -1; else return 1;
	}
	
	static double add(double a, double b)
	{
		return a + b;
	}

	static double sub(double a, double b)
	{
		return add(a, -b);
	}

	static double mul(double a, double b)
	{
		double result = 0;
		for (int i = 1; i <= b; i++)
		{
			result = add(result, a);
		}

		if ((b - (int) b) == 0)
		{
			return result;
		}
		else
		{
			double decimal = b - (int) b;
			int i = 0;
			while (decimal < 1)
			{
				decimal = add(decimal, 10);
				i++;
			}
			add(10, i);
			return add(result, add(add(a, decimal), -add(10, i)));
		}
	}

	public static void main(String[] args)
	{
		System.out.println((23.23 + 24.23) == add(23.23, 24.23));
		System.out.println((23.23 - 24.23) == sub(23.23, 24.23));
		System.out.println((23.23 * 2) == mul(23.23, 2));
		System.out.println(Math.round(23.23 * 12.22) == Math.round(mul(23.23, 12.22)));
	}

}
