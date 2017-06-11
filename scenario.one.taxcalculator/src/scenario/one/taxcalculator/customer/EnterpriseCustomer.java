package scenario.one.taxcalculator.customer;

import java.util.ArrayList;
import java.util.List;

import scenario.one.taxcalculator.shopping.Product;
import scenario.one.taxcalculator.shopping.ShoppingChart;
import scenario.one.taxcalculator.tax.TaxPolicy;

public class EnterpriseCustomer extends Customer {

	public EnterpriseCustomer(EnterpriseCustomerBuilder enterpriseCustomerBuilder) {
		super.setAge(enterpriseCustomerBuilder.getAge());
		super.setName(enterpriseCustomerBuilder.getName());
		super.setLastname(enterpriseCustomerBuilder.getLastname());
		super.setTaxPolicies(enterpriseCustomerBuilder.getTaxPolicies());
		super.setDiscountRate(enterpriseCustomerBuilder.getDiscountRate());
		super.setShoppingChart(enterpriseCustomerBuilder.getShoppingChart());
		super.setClaimToUseDiscountedPrices(enterpriseCustomerBuilder.isClaimToUseDiscountedPrices());
	}
	
	@Override
	public void applyDiscountedPrices() {
		
		double discountRate = getDiscountRate();
		List<Product> selectedProducts = getShoppingChart().getSelectedProducts();
		
		for(Product selectedProduct : selectedProducts) {
		
			double discountedAmount = (selectedProduct.getPrice().getAmount() * discountRate) - 0.5;
			selectedProduct.getPrice().setAmount(discountedAmount);
		}
		
	}
	
	public static class EnterpriseCustomerBuilder {
		
		private String name;
		private String lastname;
		private short age;
		private double discountRate;
		private List<TaxPolicy> taxPolicies;
		private ShoppingChart shoppingChart;
		private boolean claimToUseDiscountedPrices;
		
		public EnterpriseCustomerBuilder(String name, String lastname, double discountRate) {
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

		public EnterpriseCustomerBuilder setAge(short age) {
			this.age = age;
			return this;
		}

		public List<TaxPolicy> getTaxPolicies() {
			return taxPolicies;
		}

		public EnterpriseCustomerBuilder setTaxPolicies(List<TaxPolicy> taxPolicies) {
			this.taxPolicies = taxPolicies;
			return this;
		}

		public ShoppingChart getShoppingChart() {
			return shoppingChart;
		}

		public EnterpriseCustomerBuilder setShoppingChart(ShoppingChart shoppingChart) {
			this.shoppingChart = shoppingChart;
			return this;
		}

		public boolean isClaimToUseDiscountedPrices() {
			return claimToUseDiscountedPrices;
		}

		public EnterpriseCustomerBuilder setClaimToUseDiscountedPrices(boolean claimToUseDiscountedPrices) {
			this.claimToUseDiscountedPrices = claimToUseDiscountedPrices;
			return this;
		}
		
		public  EnterpriseCustomer build() {
			return new EnterpriseCustomer(this);
		}
	}


}
