/**
 * 
 */

import java.io.*;
import java.io.PrintWriter;

/**
 * @author Allen Chen
 *
 */
import java.util.*;
public class Driver {
	public static void main(String[] args) throws WrongChoiceException
	{
		Scanner input = new Scanner(System.in);

		// TODO Auto-generated method stub
		//preloadig the machine with food
		FoodInformation water = new FoodInformation("Water",1," You should drink more", "drink");
		FoodInformation coke= new FoodInformation("Coke",1.50," This is disgusting, stop drinking this", "drink");
		FoodInformation milk = new FoodInformation("Milk",0.50," This is good, drink more", "drink");
		FoodInformation apple = new FoodInformation("Apple",0.50," An apple a day keeps the bed bugs away", "food");
		FoodInformation cheetos = new FoodInformation("Cheetos",1," Warning, eating this may cause people to suck their thumbs", "food");
		FoodInformation cookie = new FoodInformation("Cookie",0.50," Warning, eating this may attract the cookie monster", "food");
		Dispenser waterD = new Dispenser(water.getFoodName(),water.getPrice(), water.getFoodInfo(), water.getFoodType(), 10);
		Dispenser cokeD = new Dispenser(coke.getFoodName(),coke.getPrice(), coke.getFoodInfo(), coke.getFoodType(), 8);
		Dispenser milkD = new Dispenser(milk.getFoodName(),milk.getPrice(), milk.getFoodInfo(), milk.getFoodType(), 7);
		Dispenser appleD = new Dispenser(apple.getFoodName(),apple.getPrice(), apple.getFoodInfo(), apple.getFoodType(), 5);
		Dispenser cheetosD = new Dispenser(cheetos.getFoodName(),cheetos.getPrice(), cheetos.getFoodInfo(), cheetos.getFoodType(), 6);
		Dispenser cookieD = new Dispenser(cookie.getFoodName(),cookie.getPrice(), cookie.getFoodInfo(), cookie.getFoodType(), 8);
		VendingMachine drink = new VendingMachine();
		VendingMachine food = new VendingMachine();
		drink.addFood(waterD);
		drink.addFood(cokeD);
		drink.addFood(milkD);
		food.addFood(appleD);
		food.addFood(cheetosD);
		food.addFood(cookieD);
        
		/*try
        {
	        FileInputStream fis = new FileInputStream("Food_Machine.txt");
	        ObjectInputStream in = new ObjectInputStream(fis);
	        drink = (VendingMachine) in.readObject();
	        in.close(); //be sure to close the input stream when done
	        System.out.println("Loading....Vending Machine");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error: " + e);
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        }
        */
		//make a for loops
		
		boolean machine = false;
		int cNumber = 0;
		int totalSales = 0;
		int rangeChoice = 0;
		boolean choiceOption = false;
		int dChoice= 0;
		int fChoice = 0;
		while (machine != true)
		{
		//drink
			int program = (int) ((20*Math.random()));
			if (program <10)
			{
				System.out.println("The menu for the drinks vending machine is: ");
				for (int i=0; i < drink.length(); i++)
				{
					System.out.println(drink.printD(i) + ", Item Number: "+ i);
				}
				rangeChoice = drink.length();
				System.out.println("Please enter the amount of money you have");
				double dMoney = input.nextDouble();
				//checks to see if choice is valid
				System.out.println("Please enter the item number you would like to eat?");
				choiceOption = false;
				while (!choiceOption)
				{
					try
					{
						dChoice= input.nextInt();
						if (drink.isChoiceValid(dChoice, rangeChoice) == true)
						{
							choiceOption = true;
						}
					}
					catch(WrongChoiceException choiceOut)
					{
						System.out.println("Choice is out or range, please try again.");
					}
				}
				if (drink.checkMoney(dMoney, dChoice) == true)
				{
					drink.buyFood(dChoice);
					System.out.println("You put in " + dMoney + " and your change is " + drink.foodIsBought(dMoney, dChoice));
					System.out.println(drink.printD(dChoice));
					cNumber++;
					totalSales += food.foodIsBought(dMoney, dChoice);
				}
				else
				{
					System.out.println("Please put more money");
				}
			}
			//food
			if (program > 10)
			{
				System.out.println("\nThe menu for the food vending machine is: ");
				for (int i=0; i < food.length(); i++)
				{
					System.out.println(food.printD(i) + ", Item Number: "+ i);
				}
				rangeChoice = drink.length();
				System.out.println("Please enter the amount of money you have");
				double fMoney = input.nextDouble();
				System.out.println("Please enter the item number you would like to eat?");

				//checks to see if choice is valid
				choiceOption = false;
				while (!choiceOption)
				{
					try
					{
						fChoice= input.nextInt();
						if (food.isChoiceValid(fChoice, rangeChoice) == true)
						{
							choiceOption = true;
						}
					}
					catch(WrongChoiceException choiceOut)
					{
						System.out.println("Choice is out or range, please try again.");
					}
				}				
				if (food.checkMoney(fMoney, fChoice) == true)
				{
					food.buyFood(fChoice);
					System.out.println("You put in " + fMoney + " and your change is " + food.foodIsBought(fMoney, fChoice));
					System.out.println(food.printD(fChoice));
					cNumber++;
					totalSales += food.foodIsBought(fMoney, fChoice);
				}
				else
				{
					System.out.println("Please put more money");
				}
			}
			else
			{
				machine = true;
			}
		}
		System.out.println("Machine turning off....");
		System.out.println("\nThe menu for the drink vending machine is: ");
		String filename = "Vending.txt";
		try
		{
			PrintWriter out = new PrintWriter(filename);
			for (int i=0; i < drink.length(); i++)
			{
				out.println(drink.printD(i));
				System.out.println(drink.printD(i));
			}
			System.out.println("\nThe menu for the food vending machine is: ");
		
			for (int i=0; i < food.length(); i++)
			{
				out.println(food.printD(i));
				System.out.println(food.printD(i));
			}
			out.close();
		}
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        }		
		System.out.println("Hello guys.. You sold a total of " + cNumber + " and made " + totalSales + " Dollars");
       /*
		try
        {
	            FileOutputStream fos = new FileOutputStream("Food_Machine.txt");
	            ObjectOutputStream out = new ObjectOutputStream(fos);
	            out.writeObject(drink);
	            out.close(); //be sure to close the output stream when done		            
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        }
        */
	}

}
