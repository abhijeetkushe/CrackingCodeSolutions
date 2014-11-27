package linkedlists;

import static linkedlists.LinkedListNode.root;

import java.util.Iterator;
import java.util.LinkedList;

public class NthFromLast<T>
{

	public static void main(String[] args)
	{

		LinkedListNode<Integer> root = root(1);

		LinkedListNode<Integer> current = root;
		for (int i = 2; i <= 30; i++)
			current = current.next(i);

		NthFromLast<Integer> function = new NthFromLast<>();
		System.out.println(function.nthToLast(root, 10).data);

		LinkedList<String> linkedList = new LinkedList<String>();
		for (int c = 1; c <= 30; c++)
		{
			linkedList.add(Integer.valueOf(c).toString());
		}
		System.out.println(nthFromLast(linkedList, 10));
	}

	public static String nthFromLast(LinkedList<String> strs, int n)
	{
		String nthFromLast = null;
		Iterator<String> fromFirstIterator = strs.iterator();
		Iterator<String> nthFromFirstItrator = strs.listIterator(n);
		while (nthFromFirstItrator.hasNext())
		{
			nthFromFirstItrator.next();
			nthFromLast = fromFirstIterator.next();
		}
		return nthFromLast;

	}

	public LinkedListNode<T> nthToLast(LinkedListNode<T> root, int n)
	{
		LinkedListNode<T> first = root;
		LinkedListNode<T> nthFromFirst = nthFrom(first, n);

		while ((nthFromFirst = nthFromFirst.next) != null)
			first = first.next;
		return first;
	}

	private LinkedListNode<T> nthFrom(LinkedListNode<T> node, int n)
	{
		for (int i = 0; i < n && node.next != null; i++)
			node = node.next;
		return node;
	}
}
