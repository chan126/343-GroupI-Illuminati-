import java.util.Random;

public class Dice
{
	public int d1[];
	public int d2[];
	
	public Dice()
	{
		d1 = new int[6];
		d2 = new int[6];
		
		for(int i = 0; i < 6; i++)
		{
			d1[i] = i+1;
			d2[i] = i+1;
		}
	}
	
	public int roll()
	{
		Random rand = new Random();
		int x = rand.nextInt(6) + 1;
		int y = rand.nextInt(6) + 1;
		
		return x + y;
	}
}