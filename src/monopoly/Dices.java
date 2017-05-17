package monopoly;

public final class Dices {
	
	private static int dice1, dice2;
	
	public Dices()
	{
		dice1 = 0;
		dice2 = 0;
	}
	
	public static int roll()
	{
		dice1 = 1 + (int) (Math.random()*6);
		dice2 = 1 + (int) (Math.random()*6); 
		return dice1+dice2;
	}

	//Makes it so double doesn't work. Useful after coming out of jail
	public static void mix()
	{
		dice1++;
		dice2--;
	}
	
	public static boolean isDouble()
	{
		return dice1 == dice2;
	}
}
