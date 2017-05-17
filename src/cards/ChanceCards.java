package cards;

import java.util.ArrayList;

public final class ChanceCards {
	
	private static ArrayList<String> chanCards;
	
	public ChanceCards()
	{
		chanCards = new ArrayList<String>();
		chanCards.add("Start");									//	Advance to Go (Collect $200) 
		chanCards.add("Illinois Ave");						//	Advance to Illinois Ave. 
		chanCards.add("Utility");							//	Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown. 
		chanCards.add("Railroad");							//	Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.) 
		chanCards.add("St. Charles Place");					//	Advance to St. Charles Place – if you pass Go, collect $200 
		chanCards.add("50");								//	Bank pays you dividend of $50  
		chanCards.add("back 3");							//	Go back 3 spaces 
		chanCards.add("Jail");								//	Go directly to Jail – do not pass Go, do not collect $200 
		chanCards.add("40 * HomeNum + 100 * HotelNum");		//	Make general repairs on all your property – for each house pay $25 – for each hotel $100 
		chanCards.add("-15");								//	Pay poor tax of $15 
		chanCards.add("Reading Railroad");					//	Take a trip to Reading Railroad – if you pass Go collect $200 
		chanCards.add("Boardwalk");							//	Take a walk on the Boardwalk – advance token to Boardwalk 
		chanCards.add("50 * NumPlay");						//	You have been elected chairman of the board – pay each player $50 
		chanCards.add("150");								//	Your building loan matures – collect $150 
		chanCards.add("100");								//	You have won a crossword competition - collect $100
		chanCards.add("JaFree 10");							//	Get out of Jail free – this card may be kept until needed, or traded/sold
	}
	
	public static String getCard()
	{
		String p = chanCards.get((int) (Math.random()*16));
		if(p.equals("JaFree"))
		{
			chanCards.remove(15);
		}
		return p;
	}
	
	public static void useCard()
	{
		chanCards.add("JaFree");
	}

}
