package stacks.queues;

import stacks.queues.Stack.ArrayStack;

@SuppressWarnings("unchecked")
public class StackWithMin<T extends Comparable<T>>
{
	int top = -1;
	Object[] nodes;
	Stack<T> minNodes;

	public StackWithMin(int n)
	{
		nodes = new Object[n];
		minNodes = new ArrayStack<T>(n);
	}

	public void push(T value)
	{
		if (top == -1 || value.compareTo(minNodes.peek()) < 0)
			minNodes.push(value);
		nodes[++top] = value;
	}

	public T pop()
	{
		T value = (T) nodes[top--];
		if (value.equals(min()))
			minNodes.pop();
		return value;
	}

	public T min()
	{
		return minNodes.peek();
	}

	public static void main(String[] args)
	{
		StackWithMin2 stack = new StackWithMin2(10);
		stack.push(3);
		stack.push(9);
		stack.push(2);
		stack.push(5);
		stack.push(4);
		System.out.println(stack.min());
		stack.pop();
		stack.push(6);
		stack.push(1);
		stack.push(8);
		stack.push(7);
		System.out.println(stack.min());
		stack.pop();

	}
}

class StackWithMin2
{
	int top = -1;
	int[] elems;
	int min ;

	StackWithMin2(int n)
	{
		elems = new int[n];
	}

	void push(int elem)
	{
		if (elem < min || min == 0){
			min = elem;
			elem = Math.abs(min - elem);
		}	
		elems[++top] = elem;

	}

	int pop()
	{
		
		int elem = elems[top--];
		if(elem < min)
		{
			elem +=min;
			min = elem;
		}	
		return elem;
		
	}

	int peek()
	{
		if( elems[top] < min)
		{
			return elems[top] + min;
		}
		return elems[top];
	}

	int min()
	{
		return min;
	}

}
