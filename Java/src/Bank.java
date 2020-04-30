import java.util.ArrayList;

import cards.Card;

public class Bank
{
	public int total;
	ArrayList<Integer> register;
	
	public Bank()
	{
		total = 1106;
		register = new ArrayList<Integer>();
		register.add(4);  // 50s
		register.add(20); // 20s
		register.add(24); // 10s
		register.add(32); // 5s
		register.add(12); // 3s
		register.add(28); // 2s
		register.add(14); // 1s
	}
	
	public void withdraw(Card card, int amount)
	{
		if(amount % 50 > 1)
		{
			register.set(0, register.get(0) - 1);
			card.deposit(50);
		}
	}
	
	public void deposit()
	{
		
	}
}
