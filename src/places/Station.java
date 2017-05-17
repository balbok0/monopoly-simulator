package places;

public class Station extends Place {

	public Station(String Iname) {
		super(Iname, 99, 200, 0, 0, 0, 0, 0, 0, 0);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 
	 *  Returning the cost of standing at has to be changed
	 * 
	 */

	public int pay()
	{
		return 25;
	}
}
