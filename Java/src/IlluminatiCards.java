package cards;

import java.util.ArrayList;

public class IlluminatiCards
{
	public ArrayList<IlluminatiCard> cards;
	
	public IlluminatiCards()
	{
		cards = new ArrayList<IlluminatiCard>();
		setGroups();
	}
	
	public ArrayList<IlluminatiCard> getCards()
	{
		return cards;
	}
	
	public IlluminatiCard get(int index)
	{
		return cards.get(index);
	}
	
	public IlluminatiCard remove(int index)
	{
		return cards.remove(index);
	}
	
	public void setGroups()
	{
		IlluminatiCard Assassins = new IlluminatiCard("The Society of Assassins", 
				"+4 on any attempt to neutralize any group.");
		Assassins.setAttackPower(8);
		Assassins.setTransferPower(8);
		Assassins.setIncome(8);
		cards.add(Assassins);
		
		IlluminatiCard Network = new IlluminatiCard("The Network", 
				"Turns over two cards at beginning of turn.");
		Network.setAttackPower(7);
		Network.setTransferPower(7);
		Network.setIncome(9);
		cards.add(Network);
		
		IlluminatiCard Discordian = new IlluminatiCard("The Discordian Society", 
				"+4 on any attempt to control Weird groups; immune to any attacks from "
				+ "Government or Straight groups.");
		Discordian.setAttackPower(8);
		Discordian.setTransferPower(8);
		Discordian.setIncome(8);
		cards.add(Discordian);
		
		IlluminatiCard UFO = new IlluminatiCard("The UFOs", 
				"Illuminati group may participate in two attacks per turn.");
		UFO.setAttackPower(8);
		UFO.setTransferPower(8);
		UFO.setIncome(8);
		cards.add(UFO);
		
		IlluminatiCard Servants = new IlluminatiCard("The Servants of Cthulhu", 
				"+2 on any attempt to destroy any group.");
		Servants.setAttackPower(9);
		Servants.setTransferPower(9);
		Servants.setIncome(7);
		cards.add(Servants);
		
		IlluminatiCard Gnomes = new IlluminatiCard("The Gnomes of Zurich", 
				"May move money freely at end of turn.");
		Gnomes.setAttackPower(7);
		Gnomes.setTransferPower(7);
		Gnomes.setIncome(12);
		cards.add(Gnomes);
		
		IlluminatiCard Bavarian = new IlluminatiCard("The Bavarian Illuminati", 
				"May make one privileged attack each turn at a cost of 5MB.");
		Bavarian.setAttackPower(10);
		Bavarian.setTransferPower(10);
		Bavarian.setIncome(9);
		cards.add(Bavarian);
		
		IlluminatiCard Bermuda = new IlluminatiCard("The Bermuda Triangle", 
				"May reorganize groups freely at end of turn.");
		Bermuda.setAttackPower(8);
		Bermuda.setTransferPower(8);
		Bermuda.setIncome(9);
		cards.add(Bermuda);
	}
}
