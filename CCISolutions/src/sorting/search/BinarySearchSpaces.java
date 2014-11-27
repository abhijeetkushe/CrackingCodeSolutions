package sorting.search;

public class BinarySearchSpaces
{

	public static int search2(String[] msgs, String msg)
	{
		int l = 0;
		int u = msgs.length - 1;
		while (l < u)
		{
			//Eliminate all the trailing white space characters
			while ("".equals(msgs[u]) && u >= l)
			{
				u--;
			}

			int m = (l + u) / 2;

			while ("".equals(msgs[m]) && m <= u)
			{
				m++;
			}
			
			int comp = msg.compareTo(msgs[m]);
			if (comp == 0)
			{
				return m;
			}
			else
			{
				if (comp < 0)
				{
					u = m - 1;
				}
				else
				{
					l = m + 1;

				}

			}
		}
		return -1;
	}

	public static int search(String[] msgs, String msg)
	{
		int l = 0;
		int u = msgs.length - 1;

		while (l < u)
		{
			int m = (l + u) / 2;

			int um = m;
			int lm = m;

			while ("".equals(msgs[um]) && um <= u)
			{
				um++;
			}
			while ("".equals(msgs[lm]) && lm >= l)
			{
				lm--;
			}
			// -v -v
			// 0 -v
			// v 0
			// v -v invalid
			// v v

			int complm = "".equals(msgs[lm]) ? 1 : msg.compareTo(msgs[lm]);
			int compum = "".equals(msgs[um]) ? -1 : msg.compareTo(msgs[um]);

			int res = (int) (Math.signum(complm) + Math.signum(compum));
			if (res == 0)
			{
				return -1;
			}
			else
			{
				if (res < 0)
				{
					if (complm == 0)
					{
						return lm;
					}
					else
					{
						u = lm - 1;
					}
				}
				else
				{
					if (compum == 0)
					{
						return um;
					}
					else
					{
						l = um + 1;
					}

				}
			}

		}

		return -1;
	}

	public static void main(String[] args)
	{
		String[] arrs = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
		System.out.println(search2(arrs, "ball"));
	}
}
