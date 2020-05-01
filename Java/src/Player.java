import cards.Card;
import cards.IlluminatiCard;

public class Player
{
	public String username;
	public IlluminatiCard illuminati;
	
	public Player(String username)
	{
		this.username = username;
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
