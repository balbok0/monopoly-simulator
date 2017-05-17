package places;

public class Utility extends Place {

	public Utility(String Iname) {
		super(Iname, 98, 150, 0,0,0,0,0,0,0);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Changing the cost of standing at
	 */
	
	public int pay()
	{
		return (int) (Math.random()*6 + 1);
	}

}