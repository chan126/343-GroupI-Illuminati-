package cards;

import java.util.ArrayList;

public class GroupCard extends Card
{
	public int resistance;
	public ArrayList<String> alignments;
	
	public GroupCard(String name, String description)
	{
		this.name = name;
		this.description = description;
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
