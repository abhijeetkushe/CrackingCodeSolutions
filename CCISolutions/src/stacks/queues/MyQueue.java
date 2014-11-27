package stacks.queues;

import java.util.stream.IntStream;

import stacks.queues.Stack.ArrayStack;


interface Queue<T>
{
	T first();
	void offer(T elem); 
}
public class MyQueue<T> implements Queue<T>
{
	private Stack<T> put = new ArrayStack<T>(10),get = new ArrayStack<T>(10);
	
	public T first()
	{
		if(!get.isEmpty())
		{
			return get.pop();
		}
		else
		{
			while(!put.isEmpty())
				get.push(put.pop());
			return get.pop();	
		}
				
	}
	
	public void offer(T item) {
		put.push(item);
	}
	
	@Override
	public String toString()
	{
		return put.toString() + " "+get.toString();
	}
	
	public static void main(String[] args)
	{
		Queue<Integer> myQueue = new MyQueue<Integer>();
		
		IntStream.range(0,10).forEach(no -> myQueue.offer(no));
		
		System.out.println(myQueue);
		
		myQueue.first();

		IntStream.range(10,15).forEach(no -> myQueue.offer(no));

		myQueue.first();

		System.out.println(myQueue);

	}
}