package tress.graphs;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Graph<T>
{
	static enum Status
	{
		VISITED, VISITING, UNVISITED
	}
	static class Node<T>
	{
		Iterator<Node<T>> loopAdjacentIter;
		T value;
		List<Node<T>> adjacent = Collections.emptyList();
		Status status;

		public Node(T value, List<Node<T>> adjacent)
		{
			this.value = value;
			this.adjacent = adjacent;
			this.loopAdjacentIter = adjacent.iterator();
		}

		boolean visited;

		Node<T> nextAdjacent()
		{
			if (loopAdjacentIter.hasNext())
			{
				return loopAdjacentIter.next();
			}
			else
			{
				loopAdjacentIter = adjacent.iterator();
				return null;
			}
		}
	}

	List<Node<T>> nodes;

	Graph(List<Node<T>> nodes)
	{
		this.nodes = nodes;
	}

	public boolean isCyclicRec()
	{
		Set<Node<T>> initPath = Collections.emptySet();
		for (Node<T> node : nodes)
		{
			if (isCyclic(node, initPath))
			{
				return true;
			}
		}
		return false;
	}

	private boolean isCyclic(Node<T> currNode, Set<Node<T>> path)
	{
		if (path.contains(currNode))
		{
			return true;
		}
		else
		{
			path.add(currNode);
			for (Node<T> node : currNode.adjacent)
			{
				if (isCyclic(node, path))
				{
					return true;
				}
				else
				{
					path.remove(node);
				}
			}
		}
		return false;
	}

	boolean isCyclic()
	{
		Stack<Node<T>> path = new Stack<>();

		for (Node<T> v : nodes)
		{
			path.add(v);

			while (!path.isEmpty())
			{
				Node<T> vAdj = path.peek().nextAdjacent();
				if (vAdj == null)
				{
					break;
				}
				else if (vAdj.visited)
				{
					return true;
				}
				else
				{
					path.push(vAdj).visited = true;
				}
			}

			path.pop().visited = false;
		}
		return false;
	}

}
