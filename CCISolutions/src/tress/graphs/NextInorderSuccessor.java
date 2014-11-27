package tress.graphs;

public class NextInorderSuccessor
{
	public static <T> BinaryTreeNode<T> inorderSuccessor(BinaryTreeNode<T> node)
	{

		BinaryTreeNode<T> successor = null;
		
		if (node.right == null)
		{
			//isLeftChild
			while ((successor = node.parent) != null && successor.left != node)
			{
				node = successor;
			}
		}
		else
		{
			successor = node.right;

			while (successor.left != null)
			{
				successor = successor.left;
			}

		}
		return successor;

	}

	public static void main(String[] args)
	{
		Integer[] arr = new Integer[16];
		for (int i = 0; i < 16; i++)
			arr[i] = Integer.valueOf(i);

		BinaryTreeNode<Integer> root = MinHeightBinaryTree.createTree(arr);

		System.out.println(root.value + " " + inorderSuccessor(root).value);
		System.out.println(root.right.left.value + " " + inorderSuccessor(root.right.left).value);
		System.out.println(root.left.left.right.value + " " + inorderSuccessor(root.left.left.right).value);
		System.out.println(root.left.right.value + " " + inorderSuccessor(root.left.right).value);
		System.out.println(root.right.right.right.right.value + " " + inorderSuccessor(root.right.right.right.right));

	}

}
