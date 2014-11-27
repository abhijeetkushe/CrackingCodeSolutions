package tress.graphs;

import java.util.ArrayList;
import java.util.stream.IntStream;


public class Sum {

	public static void findSum(BinaryTreeNode<Integer> root, int sum) 
	{
		findSum(root, sum, new ArrayList<Integer>(), 0);
	}
	
	@SuppressWarnings("unchecked")
	private static void findSum(BinaryTreeNode<Integer> node, int sum, ArrayList<Integer> buffer, int level)
	{
		if(node != null)
		{
			int temp = sum;
			buffer.add(node.value);
			for(int i = level; i >= 0 ; i--)
			{
				temp -= buffer.get(i);
				if(temp == 0) 
				{
					print(buffer, i, level);
				}	
			}	 
		

			ArrayList<Integer> copy1 = (ArrayList<Integer>)buffer.clone();
			ArrayList<Integer> copy2 = (ArrayList<Integer>)buffer.clone();
			
			findSum(node.left, sum,  copy1, level + 1);
			findSum(node.right, sum,  copy2, level + 1);		
		}
	}
	
	private static void print(ArrayList<Integer> buffer, int level, int i2) 
	{
		StringBuilder sb = new StringBuilder(20);
		for(int i = level; i <= i2; i ++)
		{
			sb.append(buffer.get(i) + "->");
		}
		
		System.out.println(sb);
	}	
	
	public static void main(String[] args) 
	{
		BinaryTreeNode<Integer> root = MinHeightBinaryTree.createTree(IntStream.range(1,16).boxed().toArray(Integer[] :: new));
		System.out.println(root.value + root.left.value);
		findSum(root, 12);
	}
}