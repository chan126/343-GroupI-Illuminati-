package cards;

import java.util.ArrayList;

public class UncontrolledGroups
{
	private ArrayList<GroupCard> uncontrolled;
	
	public UncontrolledGroups()
	{
		uncontrolled = new ArrayList<GroupCard>();
	}
	
	public void addGroup(GroupCard group)
	{
		uncontrolled.add(group);
	}
	
	public GroupCard removeGroup(GroupCard group)
	{
		return uncontrolled.remove(uncontrolled.indexOf(group));
	}
	
	public int getSize()
	{
		return uncontrolled.size();
	}
	
	public GroupCard getCard(int index)
	{
		return uncontrolled.get(index);
	}
}
