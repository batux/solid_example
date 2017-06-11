package scenario.one.taxcalculator.customer;

import java.util.List;

import scenario.one.taxcalculator.shopping.ShoppingChart;
import scenario.one.taxcalculator.tax.TaxPolicy;

public abstract class Customer {

	protected String name;
	protected String lastname;
	protected short age;
	protected double discountRate;
	protected List<TaxPolicy> taxPolicies;
	protected ShoppingChart shoppingChart;
	protected boolean claimToUseDiscountedPrices;
	
	public abstract void applyDiscountedPrices();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public List<TaxPolicy> getTaxPolicies() {
		return taxPolicies;
	}

	public void setTaxPolicies(List<TaxPolicy> taxPolicies) {
		this.taxPolicies = taxPolicies;
	}

	public ShoppingChart getShoppingChart() {
		return shoppingChart;
	}

	public void setShoppingChart(ShoppingChart shoppingChart) {
		this.shoppingChart = shoppingChart;
	}

	public boolean isClaimToUseDiscountedPrices() {
		return claimToUseDiscountedPrices;
	}

	public void setClaimToUseDiscountedPrices(boolean claimToUseDiscountedPrices) {
		this.claimToUseDiscountedPrices = claimToUseDiscountedPrices;
	}

}
