package stacks.queues;

import java.util.Arrays;

public interface Stack<T>
{
	void push(T value);

	T pop();

	T peek();
	
	int size();
	
	boolean isEmpty();
	
	@SuppressWarnings("unchecked")
	public static class ArrayStack<T> implements Stack<T>
	{
		private Object[] nodes;
		private int top = -1;

		public ArrayStack(int n)
		{
			nodes = new Object[n];
		}

		public void push(T value)
		{
			if (top == nodes.length - 1)
				throw new RuntimeException("Stack Full");
			nodes[++top] = value;
		}

		public T pop()
		{
			if (top >= 0)
				return (T) nodes[top--];
			else
				throw new RuntimeException("Stack Empty");
		}

		public T peek()
		{
			if (top >= 0)
				return (T) nodes[top];
			else
				return null;
		}

		public T popAtBottom()
		{
			if (top >= 0)
			{
				T elem = (T) nodes[0];
				for (int i = 0; i < top; i++)
					nodes[i] = nodes[i + 1];
				top--;
				return elem;
			}
			else
				return null;

		}

		@Override
		public int size()
		{
			return top + 1;
		}

		@Override
		public boolean isEmpty()
		{
			return top == -1;
		}

		@Override
		public String toString()
		{
			return "ArrayStack [nodes=" +  Arrays.asList(nodes).subList(0,top + 1) + ", top=" + top + "]";
		}
		
		
	}

	public static class LinkedListStack<T> implements Stack<T>
	{

		private Node top = null;
		private int size = 0;
		private class Node
		{
			private T value;
			private Node previous;

			Node(T value, Node previous)
			{
				this.value = value;
				this.previous = previous;
			}
		}

		public void push(T value)
		{
			top = new Node(value, top);
			size++;
		}

		public T pop()
		{
			if (top == null)
			{
				throw new RuntimeException("Empty Stack");
			}
			else
			{
				T value = top.value;
				top = top.previous;
				size--;
				return value;
			}
		}

		public T peek()
		{
			if (top != null)
				return top.value;
			else
				throw new RuntimeException("Empty Stack");
		}

		@Override
		public int size()
		{
			return size;			
		}

		@Override
		public boolean isEmpty()
		{
			return size == 0;
		}
	}
}


