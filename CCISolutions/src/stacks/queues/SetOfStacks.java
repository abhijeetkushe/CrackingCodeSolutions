package stacks.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
	List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

	public void push(int v) {
		incrementCurrentStackIfNeeded().push(v);
	}

	public int pop() {
		return decrementCurrentStackIfNeeded().pop();
	}
	
	public int popAt(int i)
	{
		int v = stacks.get(i).pop();
		if(stacks.size()-1>i);
			//rollDown(top);
		return v;
	}

	private void rollDown(int i) {
		Stack<Integer> buffer = new Stack<Integer>();
		while(!stacks.get(i).isEmpty())
			buffer.push(stacks.get(i).pop());
		while(!buffer.isEmpty())
			push(buffer.pop());
		
	}

	private Stack<Integer> decrementCurrentStackIfNeeded() {
		if(isCurrentStackEmpty())
			stacks.remove(stacks.size() - 1);
		return stacks.get(stacks.size() - 1);
	}

	private Stack<Integer> incrementCurrentStackIfNeeded() {
		if (isCurrentStackFull()) 
			stacks.add(new Stack<Integer>());
		return stacks.get(stacks.size() - 1);
	}

	private boolean isCurrentStackFull() {
		return stacks.get(stacks.size() - 1).size() == stacks.get(stacks.size() - 1).capacity();
	}
	
	private boolean isCurrentStackEmpty() {
		return stacks.get(stacks.size() - 1).isEmpty();
	}
}
