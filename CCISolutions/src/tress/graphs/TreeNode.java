package tress.graphs;

import java.util.List;


class BinaryTreeNode<T>
{
	 T value;
	 BinaryTreeNode<T> left;
	 BinaryTreeNode<T> right;
	 BinaryTreeNode<T> parent;
	 
	public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
		if(left != null)
		{	
			this.left.parent = this;
		}
		if(right != null)
		{	
			this.right.parent = this;
		}	
	}
	
	public BinaryTreeNode(T value)
	{
		this(value, null, null);
	}

	public T getValue()
	{
		return value;
	}

	public void setValue(T value)
	{
		this.value = value;
	}

	public BinaryTreeNode<T> getLeft()
	{
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left)
	{
		this.left = left;
		if(this.left != null)
		{
			this.left.parent = this;
		}
	}

	public BinaryTreeNode<T> getRight()
	{
		return right;
	}

	public void setRight(BinaryTreeNode<T> right)
	{
		this.right = right;
		if(this.right != null)
		{	
			this.right.parent = this;
		}
	}

	public BinaryTreeNode<T> getParent()
	{
		return parent;
	}

	public void setParent(BinaryTreeNode<T> parent)
	{
		this.parent = parent;
	}
	
	
	
}

class NaryTreeNode<T>
{
	 T value;
	 List<NaryTreeNode<T>> children;

	 NaryTreeNode(T value, List<NaryTreeNode<T>> children)
	{
		this.value = value;
		this.children = children;
	}
}


