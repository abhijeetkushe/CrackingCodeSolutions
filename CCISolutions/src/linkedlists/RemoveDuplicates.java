package linkedlists;

import static linkedlists.LinkedListNode.print;
import static linkedlists.LinkedListNode.root;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates
{

	public static void main(String[] args)
	{
		LinkedListNode<String> root = root("a");

		root
		.next("b")
		.next("c")
		.next("a")
		.next("d");
		
		System.out.println("Before removing duplicates");
		print(root);
		removeDuplicatesWithoutBuffer(root);
		System.out.println("After removing duplicates");
		print(root);

	}


	public static <T> void removeDuplicatesWithoutBuffer(LinkedListNode<T> current)
	{
		while (current != null)
		{
			LinkedListNode<T> runner = current.next;
			LinkedListNode<T> previous = current;
			while (runner != null)
			{
				if (current.data.equals(runner.data))
				{
					previous.next = runner.next;
				}
				else
				{
					previous = runner;
				}
				runner = runner.next;
			}
			current = current.next;
		}
	}

	public static <T> void removeDuplicatesWithBuffer(LinkedListNode<T> node)
	{
		Set<T> nodeSet = new HashSet<T>();
		LinkedListNode<T> previous = null;
		while (node != null)
		{
			if (nodeSet.contains(node.data))
			{
				previous.next = node.next;
				node.next = null;
			}
			else
			{
				nodeSet.add(node.data);
				previous = node;

			}
			node = node.next;
		}

	}
}
