package scenario.one.taxcalculator.shopping;

import scenario.one.taxcalculator.money.Money;

public class Product {

	private Money price;
	private String description;
	
	public Product() {
		this.setPrice(new Money());
		this.setDescription("NO DESCRIPTION");
	}
	
	public Product(Money price, String description) {
		this.setPrice(price);
		this.setDescription(description);
	}
	
	public Money getPrice() {
		return price;
	}
	public void setPrice(Money price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
