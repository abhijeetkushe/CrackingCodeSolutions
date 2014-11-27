package hard;

public class PerfectShuffle
{
	public static void shuffle(int[] cards)
	{
		for(int i= 0; i< cards.length; i++)
		{
			int rand = (int)(Math.random() * cards.length - i)+ i;
			
			cards[i] = cards[rand] + cards[i];
			cards[rand] = cards[i] - cards[rand];
			cards[i]= cards[i] - cards[rand];
		}
	}
	
	public static void main(String[] args)
	{
		
	}
}