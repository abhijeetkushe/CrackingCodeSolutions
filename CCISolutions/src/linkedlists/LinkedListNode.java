package linkedlists;

public class LinkedListNode<T>
{
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data)
	{
		this.data = data;
	}

	 public LinkedListNode<T> next (T data)
	{
		return this.next = new LinkedListNode<T>(data);
	}
	
	 static <T> LinkedListNode<T> root(T data) 
	{
		return new LinkedListNode<T>(data);
	}
	 
	 public static <T> void print(LinkedListNode<T> root)
		{
			StringBuilder sb = new StringBuilder(10);
			LinkedListNode<T> node = root;
			while (node != null)
			{
				sb.append(node.data + "->");
				node = node.next;
			}
			System.out.println(sb.substring(0, sb.length() - 2));

		}
}
