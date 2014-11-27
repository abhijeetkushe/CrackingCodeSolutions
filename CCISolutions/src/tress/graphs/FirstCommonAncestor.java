package tress.graphs;

public class FirstCommonAncestor
{

	public static <T> BinaryTreeNode<T> commonAncestor(BinaryTreeNode<T> root, BinaryTreeNode<T> a, BinaryTreeNode<T> b)
	{
		if (contains(root.left, a, b))
		{
			if (root.left == a || root.left == b)
			{
				return root;

			}
			else
			{
				return commonAncestor(root.left, a, b);
			}
		}
		else if (contains(root.right, a, b))
		{
			if (root.right == a || root.left == b)
			{
				return root;
			}
			else
			{
				return commonAncestor(root.right, a, b);
			}
		}
		else
		{

			return root;
		}
	}

	private static <T> boolean contains(BinaryTreeNode<T> root, BinaryTreeNode<T> a, BinaryTreeNode<T> b)
	{
		return covers(root, a, b) == 2;

	}
	
	private static <T> int covers(BinaryTreeNode<T> root, BinaryTreeNode<T> a, BinaryTreeNode<T> b)
	{
		int nodesFound = 0;
		if(root == null)
		{
			return 0;
		}
		if(root == a || root == b)
		{	
			nodesFound +=1;
		}
		nodesFound += covers(root.left, a, b);
		if(nodesFound == 2) 
		{
			return nodesFound;
		}
		return nodesFound += covers(root.right, a, b);
	}

	private static <T> boolean contains(BinaryTreeNode<T> root, BinaryTreeNode<T> a)
	{
		if (root == null)
		{
			return false;
		}
		else if (root == a)
		{
			return true;
		}
		else
		{
			return contains(root.right, a) || contains(root.left, a);
		}
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

		System.out.println(commonAncestor(root, right_right_left, right_right_right).value);
	}

}
