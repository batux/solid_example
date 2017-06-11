package scenario.one.taxcalculator.customer;

import java.util.ArrayList;
import java.util.List;

import scenario.one.taxcalculator.shopping.Product;
import scenario.one.taxcalculator.shopping.ShoppingChart;
import scenario.one.taxcalculator.tax.TaxPolicy;

public class IndividualCustomer extends Customer {

	public IndividualCustomer(IndividualCustomerBuilder individualCustomerBuilder) {
		super.setAge(individualCustomerBuilder.getAge());
		super.setName(individualCustomerBuilder.getName());
		super.setLastname(individualCustomerBuilder.getLastname());
		super.setTaxPolicies(individualCustomerBuilder.getTaxPolicies());
		super.setDiscountRate(individualCustomerBuilder.getDiscountRate());
		super.setShoppingChart(individualCustomerBuilder.getShoppingChart());
		super.setClaimToUseDiscountedPrices(individualCustomerBuilder.isClaimToUseDiscountedPrices());
	}
	
	@Override
	public void applyDiscountedPrices() {
		
		double discountRate = getDiscountRate();
		List<Product> selectedProducts = getShoppingChart().getSelectedProducts();
		
		for(Product selectedProduct : selectedProducts) {
		
			double discountedAmount = (selectedProduct.getPrice().getAmount() * (discountRate * 0.01)) - 0.1;
			selectedProduct.getPrice().setAmount(discountedAmount);
		}
		
	}

	public static class IndividualCustomerBuilder {
		
		private String name;
		private String lastname;
		private short age;
		private double discountRate;
		private List<TaxPolicy> taxPolicies;
		private ShoppingChart shoppingChart;
		private boolean claimToUseDiscountedPrices;
		
		public IndividualCustomerBuilder(String name, String lastname, double discountRate) {
			this.name = name;
			this.lastname = lastname;
			this.discountRate = discountRate;
			this.shoppingChart = new ShoppingChart();
			this.taxPolicies = new ArrayList<TaxPolicy>(0);
		}

		public String getName() {
			return name;
		}

		public String getLastname() {
			return lastname;
		}

		public double getDiscountRate() {
			return discountRate;
		}

		public short getAge() {
			return age;
		}

		public IndividualCustomerBuilder setAge(short age) {
			this.age = age;
			return this;
		}

		public List<TaxPolicy> getTaxPolicies() {
			return taxPolicies;
		}

		public IndividualCustomerBuilder setTaxPolicies(List<TaxPolicy> taxPolicies) {
			this.taxPolicies = taxPolicies;
			return this;
		}

		public ShoppingChart getShoppingChart() {
			return shoppingChart;
		}

		public IndividualCustomerBuilder setShoppingChart(ShoppingChart shoppingChart) {
			this.shoppingChart = shoppingChart;
			return this;
		}

		public boolean isClaimToUseDiscountedPrices() {
			return claimToUseDiscountedPrices;
		}

		public IndividualCustomerBuilder setClaimToUseDiscountedPrices(boolean claimToUseDiscountedPrices) {
			this.claimToUseDiscountedPrices = claimToUseDiscountedPrices;
			return this;
		}
		
		public  IndividualCustomer build() {
			return new IndividualCustomer(this);
		}
	}

}
