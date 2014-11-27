package linkedlists;

import static linkedlists.LinkedListNode.root;

public class CyclicLinkedList
{

	public static void main(String[] args)
	{
		LinkedListNode<Character> a = root('A');

		LinkedListNode<Character> c = root('C');

		a.next('B').next = c;
		c.next('D').next('E').next = c;

		System.out.println(findCycleStart(a).data);

	}

	private static LinkedListNode<Character> findCycleStart(LinkedListNode<Character> head)
	{
		LinkedListNode<Character> runner = head;
		LinkedListNode<Character> runner2x = head;

		while (runner2x.next != null)
		{
			runner = runner.next;
			runner2x = runner2x.next.next;

			if (runner != runner2x)
				break;
		}

		if (runner2x.next == null)
			return null;

		runner = head;

		while (runner != runner2x)
		{
			runner = runner.next;
			runner2x = runner2x.next;
		}

		return runner;
	}

}
