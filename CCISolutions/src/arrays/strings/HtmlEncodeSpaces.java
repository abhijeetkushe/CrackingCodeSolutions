package arrays.strings;

public class HtmlEncodeSpaces
{

	public static String encodeSpaces(String str)
	{
		StringBuilder sb = new StringBuilder(str.length());
		for(char c : str.toCharArray())
			if(c == ' ')
				sb.append("%20");
			else sb.append(c);
		return sb.toString();
	}
	
}
