package hard;

public class RandomNumbers
{
	//Probablity => 1/nints.length
	 
	private static int[] generate(int[] nints, int m)
	{
		int[] mints= new int[m];
		for(int i = 0; i <  m ; i++)
		{
			int rand = (int)(Math.random() * nints.length - i) + i;
			mints[i] = nints[rand];
			nints[rand] = nints[i];
		}	
		return mints;
	}
	
}