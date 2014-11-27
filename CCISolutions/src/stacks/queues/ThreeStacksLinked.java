package stacks.queues;

import java.lang.reflect.Array;

import com.sun.istack.internal.NotNull;

public class ThreeStacksLinked<T>
{
	private static class StackNode
	{
		Object value;
		int previous;
		private StackNode(Object value,int previous)
		{
			this.value = value;
			this.previous = previous;
		}	 
	}
	private static boolean free = false,occupied = true;
	private final StackNode[] items;
	private final boolean[] freeList;
	private int freeIndex = -1;
	private int[] tops = {-1, -1, -1};

	
	public ThreeStacksLinked(int n)
	{
		items = new StackNode[3*n];
		freeList = new boolean[3*n];
	}

	public void push(@NotNull T value, int stackNum)
	{
		validate(stackNum);
		int previousTop = tops[stackNum] ;
		items[tops[stackNum] = getFreeIndex()] = new StackNode(value, previousTop);
		freeList[tops[stackNum]] = occupied;
		
	}

	private int getFreeIndex()
	{
		if(freeIndex < freeList.length-1)
			return ++freeIndex;
		else
			for(int i = 0; i< freeList.length; i++)
			{
				if(freeList[i] == free) return i;
					continue;
			}
		throw new RuntimeException("Stack Full !!.Please pop atleast one stack to free space");
					
	}
	
	public T pop(int stackNum)
	{
		validate(stackNum);
		if(tops[stackNum] < 0) throw new RuntimeException("ERROR. Cannot pop empty stack");
		StackNode item = items[tops[stackNum]];
		freeList[tops[stackNum]] = free;
		tops[stackNum] = item.previous;
		return (T)item.value;
	}

	public T peek(int stackNum)
	{
		validate(stackNum);
		return (T)items[tops[stackNum]].value;
	}


	private void validate(int stackNum)
	{
		if (stackNum < 0 || stackNum > 3)
			throw new IllegalArgumentException("1 <= stackNum <= 3");
	}

	public static void main(String[] args)
	{
		ThreeStacksLinked<String> stacks= new ThreeStacksLinked<String> (3);
		stacks.push("A",0);
		stacks.push("B",0);
		stacks.push("C",1);
		stacks.push("D",2);
		stacks.push("E",1);
		stacks.push(stacks.pop(1),2);
		stacks.push(stacks.pop(0),1);
		System.out.println(stacks.peek(0));
		System.out.println(stacks.peek(1));
		System.out.println(stacks.peek(2));
		
	}
}
