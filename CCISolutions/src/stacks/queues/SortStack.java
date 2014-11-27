package stacks.queues;

import java.util.Random;

import stacks.queues.Stack.ArrayStack;


public class SortStack 
{

	public static <T extends Comparable<T>> Stack<T> sort(Stack<T> stack)
	{
		Stack<T> s2 = new ArrayStack<>(stack.size());

		while(!stack.isEmpty())
		{
			T elem = stack.pop();	
			while(!s2.isEmpty() && s2.peek().compareTo(elem) > 0)
			{
				stack.push(s2.pop());
			}
			s2.push(elem);

		}		
		return s2;		
	}

//	public static void sort1(Stack<T> stack)
//	{
//		
//	}
	
	public static void main(String[] args)
	{
		Stack<Integer> s1 = new ArrayStack<>(10);
		
		new Random(1).ints(10,1,10).forEach(no -> s1.push(no));
		
		System.out.println(s1);
		Stack<Integer> s2 = sort(s1);
		System.out.println(s2);
	}
}