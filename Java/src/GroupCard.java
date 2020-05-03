package cards;

import java.util.ArrayList;

public class GroupCard extends Card
{
	private int resistance;
	private ArrayList<String> alignments;
	
	public GroupCard(String name, String description)
	{
		super(name, description);
		alignments = new ArrayList<String>();
	}
	
	public GroupCard(String name)
	{
		super(name);
		alignments = new ArrayList<String>();
	}
	
	public void setResistance(int resistance)
	{
		this.resistance = resistance;
	}
	
	public int getResistance()
	{
		return resistance;
	}
	
	public void addAlignment(String alignment)
	{
		alignments.add(alignment);
	}
}
