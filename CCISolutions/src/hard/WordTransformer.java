package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordTransformer
{
	private static class Node
	{
		String word;

		List<Node> adjNodes = new ArrayList<>();

		public Node(String word)
		{
			this.word = word;
		}
	}

	static Set<String> dictionary = new HashSet<>();

	private static void transform(String from, String to)
	{
		List<String> deps = new ArrayList<>();

		// Node start = getGraph(from, to);

		// List<Node> path = depthFirsSearch(from, to, start);

	}

	private static LinkedList<String> transform2(String from, String to)
	{
		LinkedList<String> path = new LinkedList<>();

		Set<String> alreadyVisited = new HashSet<>();
		Map<String, String> backTrackMap = new HashMap<>();

		Queue<String> actionQueue = new LinkedList<>();

		actionQueue.add(from);
		alreadyVisited.add(from);

		while (actionQueue.isEmpty())
		{
			String w = actionQueue.poll();

			for (String v : oneLetterDiffWords(w))
			{
				if (v.equals(to))
				{
					path.add(v);
					while (w != null)
					{
						path.add(w);
						w = backTrackMap.get(w);
					}

					return path;
				}

				if (!alreadyVisited.contains(w))
				{
					backTrackMap.put(v, w);
					alreadyVisited.add(v);
					actionQueue.offer(v);
				}
			}
		}

		return null;
	}

	private static Set<String> oneLetterDiffWords(String word)
	{
		Set<String> words = new HashSet<>();

		for (int i = 0; i < word.length(); i++)
		{
			for (char c = 'A'; c <= 'z'; i++)
			{
				char[] chars = word.toCharArray();

				chars[i] = c;

				String diff = new String(chars);
				if (!dictionary.contains(word))
				{
					words.add(diff);
				}

			}
		}

		return words;
	}
	// private static Node getGraph(String from, String to)
	// {
	// Node root = new Node(from);
	// Queue<Node> nodes = new LinkedList<>();
	// nodes.add(root);
	//
	// while (nodes.isEmpty())
	// {
	// Node node = nodes.remove();
	// List<Node> adjNodes = getOneLetterDiff(node.word, dictionary);
	// node.adjNodes.addAll(adjNodes);
	// nodes.addAll(adjNodes);
	//
	// }
	//
	// return node;
	//
	// }

	private List<Node> getOneLetterDiff(String word, String toword, Set<String> dictionary)
	{
		List<Node> nodes = new ArrayList<>();

		for (String w : dictionary)
		{
			if (w.equals(toword))
			{
				nodes.clear();
				// nodes.add(w);
				break;
			}
			// if (oneLetterdiff(word, w))
			// {
			// nodes.add(w);
			// }
		}
		dictionary.removeAll(nodes);
		dictionary.remove(word);
		return nodes;
	}

	public static void main(String[] args)
	{

	}
}
