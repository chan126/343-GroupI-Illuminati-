import cards.Card;

public class Bank
{
	private int bankTotal;
	
	public Bank()
	{
		setBankTotal(1106);
	}
	
	public void withdraw(Card card)
	{
		card.addToBalance(card.getIncome());
		setBankTotal(getBankTotal() - card.getIncome());
	}
	
	public void deposit(Card card, int amount)
	{
		card.removeFromBalance(amount);
		setBankTotal(getBankTotal() + amount);
	}

	public int getBankTotal() 
	{
		return bankTotal;
	}

	public void setBankTotal(int bankTotal) 
	{
		this.bankTotal = bankTotal;
	}
}
