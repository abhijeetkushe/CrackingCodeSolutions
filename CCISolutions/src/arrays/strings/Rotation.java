package arrays.strings;

public class Rotation {

	public static void main(String[] args)
	{
		isRotation("waterbottle","erbottlewat");
	}

	/**checks if b is a rotation of a
	 * @param a String
	 * @param b String
	 */
	private static boolean isRotation(String a,String b)
	{
		return a.length()==b.length() &&  (a.concat(a)).contains(b);
	}
	
}
