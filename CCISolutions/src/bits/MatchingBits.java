package bits;

public class MatchingBits
{
	private static enum NEXT_BIT_EQ
	{
		LARGER(0, 1)
		{
			@Override
			public int compute(int no)
			{
				if(no == 0x7FFFFFFF || no == 0) return no;
				return no + (int) Math.pow(2, swapBit(no));
			}
		},
		SMALLER(1, 0)
		{
			@Override
			public int compute(int no)
			{
				if (no == 1 || no == 0)
					return no;
				return no - (int) Math.pow(2, swapBit(no));
			}
		};

		final int currBit, prevBit;

		NEXT_BIT_EQ(int currBit, int prevBit)
		{
			this.currBit = currBit;
			this.prevBit = prevBit;
		}

		public abstract int compute(int no);

		protected int swapBit(int no)
		{
			int i = 0;
			int prevBit = -1;
			while (no >> i > 0)
			{
				int currBit = (no >> i) & 1;
				if (currBit == this.currBit && prevBit == this.prevBit)
				{
					break;
				}
				prevBit = currBit;
				i++;
			}
			return i - 1;
		}
	}

	private static class Numbers
	{
		int large;
		int small;

		Numbers(int large, int small)
		{
			this.large = large;
			this.small = small;
		}
	}

	public static Numbers next(int no)
	{
		return new Numbers(NEXT_BIT_EQ.LARGER.compute(no), NEXT_BIT_EQ.SMALLER.compute(no));

	}

	public static void main(String[] args)
	{
		Numbers nos = next(0);
		System.out.println(nos.large + " " + nos.small);
	}
}
