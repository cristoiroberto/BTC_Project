package btc_lab2_com.btc.ac_labs.ui.parts;

public class Requirements {
	private String nume;
	private String description;
	public Requirements(String nume,String description)
	{
		this.nume=nume;
		this.description=description;
	}
	public String getName()
	{
		return nume;
	}
	public String getDescription()
	{
		return description;
	}
}
