import java.io.Serializable;

public class VendingMachine 
{
	Dispenser[] food = new Dispenser[10];
	int i = 0;
	public VendingMachine(/*Dispenser[] newfood*/ )
	{
	}
	public void addFood(Dispenser newDispenser)
	{
		food[i] = newDispenser;
		i++;
	}
	public int length()
	{
		return this.i;
	}
	public boolean isChoiceValid(int ourChoice, int rangeChoice) throws WrongChoiceException
	{
		if (ourChoice <0 || ourChoice > rangeChoice)
		{
			throw new WrongChoiceException("Choice out or range");
		}
		else
			return true;
	}
	public boolean checkMoney(double money, int i)
	{
		if (money < food[i].price)
		{
			return false;
		}
		if (money > food[i].price)
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	public double foodIsBought(double money, int i)//asuming Check money is used before this to check if there is enough money
	{
		return money-food[i].getPrice();
	}
	public void buyFood(int i)
	{
		if (food[i].quantity>= 1)
		{
			food[i].quantity -=1;
		}
	}
	public String printD(int i)
	{
		return food[i].toString();
	}
}
