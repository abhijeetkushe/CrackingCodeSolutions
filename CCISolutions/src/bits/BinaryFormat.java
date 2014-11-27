package bits;

public class BinaryFormat
{

	public static String binaryFormat(String number, int precision) 
	{
		String decimalSeparator = getLocaleDecimalSeparator();

		String[] parts =  number.split("\\"+decimalSeparator);
		
		int intPart = Integer.parseInt(parts[0]);
		double decimalPart = Double.parseDouble("." + parts[1]);
		
		StringBuilder binary = new StringBuilder();
		while(intPart > 0)
		{
			binary.append(intPart & 1);
			intPart = intPart>>1; 
		}
		binary.append(".");
		while(precision-- > 0 || decimalPart == 1)
		{
			decimalPart = decimalPart * 2;
			binary.append(((int)(decimalPart)));
			if(decimalPart > 1)
			{
				decimalPart = decimalPart - 1;
			}
		}
		
		return binary.toString();

	}
	
	private static String getLocaleDecimalSeparator()
	{
		return ".";
	}

	public static void main(String[] args)
	{
		Double no = 3.72;
		System.out.println(binaryFormat(no.toString(), 4));
		
		System.out.println(Double.toString(no));
	}
}