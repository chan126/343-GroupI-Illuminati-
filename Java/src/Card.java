package cards;

public abstract class Card
{
	String name;
	String description;
	int attackPower;
	int transferPower;
	int income;
	
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
		attackPower = transfer;
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
}
