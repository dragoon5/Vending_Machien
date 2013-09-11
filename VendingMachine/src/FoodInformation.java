import java.io.*;

public class FoodInformation 
{
	private String foodName;
	private double price;
	private String foodInfo;
	private String foodType;
	public FoodInformation (String newFoodName, double newPrice, String newFoodInfo, String newFoodType)
	{
		this.foodName = newFoodName;
		this.price = newPrice;
		this.foodInfo = newFoodInfo;
		this.foodType =  newFoodType;
	}
	public String toString() {
		return "FoodInformation [foodName=" + foodName + ", price=" + price
				+ ", foodInfo=" + foodInfo + ", foodType=" + foodType + "]";
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
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
