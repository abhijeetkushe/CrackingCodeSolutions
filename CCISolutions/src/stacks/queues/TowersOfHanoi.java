package stacks.queues;

import java.util.Arrays;

import stacks.queues.Stack.ArrayStack;

class Tower
{

	private Stack<Integer> stack;

	public Tower(int n)
	{
		stack = new ArrayStack<>(n);
	}

	public boolean push(Integer size)
	{
		if (stack.isEmpty() || (stack.peek() > size))
		{
			stack.push(size);
			return true;
		}
		else
		{
			return false;
		}
	}

	public Integer pop()
	{
		return stack.pop();
	}

	public int disks()
	{
		return stack.size();
	}

	public String toString()
	{
		return stack.toString();
	}

}

public class TowersOfHanoi
{

	public static void moveDisks(Tower source, Tower destination, Tower buffer, int n)
	{
		if (n > 0)
		{
			moveDisks(source, buffer, destination, n - 1);
			destination.push(source.pop());
			moveDisks(buffer, destination, source, n - 1);
		}
	}

	public static void main(String[] args)
	{
		int n = 8;
		Tower[] towers = {// source
		new Tower(n),
				// dest
				new Tower(n),
				// buffer
				new Tower(n) };

		for (int i = n; i >= 1; i--)
			towers[0].push(i);
		System.out.println(Arrays.toString(towers));

		moveDisks(towers[0], towers[1], towers[2], n);

		System.out.println(Arrays.toString(towers));

	}
}
