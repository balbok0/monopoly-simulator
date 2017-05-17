package places;

public class Parking extends Place{
	
	private static int money;

	public Parking() {
		super("Parking", 15,0,0,0,0,0,0,0,0);
		// TODO Auto-generated constructor stub
	}
	
	
	// Accumulates money
	
	public void accumulate(int n)
	{
		money += n;
	}
	
	public int pay()
	{
		int i = money;
		money = 0;
		return -i;
	}

}
