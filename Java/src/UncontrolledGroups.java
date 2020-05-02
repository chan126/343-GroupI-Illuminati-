package cards;

import java.util.ArrayList;

public class UncontrolledGroups
{
	public ArrayList<GroupCard> uncontrolled;
	
	public UncontrolledGroups()
	{
		uncontrolled = new ArrayList<GroupCard>();
		setGroups();
	}
	
	public void setGroups()
	{
		// add all 83 groups here
		GroupCard AAA = new GroupCard("American Autoduel Association", "");
		AAA.setAttackPower(1);
		AAA.setResistance(5);
		AAA.setIncome(1);
		AAA.addAlignment("Violent");
		AAA.addAlignment("Weird");
		uncontrolled.add(AAA);
		
		GroupCard ANA = new GroupCard("Anti-Nuclear Activists", 
				"+2 on any attempt to destroy Nuclear Power Companies.");
		ANA.setAttackPower(2);
		ANA.setResistance(5);
		ANA.setIncome(1);
		ANA.addAlignment("Liberal");
		uncontrolled.add(ANA);
	}
}
