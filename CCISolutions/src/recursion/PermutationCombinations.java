package recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationCombinations
{

	public static void printParanthesis(int n)
	{
		printParanthesis(new StringBuilder(n * 2), n, n, 0);
	}

	public static void printParanthesis(StringBuilder sb, int lc, int rc, int count)
	{
		if (lc == 0 && rc == 0)
		{
			System.out.println(sb);
		}
		else
		{
			if (lc > 0)
			{
				printParanthesis(sb.replace(count, count + 1, "("), lc - 1, rc, count + 1);
			}
			if (rc > lc)
			{
				printParanthesis(sb.replace(count, count + 1, ")"), lc, rc - 1, count + 1);
			}
		}
	}

	public static List<String> paranthesisPairs(int n)
	{
		if (n == 1)
		{
			List<String> parans = new ArrayList<>();
			parans.add("()");
			return parans;
		}
		List<String> parans = new ArrayList<>();
		List<String> paransTemp = paranthesisPairs(n - 1);
		for (String paran : paransTemp)
		{
			if (!"()".equals(paran))
			{
				parans.add(paran + "()");
			}
			parans.add("()" + paran);
			parans.add("(" + paran + ")");
		}
		return parans;
	}

	public static void main(String[] args)
	{
		printParanthesis(3);
	}
}
