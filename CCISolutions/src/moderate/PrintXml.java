package moderate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintXml
{

	static Map<String, Integer> tagMap = new HashMap<>();
	static Map<String, Integer> attrMap = new HashMap<>();

	static
	{
		tagMap.put("html", 1);
		tagMap.put("body", 2);
		attrMap.put("version", 3);
	}

	private static void printXml(String xml)
	{
		boolean start = false, end = false;
		StringBuilder tag = new StringBuilder();
		StringBuilder attr = new StringBuilder();
		for (char c : xml.toCharArray())
		{
			switch (c)
			{
				case '<':
				{
					start = true;
					break;
				}
				case ' ':
				{

					if (tag.length() > 0)
					{

						System.out.println(tagMap.get(tag.toString()) + " ");
						start = false;
						end = false;
						tag.setLength(0);
					}
					else if (attr.length() > 0)
					{
						System.out.println(attrMap.get(attr.toString()) + " ");
						attr.setLength(0);
					}
					break;
				}

				case '>':
				{
					if (start && end)
					{
						System.out.println("01");
					}else if(start)
					{
						System.out.println(tagMap.get(tag.toString()) + " ");
						start = false;
						end = false;
						tag.setLength(0);
					}
					start = false;
					end = false;
					break;
				}

				case '/':
				{
					end = true;
				}

				default:
				{
					if (start)
					{
						tag.append(c);
					}
					else
					{
						attr.append(c);
					}
				}
			}
		}

	}

	public static void main(String[] args)
	{
		String xml = "<html version = 1.1><body></body></html>";

		printXml(xml);
	}
}
