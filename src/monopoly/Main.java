package monopoly;

import cards.*;

public class Main {	
	public static void main(String[] args)
	{
		//Begins the program
		Player[] players;
		Board b = new Board();
		ChanceCards doesntMatter = new ChanceCards();
		CommunityChest doesntMatter2 = new CommunityChest();
		Pieces p = new Pieces();
		
		//Here put in number of players
		int numOfPlayers = 8;
		int turns = 45;
		
		players = new Player[numOfPlayers];
		for(int i = 0; i< numOfPlayers; i++)
		{
			players[i] = new Player(i);
		}
		
		/*
		 * Set preferences for buying properties.
		 * This uses color mechanics.
		 * For indexes look at Board constructor.
		 * For 'how it works look at Player class, methods:
		 * 	- setColorPref
		 * 	- checkCashAndPreferences
		 */
		for(int i = 1; i < numOfPlayers+1; i++)
		{
			int[] ar = new int[i];
			for(int j = 0; j < i; j++)
			{
				ar[j] = j+1;
			}
			players[i-1].setColorPref(ar);
		}
		

		
		
		double timeStart = System.currentTimeMillis();
		for(int i = 0; i < turns; i++)
		{
			for(int j = 0; j < numOfPlayers; j++)
			{
				players[j].process(b, players);
			}
		}
		double timeEnd = System.currentTimeMillis();
		
		System.out.println("Number of players: " + players.length + ". Nubmer of turns: " + turns + ".");
		System.out.println("Time of game: " + (timeEnd-timeStart)/1000 + "s.");
		System.out.println("Time per turn: " + (timeEnd-timeStart)/1000/turns + "s.");
		System.out.println("Time per player: " + (timeEnd-timeStart)/1000/turns/players.length + "s.");
	}
	
}