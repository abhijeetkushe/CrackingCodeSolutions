package tress.graphs;

import java.util.ArrayList;
import java.util.List;

import linkedlists.LinkedListNode;

public class DepthNodes
{

	private static <T> List<LinkedListNode<BinaryTreeNode<T>>> nodesAtDepth(BinaryTreeNode<T> root)
	{
		int level = 0;
		List<LinkedListNode<BinaryTreeNode<T>>> nodesList = new ArrayList<>();
		nodesList.add(level, new LinkedListNode<>(root));

		while (nodesList.get(level) != null)
		{
			LinkedListNode<BinaryTreeNode<T>> parentNodes = nodesList.get(level);

			LinkedListNode<BinaryTreeNode<T>> head = null;

			while (parentNodes != null)
			{
				BinaryTreeNode<T> parentNode = parentNodes.data;
				LinkedListNode<BinaryTreeNode<T>> currentDepthNodes = head;
				if (parentNode.left != null)
				{
					currentDepthNodes = add(parentNode.left, currentDepthNodes);
					head = head == null ? currentDepthNodes : head;

				}

				if (parentNode.right != null)
				{
					currentDepthNodes = add(parentNode.right, currentDepthNodes);
					head = head == null ? currentDepthNodes : head;
				}

				parentNodes = parentNodes.next;
			}
			nodesList.add(++level, head);

		}
		nodesList.remove(level);
		return nodesList;
	}

	private static <T> LinkedListNode<BinaryTreeNode<T>> add(BinaryTreeNode<T> node,
			LinkedListNode<BinaryTreeNode<T>> currentDepthNodes)
	{
		if (currentDepthNodes != null)
		{
			currentDepthNodes = currentDepthNodes.next(node);
		}
		else
		{
			currentDepthNodes = new LinkedListNode<>(node);
		}
		return currentDepthNodes;
	}

	public static void main(String[] args)
	{
		BinaryTreeNode<Integer> right_right_right = new BinaryTreeNode<>(8);
		BinaryTreeNode<Integer> right_right_left = new BinaryTreeNode<>(9);
		BinaryTreeNode<Integer> right_left_right = new BinaryTreeNode<>(10);
		BinaryTreeNode<Integer> right_left_left = new BinaryTreeNode<>(11);
		BinaryTreeNode<Integer> left_right_right = new BinaryTreeNode<>(12);
		BinaryTreeNode<Integer> left_right_left = new BinaryTreeNode<>(13);
		BinaryTreeNode<Integer> left_left_right = new BinaryTreeNode<>(14);
		BinaryTreeNode<Integer> left_left_left = new BinaryTreeNode<>(15);
		BinaryTreeNode<Integer> right_right = new BinaryTreeNode<>(1, right_right_left, right_right_right);
		BinaryTreeNode<Integer> right_left = new BinaryTreeNode<>(2, right_left_left, right_left_right);
		BinaryTreeNode<Integer> left_right = new BinaryTreeNode<>(3, left_right_left, left_right_right);
		BinaryTreeNode<Integer> left_left = new BinaryTreeNode<>(4, left_left_left, left_left_right);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<>(5, right_left, right_right);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<>(6, left_left, left_right);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(7, left, right);

		List<LinkedListNode<BinaryTreeNode<Integer>>> nodes = nodesAtDepth(root);
		root.toString();
	}

}
