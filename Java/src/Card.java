package cards;

public abstract class Card
{
	public String name;
	public String description;
	public int attackPower;
	public int transferPower;
	public int income;
	public int balance;
	
	public void setName(String name)
	{
		this.name = name;
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
}
