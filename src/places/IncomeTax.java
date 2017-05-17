package places;

public class IncomeTax extends Place {
	
	private int money;

	public IncomeTax(String name, int i) {
		super(name, 14, 0, 0, 0,0,0,0,0,0);
		
		money = i;
		// TODO Auto-generated constructor stub
	}

	
	public int pay()
	{
		return money;
	}
}
