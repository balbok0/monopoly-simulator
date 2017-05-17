package cards;

import java.util.ArrayList;

public final class CommunityChest {
	
	private static ArrayList<String> commCards;

	public CommunityChest()
	{
		//Beginning statement
		commCards = new ArrayList<String>();
		commCards.add("Start");									//	Advance to Go (Collect $200) 
		commCards.add("75");								//	Bank error in your favor – collect $75 
		commCards.add("-50");								//	Doctor's fees – Pay $50  
		commCards.add("Jail");								//	Go to jail – go directly to jail – Do not pass Go, do not collect $200 
		commCards.add("10 * NumPlay");						//	It is your birthday Collect $10 from each player 
		commCards.add("50 * NumPlay");						//	Grand Opera Night – collect $50 from every player for opening night seats 
		commCards.add("20");								//	Income Tax refund – collect $20 
		commCards.add("100");								//	Life Insurance Matures – collect $100 
		commCards.add("-100");								//	Pay Hospital Fees of $100 
		commCards.add("-50");								//	Pay School Fees of $50 
		commCards.add("25");								//	Receive $25 Consultancy Fee 
		commCards.add("40 * HomeNum + 115 * HotelNum");		//	You are assessed for street repairs – $40 per house, $115 per hotel 
		commCards.add("10");								//	You have won second prize in a beauty contest– collect $10 
		commCards.add("100");								//	You inherit $100 
		commCards.add("50");								//	From sale of stock you get $50 
		commCards.add("100");								//	Holiday Fund matures - Receive $100
		commCards.add("JaFree 11");							//	Get out of jail free – this card may be kept until needed, or sold
	}
	
	public static String getCard()
	{
		String p = commCards.get((int) (Math.random()*16));
		if(p.equals("JaFree"))
		{
			commCards.remove(16);
		}
		return p;
	}
	
	public static void useCard()
	{
		commCards.add("JaFree");
	}
}
