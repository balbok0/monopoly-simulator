package monopoly;

public final class Pieces {
	private static int house;
	private static int hotel;
	
	public Pieces()
	{
		house = 30;
		hotel = 12;
	}
	
	public static boolean canBuyHouse()
	{
		return house > 0;
	}
	
	public static boolean canBuyHotel()
	{
		return hotel > 0;
	}
	
	public static void buyHouse()
	{
		house--;
	}
	
	public static void buyHotel()
	{
		hotel--;
	}
	
	public static void addHouses(int n)
	{
		house += n;
	}
}
