package linkedlists;

import static linkedlists.LinkedListNode.print;
import static linkedlists.LinkedListNode.root;

public class DeleteNode
{

	public static void main(String[] args)
	{
		LinkedListNode<String> root = root("a");

		root.next("b").next("c").next("a").next("d");

		System.out.println("Before deletion");
		print(root);

		delete(root.next.next.next);

		System.out.println("After deletion");
		print(root);

	}

	private static boolean delete(LinkedListNode<String> node)
	{
		if (node == null || node.next == null)
			return false;

		LinkedListNode<String> next = node.next;
		node.data = next.data;
		node.next = next.next;

		next.next = null;
		return true;
	}

}
