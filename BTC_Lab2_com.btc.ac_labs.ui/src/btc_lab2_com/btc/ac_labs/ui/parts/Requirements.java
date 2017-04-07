package btc_lab2_com.btc.ac_labs.ui.parts;

import java.util.Date;

public class Requirements {
	private String nume;
	private String short_description;
	private String long_description;
	private String creator;
	private Date creation_date;
	
	public Requirements(String nume,String short_description,String long_description,String creator)
	{
		this.nume=nume;
		this.short_description=short_description;
		this.long_description=long_description;
		this.creator=creator;
		this.creation_date=new Date();
	}
	public String getName()
	{
		return nume;
	}
	public String getShortDescription()
	{
		return short_description;
	}
	public String getLongDescription()
	{
		return long_description;
	}
	public String getCreator()
	{
		return creator;
	}
	public String getCreationDate()
	{
		return creation_date.toLocaleString();
	}
}
