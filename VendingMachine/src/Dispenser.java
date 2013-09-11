/**
 * 
 */

/**import java.io.*;

 * @author Allen Chen
 *
 */
import java.io.Serializable;

public class Dispenser 
{
	//FoodInformation [] food = new FoodInformation[20];
	String itemType;
	int quantity;
	String foodName;
	double price;
	String foodInfo;
	@Override
	public String toString() {
		return "itemType=" + itemType + ", quantity=" + quantity
				+ ", foodName=" + foodName + ", price=" + price + ", foodInfo="
				+ foodInfo;
	}
	public Dispenser (String newFoodName, double newPrice, String newFoodInfo, String newItemType, int newQuanity)
	{
		this.foodName = newFoodName;
		this.itemType = newItemType;
		this.quantity = newQuanity;
		this.price = newPrice;	
		this.foodInfo = newFoodInfo;
	}
	public String FoodLable()
	{
		return "Name: " + this.foodName + "\n Price: " + this.price + "\n Nutrition Information: " + this.foodInfo;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFoodInfo() {
		return foodInfo;
	}
	public void setFoodInfo(String foodInfo) {
		this.foodInfo = foodInfo;
	}
	
}
