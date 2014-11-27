package stacks.queues;

import com.sun.istack.internal.NotNull;

public class ThreeStacks<T>
{
	private T[] items;

	private int[] tops = new int[] { 0, items.length / 3, items.length * 2 / 3 };

	@SuppressWarnings("unchecked")
	public ThreeStacks(int n)
	{
		items = (T[]) new Object[3 * n];
	}

	public void push(@NotNull T item, int stackNum)
	{
		validate(stackNum);
		if (!isFull(stackNum))
			items[++tops[stackNum - 1]] = item;
		else
			throw new IllegalStateException("Stack Full!!!");
	}

	public T pop(int stackNum)
	{
		validate(stackNum);

		return items[tops[stackNum - 1]--];
	}

	public T peek(int stackNum)
	{
		validate(stackNum);
		return items[tops[stackNum - 1]];
	}

	public boolean isFull(int stackNum)
	{
		validate(stackNum);
		return tops[stackNum - 1] == (stackNum * items.length / 3) - 1;
	}

	private void validate(int stackNum)
	{
		if (stackNum < 0 || stackNum > 3)
			throw new IllegalArgumentException("1 <= stackNum <= 3");
	}

	public static void main(String[] args)
	{

	}
}
