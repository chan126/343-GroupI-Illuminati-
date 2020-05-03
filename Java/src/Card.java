package cards;

import java.util.ArrayList;

public abstract class Card
{
	private String name;
	private String description;
	private int attackPower;
	private int transferPower;
	private int income;
	private int balance;
	private Card master;
	protected int out;
	public ArrayList<GroupCard> puppets;
		
	public Card(String name, String description)
	{
		this.name = name;
		this.description = description;
		puppets = new ArrayList<GroupCard>();
	}
	
	public Card(String name)
	{
		this.name = name;
		puppets = new ArrayList<GroupCard>();
	}
	
	public void setMaster(Card master)
	{
		this.master = master;
	}
	
	public Card getMaster()
	{
		return master;
	}
	
	public void addPuppet(GroupCard puppet)
	{
		if(puppets.size() < out)
			puppets.add(puppet);
		else
			System.out.println("ERROR: There are no more open arrows for " + name + "!");
	}
		
	public String getName()
	{
		return name;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setAttackPower(int attack)
	{
		attackPower = attack;
	}
	
	public int getAttackPower()
	{
		return attackPower;
	}
	
	public void setTransferPower(int transfer)
	{
		transferPower = transfer;
	}
	
	public int getTransferPower()
	{
		return transferPower;
	}
	
	public void setIncome(int income)
	{
		this.income = income;
	}
	
	public int getIncome()
	{
		return income;
	}
	
	public int getBalance()
	{
		return balance;
	}
	
	public void addToBalance(int amount)
	{
		balance += amount;
	}
	
	public void removeFromBalance(int amount)
	{
		balance -= amount;
	}
	
	public String toString()
	{
		return this.name;
	}

	public int getOut() 
	{
		return out;
	}

	public void setOut(int out) 
	{
		this.out = out;
	}
}
