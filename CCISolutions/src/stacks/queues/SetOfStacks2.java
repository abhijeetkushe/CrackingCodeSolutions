package stacks.queues;

import java.util.ArrayList;
import java.util.List;

class SetOfStacks2<Item> implements Stack<Item>{

	private static final int STACK_THRESHOLD = 10;
	private List<ArrayStack<Item>> stacks = new ArrayList<>();
	private int currentStackIndex =  -1;
	public void push(Item value) {	
		currentStackOrIncrement().push(value);
	}

	public Item pop() {
		return currentStackOrDecrement().pop();
	}

	public Item peek() {
		return currentStack().peek();
	}
	
	public Item popAt(int stackNum) {
		
		Item item = stacks.get(stackNum).pop();
		
		while(stackNum < stacks.size() -1)
		{	
			stacks.get(stackNum).push(stacks.get(stackNum + 1).popAtBottom());
			if(stacks.get(stackNum + 1).isEmpty())
			{
				stacks.remove(stackNum + 1);	
			}
			stackNum++;	
				
		}	
			return item;
	}
	
	private ArrayStack<Item> currentStackOrIncrement() {

		if(currentStackIndex < 0 || stacks.get(currentStackIndex).size() == STACK_THRESHOLD) 
		{
			stacks.add(new ArrayStack<Item>(10));
			currentStackIndex++;
		}	
		return stacks.get(currentStackIndex);
		
	}
	
	private ArrayStack<Item> currentStackOrDecrement() {

		if(currentStackIndex > 0 )
		{
			if(stacks.get(currentStackIndex).isEmpty()) 
				stacks.remove(currentStackIndex--);
		}
		else
			throw new RuntimeException("Stack Empty");
		return stacks.get(currentStackIndex);
		
	}
	
	private ArrayStack<Item> currentStack() {

		if(currentStackIndex > 0)
			return stacks.get(currentStackIndex);
		else
			throw new RuntimeException("Stack Empty");
	}
	
	public static void main(String[] args)
	{
		SetOfStacks2<Integer> infiniteArrayStack = new SetOfStacks2<>();
		for(int i = 0 ; i < 100; i++)
			infiniteArrayStack.push(i);
			
		System.out.println(infiniteArrayStack.stacks);	
		infiniteArrayStack.pop();	
		infiniteArrayStack.pop();	
		infiniteArrayStack.pop();	
		infiniteArrayStack.pop();	
		System.out.println(infiniteArrayStack.stacks);
		infiniteArrayStack.popAt(1);
		infiniteArrayStack.popAt(1);
		infiniteArrayStack.popAt(1);
		infiniteArrayStack.popAt(1);
		infiniteArrayStack.popAt(1);
		infiniteArrayStack.popAt(1);
		
		System.out.println(infiniteArrayStack.stacks);		
		
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}

}