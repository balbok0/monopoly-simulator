package monopoly;
import cards.*;

public class Player {

	private boolean[] owned;
	private final int index;
	private int money;
	private int position;
	private int jailCards; // Number of get out of Jail cards
	private int inJail; 
	private int jailCardType; // Number of get
	
	private int[] colorPref; //which colors player should buy
	
	public Player(int Iindex, int[] colors)
	{
		colorPref = colors;
		index = Iindex;
		jailCards = 0;
		money = 1500;
		position = 0;
		inJail = 0;
		owned = new boolean[40];
	}
	
	public Player(int Iindex)
	{
		colorPref = new int[0];
		index = Iindex;
		jailCards = 0;
		money = 1500;
		position = 0;
		inJail = 0;
		owned = new boolean[40];
	}
	
	//Getters
		public boolean hasJailCard()
	{
		return jailCards != 0;
	}
	
		public int getMoney()
		{
			return money;
		}
		
		public boolean[] getOwnership()
		{
			return owned;
		}

		public int[] getColorPref()
		{
			return colorPref;
		}
		
		
	//Setters
		
		public void setColorPref(int[] pref)
		{
			colorPref = pref;
		}
		
		
	//Adders
	
		public void addMoney(int amount)
		{
			money += amount;
		}
	
		
	
		
	// Engine of movement
	
	//super method
	public void process(Board b, Player[] pl)
	{
		int roll = Dices.roll();
		
		if(!isInJail())
		{
			position += roll;
			throughStart();
			
			/*
			 * Checks if it's a Property,Railroad, Utility.
			 * If not then does specific actions.
			 */
			
			if((b.getPlace(position).getColor() > 11) && (b.getPlace(position).getColor() < 97))
			{
				specialCases(b);
				
				if(Dices.isDouble())
				{
					process(b, pl);
				}
				return;
			}
			
			//Next 2 else ifs - Checks for cards, and then if the player went back to the old place.
			else if(b.getPlace(position).getColor() == 10)
			{
				processCard(ChanceCards.getCard(), b, pl);
				throughStart();
				if((b.getPlace(position).getColor() > 11) && (b.getPlace(position).getColor() < 97))
				{
					specialCases(b);
					
					if(Dices.isDouble())
					{
						process(b, pl);
					}
					return;
				}
			}
					
			else if(b.getPlace(position).getColor() == 11)
			{
				processCard(CommunityChest.getCard(), b, pl);
				throughStart();
				if((b.getPlace(position).getColor() > 11) && (b.getPlace(position).getColor() < 97))
				{
					specialCases(b);
					
					if(Dices.isDouble())
					{
						process(b, pl);
					}
					return;
				}
			}
			
			//Pays to different player if applicable
			if(b.getPlace(position).getOwner() != 0)
			{
				payingToOtherPlayerOrStart(b, pl);
				if(Dices.isDouble())
				{
					process(b, pl);
				}
				return;
			}
			
			//Buys property
			if(checkCashAndPreferences(b))
			{
				money -= b.getPlace(position).buy(index);
				owned[position] = true;
			}
			
			//Returns when Railroad or utility
			if(b.getPlace(position).getColor() > 9)
			{
				return;
			}
			
			if(b.getPlace(position).getOwner() == index)
			{
				buyHouse(b);
			}
			
			if(Dices.isDouble())
			{
				process(b, pl);
			}
		}
		
	}
	
	//Helping Methods
		
		//Checks if player has enough cash, if he is supposed to buy it, if he has all properties from that color
		private boolean checkCashAndPreferences(Board b)
		{
			boolean colorOwned = true;
			for(int i = 0; i < 7; i++)
			{
				if(position-3+i < 40 && position-3+1 > 0)
				{
					if(b.getPlace(position-3+i).getColor() == b.getPlace(position).getColor())
					{
						if(!(b.getPlace(position-3+i).getOwner() == index))
						{
							colorOwned = false;
						}
					}
				}
			}
			if(colorOwned)
			{
				if(b.getPlace(position).getPrice() <= money)
				{
					int col = b.getPlace(position).getColor();
					for(int i = 0; i < colorPref.length; i++)
					{
						if(col == colorPref[i])
						{
							return true;
						}
					}
				}
			}
			return false;
		}

		//All cases in which payment 
		private void specialCases(Board b)
	{
		
		if(b.getPlace(position).getColor() == 13)
		{
			position = 10;
			inJail = 3;
		}
		
		else if(b.getPlace(position).getColor() == 14 
				|| b.getPlace(position).getColor() == 15)
		{
			money -= b.getPlace(position).pay();
		}
		
	}
		
