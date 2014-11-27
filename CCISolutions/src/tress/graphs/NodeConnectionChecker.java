package tress.graphs;


import stacks.queues.Stack;
import stacks.queues.Stack.ArrayStack;
import tress.graphs.Graph.Node;
import tress.graphs.Graph.Status;

public class NodeConnectionChecker
{
	public static boolean areConnected(Graph<?> graph , Node<?> a, Node<?> b) {
		
		Stack<Node<?>> visitingNodes = new ArrayStack<>(graph.nodes.size());
		visitingNodes.push(a);

		while(!visitingNodes.isEmpty())
		{
			Node<?> node = visitingNodes.pop();
			if(node.adjacent != null) 
			{
				for(Node<?> tempNode : node.adjacent)
				{
					if( tempNode.status == Status.UNVISITED)
					{
						if(b == tempNode)
						{
							return true;
						}
						else
						{
							tempNode.status = Status.VISITING;	
							visitingNodes.push(tempNode);
						}
					}	
				}
			}
			node.status = Status.VISITED;
		}		
		return false;
	}
}