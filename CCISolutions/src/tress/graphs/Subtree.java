package tress.graphs;

import java.util.stream.IntStream;

public class Subtree
{

	public static <T> boolean isSubTree(BinaryTreeNode<T> bigTree, BinaryTreeNode<T> smallTree)
	{
		if(bigTree == null && smallTree !=null)
		{
			return false;
		}
		else if (bigTree == smallTree || (smallTree == null))
		{
			return true;
		}
		else if (bigTree.value.equals(smallTree.value))
		{

			return isSubTree(bigTree.left, smallTree.left) && isSubTree(bigTree.right, smallTree.right);
		}
		else
		{

			return isSubTree(bigTree.left, smallTree) || isSubTree(bigTree.right, smallTree);
		}

	}

	public static void main(String[] args)
	{

		BinaryTreeNode<Integer> bigTree = MinHeightBinaryTree.createTree(IntStream.range(1, 16).boxed().toArray(Integer[]::new));

		BinaryTreeNode<Integer> smallTree = MinHeightBinaryTree.createTree(IntStream.range(1, 8).boxed().toArray(Integer[]::new));
		
		System.out.println(bigTree.left.left.value +" "+ smallTree.left.value);
		System.out.println(isSubTree(bigTree, smallTree));
	}

}
