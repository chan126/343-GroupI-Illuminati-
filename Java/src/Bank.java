import java.util.ArrayList;

import cards.Card;

public class Bank
{
	public int bankTotal;
	
	public Bank()
	{
		bankTotal = 1106;
	}
	
	public void withdraw(Card card)
	{
		card.addToBalance(card.income);
		bankTotal -= card.income;
	}
	
	public void deposit(Card card, int amount)
	{
		card.removeFromBalance(amount);
		bankTotal += amount;
	}
}
