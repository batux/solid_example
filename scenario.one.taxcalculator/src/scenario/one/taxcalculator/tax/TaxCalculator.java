package scenario.one.taxcalculator.tax;

import java.util.List;

import scenario.one.taxcalculator.customer.Customer;
import scenario.one.taxcalculator.money.Money;
import scenario.one.taxcalculator.shopping.Product;

public class TaxCalculator {

	public Money calculateTotalTax(Customer customer) {
		
		if(customer.isClaimToUseDiscountedPrices()) {
			customer.applyDiscountedPrices();
		}
		
		List<TaxPolicy> taxPolicies = customer.getTaxPolicies();
		List<Product> selectedProducts = customer.getShoppingChart().getSelectedProducts();
		
		Money totalTaxPrice = new Money();
		
		for(Product selectedProduct : selectedProducts) {
			
			for(TaxPolicy taxPolicy : taxPolicies) {
				
				Money price = selectedProduct.getPrice();
				Money taxPrice = calculateTax(price, taxPolicy);
				totalTaxPrice = totalTaxPrice.addMoney(taxPrice);
			}
			
		}
		
		return totalTaxPrice;
	}
	
	public Money calculateTax(Money price, TaxPolicy taxPolicy) {
		return taxPolicy.calculateTax(price);
	}
}
