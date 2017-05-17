package places;
import cards.*;

public class CardPlace extends Place {

	
	
	public CardPlace(String Iname, int col) {
		super(Iname, col, 0,0,0,0,0,0,0,0);
		// TODO Auto-generated constructor stub
	}
	
	public String getCard()
	{
		if(super.getColor() == 10)
		{
			return ChanceCards.getCard();
		}
		
		return CommunityChest.getCard();
	}

}
