package places;

import monopoly.Pieces;

public class Place {

	private String name;
	private int cost;
	private int houseCost;
	private int color;
	private int ownedBy;
	private int houseNum;
	
	// Costs for the player to stand on the spot
	private int house0;
	private int house1;
	private int house2;
	private int house3;
	private int house4;
	private int hotel;
	
	
	public Place(String Iname, int col, int Icost, int hCost, int h0, int h1, int h2, int h3, int h4, int hotel)
	{
		name = Iname;
		cost = Icost;
		houseCost = hCost;
		color = col;
		ownedBy = 0;
		houseNum = 0;
		
		house0 = h0;
		house1 = h1;
		house2 = h2;
		house3 = h3;
		house4 = h4;
		this.hotel = hotel;
	}
	//Getters
	
		public int getPrice()
	{
		return cost;
	}
	
		public int getColor()
	{
		return color;
	}
	
		public String getName()
	{
		return name;
	}
	
		public int getOwner()
	{
		return ownedBy;
	}

	public int getHouseN()
	{
		return houseNum;
	}
		
		public int getHousePrice()
	{
		return houseCost;
	}
	
		public int getHotelPrice()
	{
		return getHousePrice()*5;
	}

		public int pay()
		{
			if(houseNum == 0)
			{
				return house0;
			}
			
			else if(houseNum == 1)
			{
				return house1;
			}
			
			else if(houseNum == 2)
			{
				return house2;
			}
			
			else if(houseNum == 3)
			{
				return house3;
			}
			
			else if(houseNum == 4)
			{
				return house4;
			}
			
			return hotel;
		}

	//Setters
		
		public void setOwnedBy(int ownedBy) 
		{
			this.ownedBy = ownedBy;
		}	
	
	//Buying	
		public int buyHouse(int n)
		{
			int howMany = 0;
			for(int i = 0; i < n; i++)
			{
				if(Pieces.canBuyHouse())
				{
					howMany++;
					Pieces.buyHouse();
				}
			}
			
			if(houseNum + howMany == 5)
			{
				howMany -= buyHotel();
			}
			houseNum += howMany;
			
			return howMany*houseCost;
		}

		public int buyHotel()
		{ 	
			if(Pieces.canBuyHotel())
			{
				Pieces.buyHotel();
				Pieces.addHouses(5);
				return 0;
			}
			
			Pieces.addHouses(1);
			return 1;
		}

		public int buy(int index)
		{
			ownedBy = index;
			return cost; 
		}

		
	//Special case for parking
		public void accumulate(int n)
		{
			
		}
}
