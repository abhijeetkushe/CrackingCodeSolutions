package linkedlists;

import java.util.Iterator;
import java.util.LinkedList;

import static linkedlists.LinkedListNode.print;
import static linkedlists.LinkedListNode.root;

public class Sum
{

	public static void main(String[] args)
	{

		LinkedListNode<Integer> a = root(3);
		a.next(1).next(5).next(3);

		LinkedListNode<Integer> b = root(5);

		b.next(9).next(2);

		print(recursiveSum(a, b, 0));

		LinkedList<Integer> a1 = new LinkedList<Integer>();
		a1.add(3);
		a1.add(1);
		a1.add(5);
		a1.add(3);

		LinkedList<Integer> b1 = new LinkedList<Integer>();
		b1.add(5);
		b1.add(9);
		b1.add(2);

		System.out.println("a = " + printLinkedList(a1.iterator()));
		System.out.println("b = " + printLinkedList(b1.iterator()));
		System.out.println("sum = " + printLinkedList(sum(a1.iterator(), b1.iterator())));

	}

	// (3513) 3->1->5
	// (295) 5->9->2
	// (1023) 8->0->8

	private static LinkedListNode<Integer> sum(LinkedListNode<Integer> a, LinkedListNode<Integer> b)
	{

		LinkedListNode<Integer> zero = root(0);
		int carry = 0;
		LinkedListNode<Integer> runner = null;
		LinkedListNode<Integer> sum = null;

		while (a != zero || b != zero)
		{
			int value = (carry + a.data + b.data) % 10;
			carry = (carry + a.data + b.data) / 10;
			if (runner != null)
			{
				runner = runner.next(value);
			}
			else
			{
				runner = root(value);
				sum = runner;
			}

			a = a.next != null ? a.next : zero;
			b = b.next != null ? b.next : zero;

		}

		if (carry != 0)
			runner.next(carry);

		return sum;

	}

	private static LinkedListNode<Integer> recursiveSum(LinkedListNode<Integer> a, LinkedListNode<Integer> b, int carry)
	{
		if (a == null && b == null)
			return null;
		int value = carry;
		if (a != null)
			value += a.data;
		if (b != null)
			value += b.data;

		carry = value / 10;
		LinkedListNode<Integer> sum = root(value % 10);
		sum.next = recursiveSum(a != null ? a.next : null, b != null ? b.next : null, carry);
		return sum;
	}

	private static String printLinkedList(Iterator<Integer> result)
	{
		StringBuilder sb = new StringBuilder();
		while (result.hasNext())
			sb.append(result.next() + "->");
		sb.replace(sb.length() - 2, sb.length(), "");
		return sb.toString();
	}

	public static Iterator<Integer> sum(Iterator<Integer> a, Iterator<Integer> b)
	{
		LinkedList<Integer> c = new LinkedList<Integer>();

		int carry = 0;

		while (a.hasNext() && b.hasNext())
		{
			int result = carry + a.next() + b.next();
			int remainder = result % 10;
			carry = result / 10;
			c.add(remainder);
		}
		return c.iterator();
	}

}
