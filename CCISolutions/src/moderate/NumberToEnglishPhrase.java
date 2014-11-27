package moderate;

public class NumberToEnglishPhrase
{

	static String[] unit = { "ZERO",
			"ONE",
			"TWO",
			"THREE",
			"FOUR",
			"FIVE",
			"SIX",
			"SEVEN",
			"EIGHT",
			"NINE",
			"TEN",
			"ELEVEN",
			"TWELVE",
			"THIRTEEN",
			"FOURTEEN",
			"FIFTEEN",
			"SIXTEEN",
			"SEVENTEEN",
			"EIGHTEEN",
			"NINETEEN" };

	static String[] ten = { "", "", "TWENTY", "THIRTY", "FORTY", "FIVE", "SIXTY", "SEVENTY", "EIGHTY", "NINETY" };
	
	static String[] _100s = {"", "HUNDRED", "THOUSAND"};

	private static String toEnglishPhrase(int no)
	{
		StringBuilder phrase = new StringBuilder();
		while (no >= 0)
		{
			String word = "";
			String hund_thou = "";
			if (no < 20)
			{
				word = unit[no] + " ";
			}
			else if (no < 100)
			{
				word = ten[(no / 10)] + " ";
			}
			else if (no < 1000)
			{
				word = unit[no / 100];
				hund_thou = " HUNDRED ";

			}
			else if (no < 10000)
			{
				word = unit[no / 1000];
				hund_thou = " THOUSAND ";
			}

			else
			{
				return phrase.append(toEnglishPhrase(no / 1000))
						.append(" THOUSAND ")
						.append(toEnglishPhrase(no % 1000))
						.toString();

			}
			
			phrase.append(word).append(hund_thou);

			if (no > 20)
			{
				no /= 10;
			}
			else
			{
				break;
			}
		}

		return phrase.toString();
	}

	private static String _2digit(int no)
	{

		if (no < 20)
		{
			return unit[no];

		}
		else
		{
			StringBuilder phrase = new StringBuilder(ten[(no / 10) + 2]);

			int units = no % 10;

			if (units > 0)
			{
				phrase.append(" ").append(unit[units]);
			}
			return phrase.toString();
		}
	}

	private static String _3digit(int no)
	{
		if (no < 100)
		{
			return _2digit(no);

		}
		else
		{
			StringBuilder phrase = new StringBuilder(unit[no / 100]).append(" ").append("HUNDRED");

			int rem = no % 100;

			if (rem > 0)
			{
				phrase.append(" ").append(_2digit(rem));
			}

			return phrase.toString();
		}
	}

	private static String _4digit(int no)
	{
		if (no < 1000)
		{
			return _3digit(no);
		}
		else
		{
			StringBuilder phrase = new StringBuilder(unit[no / 1000]).append(" ").append("THOUSAND");

			int rem = no % 1000;

			if (rem > 0)
			{
				phrase.append(" ").append(_3digit(rem));
			}

			return phrase.toString();
		}
	}

	private static String _5digit(int no)
	{

		if (no < 10000)
		{
			return _4digit(no);

		}
		else
		{
			StringBuilder phrase = new StringBuilder(ten[(no / 10000) + 1]).append(" ").append("THOUSAND");

			int rem = no % 10000;

			if (rem > 0)
			{
				phrase.append(" ").append(_4digit(rem));
			}

			return phrase.toString();
		}

	}

	// 220000
	private static String _6digit(int no)
	{
		if (no < 1000000)
		{
			if (no < 100000)
			{
				return _5digit(no);

			}
			else
			{
				StringBuilder phrase = new StringBuilder(_3digit(no / 1000)).append(" ").append("THOUSAND");

				int rem = no % 1000;

				if (rem > 0)
				{
					phrase.append(" ").append(_3digit(rem));
				}

				return phrase.toString();
			}
		}
		return "OUT OF RANGE";
	}

	public static void main(String[] args)
	{
		System.out.println(toEnglishPhrase(9));
		System.out.println(toEnglishPhrase(19));
		System.out.println(toEnglishPhrase(99));
		System.out.println(toEnglishPhrase(999));
		System.out.println(toEnglishPhrase(9999));
		System.out.println(toEnglishPhrase(99999));
		System.out.println(toEnglishPhrase(999999));
	}

}
