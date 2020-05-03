import java.util.ArrayList;

import cards.Card;
import cards.IlluminatiCard;
import cards.GroupCard;
import cards.SpecialCard;

public class Player
{
	private String username;
	protected IlluminatiCard illuminati;
	protected ArrayList<GroupCard> groupCards;
	protected ArrayList<SpecialCard> specialCards;
	
	public Player(String username)
	{
		this.username = username;
		groupCards = new ArrayList<GroupCard>();
		specialCards = new ArrayList<SpecialCard>();
	}
	
	public void addGroupCard(GroupCard group)
	{
		groupCards.add(group);
	}
	
	public void removeGroupCard(GroupCard group)
	{
		groupCards.remove(group); //???????????
	}
	
	public void addSpecialCard(SpecialCard special)
	{
		specialCards.add(special);
	}
	
	public void removeSpecialCard(SpecialCard special)
	{
		specialCards.remove(special); //???????????
	}
	
	public void setIlluminati(IlluminatiCard illuminati)
	{
		this.illuminati = illuminati;
	}
	
	public IlluminatiCard getIlluminati()
	{
		return illuminati;
	}
	
	public void collectIncome(Card card, Bank bank)
	{
		bank.withdraw(card);
		card.addToBalance(card.getIncome());
	}
	
	public String toString()
	{
		return this.username;
	}
}