		//Will eventually process the card
		private void processCard(String card, Board b, Player[] pl)
		{
			if(card.equals("Start"))
			{
				cardThroughStart(0);
				return;
			}
			else if(card.equals("Illinois Ave"))
			{
				cardThroughStart(24);
				return;
			}
			else if(card.equals("Utility"))
			{
				if(position >= 0 && position < 20)
				{
					cardThroughStart(12); 
				}
				else
				{
					cardThroughStart(28);
				}
				return;
			}
			else if(card.equals("Railroad"))
			{
				cardThroughStart((position%10*10)+5);
				return;
			}
			else if(card.equals("St. Charles Place"))
			{
				cardThroughStart(11); 
				return;
			}
											 
			else if(card.equals("Jail"))
			{
				position = 10;
				inJail = 3;
				return;
			}
			else if(card.contains("HomeNum"))
			{
				int hom = 0;
				int hot = 0;
				for(int i = 0; i < 40; i++)
				{
					if(owned[i])
					{
						if(b.getPlace(position).getHouseN() == 5)
						{
							hot ++;//	Make general repairs on all your property – for each house pay $25 – for each hotel $100 
						}
						else
						{
							hom += b.getPlace(position).getHouseN();
						}
					}
				}
				
				money -= hot*Integer.parseInt((card.split(" ")[4])) + hom*Integer.parseInt((card.split(" ")[0]));
				return;
			} 
			else if(card.equals("Reading Railroad"))
			{
				cardThroughStart(5);
				return;
			}
			else if(card.equals("Boardwalk"))
			{
				cardThroughStart(39);
				return;
			}
			else if(card.contains("NumPlay"))
			{
				money += pl.length*Integer.parseInt(card.split(" ")[0]);
				for(Player p : pl)
				{
					p.addMoney(-50);
				}
				return;
			}
			else if(card.contains("back"))
			{
				position -= Integer.parseInt((card.split(" ")[1]));
				return;
			}
			
			else if(card.contains("JaFree"))
			{
				jailCards++;
				jailCardType = Integer.parseInt((card.split(" ")[1]));
				return;
			}
			else
			{
				money += Integer.parseInt(card);
			}
			
		}

		//Checks if 
		private void cardThroughStart(int pos)
		{
			if(pos < position)
			{
				money += 200;
			}
			position = pos;
		}
		
		// Checks if person is in jail
		private boolean isInJail()
		{
			if(inJail != 0)
			{
				if(Dices.isDouble())
				{
					inJail = 0;
					Dices.mix();
					return false;
				}
				
				else if(hasJailCard())
				{
					jailCards--;
					if(jailCardType == 10)
					{
						ChanceCards.useCard();
						if(jailCards == 1)
						{
							jailCardType = 11;
						}
					}
					else
					{
						CommunityChest.useCard();
						if(jailCards == 1)
						{
							jailCardType = 10;
						}
					}
					
					return false;
				}
				
				else
				{
					inJail--;
					return true;
				}
			}
			
			return false;
		}
		
		// Checks if person went through start
		private void throughStart()
		{
			if(position > 39)
			{
				position %= 40;
				money += 200;
			}
		}

		/*
		 * When a property is owned by different player, than it pays money to that person
		 * If it's start it adds money
		 */
		private void payingToOtherPlayerOrStart(Board b, Player[] pl)
		{
			int n = 1;
			
			if(b.getPlace(position).getColor() == 98)
			{
				n = 0;
				if(b.getPlace(28).getOwner() == b.getPlace(position).getOwner())
				{
					n++;
				}
				if(b.getPlace(12).getOwner() == b.getPlace(position).getOwner())
				{
					n++;
				}
				
				if(n == 1)
				{
					int change = 4*b.getPlace(position).pay();
					money -= change;
					pl[b.getPlace(position).getOwner()].addMoney(change);
					return;
				}
				int change = 10*b.getPlace(position).pay();
				money -= change;
				pl[b.getPlace(position).getOwner()].addMoney(change);
				return;
			}
			
			else if(b.getPlace(position).getColor() == 99)
			{
				for(int i = 5; i < 40; i+=10)
				{
					if(b.getPlace(i).getOwner() == b.getPlace(position).getOwner())
					{
						n *= 2;
					}
				}
				n /= 2;
			}
			
			int change = n*b.getPlace(position).pay();
			money -= change;
			pl[b.getPlace(position).getOwner()].addMoney(change);
		}

		private void buyHouse(Board b)
		{
			if(b.getPlace(position).getHouseN() == 5 || b.getPlace(position).getHousePrice() > money)
			{
				return;
			}
			
			int possible = money%b.getPlace(position).getHousePrice();
			
			if(possible > 5-b.getPlace(position).getHouseN())
			{
				possible = 5-b.getPlace(position).getHouseN();
			}
			
			money -= b.getPlace(possible).buyHouse(possible);
		}

}