package cards;

import java.util.ArrayList;

public class GroupCard extends Card
{
	public int resistance;
	public ArrayList<String> alignments;
	public GroupCard master;
	public ArrayList<GroupCard> puppets;
	
	public GroupCard(String name, String description)
	{
		this.name = name;
		this.description = description;
		alignments = new ArrayList<String>();
		puppets = new ArrayList<GroupCard>();
	}
	
	public GroupCard(String name)
	{
		this.name = name;
		this.description = null;
		alignments = new ArrayList<String>();
		puppets = new ArrayList<GroupCard>();
	}
	
	public void setResistance(int resistance)
	{
		this.resistance = resistance;
	}
	
	public int getResistance()
	{
		return resistance;
	}
	
	public void setMaster(GroupCard master)
	{
		this.master = master;
	}
	
	public void addPuppet(GroupCard puppet)
	{
		puppets.add(puppet);
	}
	
	public void addAlignment(String alignment)
	{
		alignments.add(alignment);
	}
}
