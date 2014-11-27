package tress.graphs;

public class BalancedTree
{
	public static boolean isBalanced(BinaryTreeNode<?> root)
	{
		return (maxDepth(root) - minDepth(root)) <= 1;
	}
	
	
	private static int maxDepth(BinaryTreeNode<?> root)
	{
		if(root == null) return 0;
		return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
	}
	
	private  static int minDepth(BinaryTreeNode<?> root)
	{
		if(root == null) return 0;
		return 1 + Math.min(minDepth(root.left),minDepth(root.right));
	}
	
	
	public static void main(String[] args)
	{
		BinaryTreeNode<Integer> right_right_right = null;
		BinaryTreeNode<Integer> right_right_left = null;
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
		BinaryTreeNode<Integer> left = new BinaryTreeNode<>(6, left_left,left_right);
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(7,left,null);
	
		System.out.println(isBalanced(root));
	}
}