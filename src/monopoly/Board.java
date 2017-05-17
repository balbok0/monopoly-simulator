package monopoly;

import places.*;

public class Board {
	
	private Place[] board;
	
	public Board()
	{
		/*
		 * 'Colors Mechanics':
		 * 
		 * 	50 - Start -d
		 * 
		 * 	1 through 8 - Streets/Avenues -d
		 * 	10 - Chance
		 * 	11 - Community Chest
		 * 	12 - Jail -d
		 * 	13 - Go to Jail
		 * 	14 - Income tax pay
		 * 	15 - Parking -d
		 * 	98 - Water/Electricity -d
		 *	99 - Railroads -d
		 *
		 */
		
		board = new Place[40];
		board[0] = new Start();
		board[1] = new Place("Mediterranean Ave", 1, 60, 50, 2, 10, 30, 90, 160, 250);
		board[2] = new CardPlace("Community Chest", 11);
		board[3] = new Place("Baltic Ave", 1, 60, 50, 4, 20, 60, 180, 320, 450);
		board[4] = new IncomeTax("Income Tax Pay", 200);
		board[5] = new Station("Reading Railroad");
		board[6] = new Place("Oriental Ave", 2, 100, 50, 6, 30, 90, 270, 400, 550);
		board[7] = new CardPlace("Chance", 10);
		board[8] = new Place("Vermont Ave", 2, 100, 50, 6, 30, 90, 270, 400, 550);
		board[9] = new Place("Connecticut Ave", 2, 120, 50, 8, 40, 100, 300, 450, 600);
		board[10] = new AnyOther("Jail", 12);
		board[11] = new Place("St. Charles Place", 3, 140, 100, 10, 50, 150, 450, 625, 750);
		board[12] = new Utility("Electric Company");
		board[13] = new Place("States Ave", 3, 140, 100, 10, 50, 150, 450, 625, 750);
		board[14] = new Place("Virginia Ave", 3, 160, 100, 12, 60, 180, 500, 700, 900);
		board[15] = new Station("Pennsylvania Railroad");
		board[16] = new Place("St. James Place", 4, 180, 100, 14, 70, 200, 550, 750, 950);
		board[17] = new CardPlace("Community Chest", 11);
		board[18] = new Place("Tennessee Ave", 4, 180, 100, 14, 70, 200, 550, 750, 950);
		board[19] = new Place("New York Ave", 4, 200, 100, 16, 80, 220, 600, 800, 1000);
		board[20] = new Parking();
		board[21] = new Place("Kentucky Ave", 5, 220, 150, 18, 90, 250, 700, 875, 1050);
		board[22] = new CardPlace("Chance", 10);
		board[23] = new Place("Indiana Ave", 5, 220, 150, 18, 90, 250, 700, 875, 1050);
		board[24] = new Place("Illinois Ave", 5, 240, 150, 20, 100, 300, 750, 925, 1100);
		board[25] = new Station("B&O Railroad");
		board[26] = new Place("Atlantic Ave", 6, 260, 150, 22, 110, 330, 800, 975, 1150);
		board[27] = new Place("Ventnor Ave", 6, 260, 150, 22, 110, 330, 800, 975, 1150);
		board[28] = new Utility("WaterWorks"); // look at board[12] Electric Company
		board[29] = new Place("Marvin Gardens", 6, 280, 150, 24, 120, 360, 850, 1025, 1200);
		board[30] = new AnyOther("Go to Jail", 13);
		board[31] = new Place("Pacific Ave", 7, 300, 200, 26, 130, 390, 900, 1100, 1275);
		board[32] = new Place("North Carolina Ave", 7, 300, 200, 26, 130, 390, 900, 1100, 1275);
		board[33] = new CardPlace("Community Chest", 11);
		board[34] = new Place("Pennsylvania Ave", 7, 320, 200, 28, 150, 450, 1000, 1200, 1400);
		board[35] = new Station("Short Line");
		board[36] = new CardPlace("Chance", 10);
		board[37] = new Place("Park Place", 8, 350, 200, 35, 175, 500, 1100, 1300, 1500);
		board[38] = new IncomeTax("Luxury Tax", 100);
		board[39] = new Place("Boardwalk", 8, 400, 200, 50, 200, 600, 1400, 1700, 2000);
	}
	
	public Place getPlace(int position)
	{
		return board[position];
	}
}
