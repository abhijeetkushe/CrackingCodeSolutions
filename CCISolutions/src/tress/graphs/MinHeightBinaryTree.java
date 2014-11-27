package tress.graphs;

public class MinHeightBinaryTree
{

	public static <T> BinaryTreeNode<T> createTree(T[] arr, int start, int end)
	{
		if (start > end)
			return null;
		int median = (start + end) / 2;
		BinaryTreeNode<T> root = new BinaryTreeNode<>(arr[median]);
		root.setLeft(createTree(arr, start, median - 1));
		root.setRight(createTree(arr, median + 1, end));
		return root;
	}

	public static <T> BinaryTreeNode<T> createTree(T[] arr)
	{
		return createTree(arr, 0, arr.length - 1);
	}

	public static void main(String[] args)
	{
		Integer[] arr = new Integer[16];
		for (int i = 0; i < 16; i++)
			arr[i] = Integer.valueOf(i);

		BinaryTreeNode<Integer> tree = createTree(arr);
		tree.toString();
	}

}
