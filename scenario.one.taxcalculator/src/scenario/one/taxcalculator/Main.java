package scenario.one.taxcalculator;

import java.util.ArrayList;
import java.util.List;

import scenario.one.taxcalculator.customer.Customer;
import scenario.one.taxcalculator.customer.EnterpriseCustomer;
import scenario.one.taxcalculator.customer.IndividualCustomer;
import scenario.one.taxcalculator.money.Currency;
import scenario.one.taxcalculator.money.Money;
import scenario.one.taxcalculator.shopping.Product;
import scenario.one.taxcalculator.shopping.ShoppingChart;
import scenario.one.taxcalculator.tax.KDVTax;
import scenario.one.taxcalculator.tax.OTVTax;
import scenario.one.taxcalculator.tax.TaxCalculator;
import scenario.one.taxcalculator.tax.TaxPolicy;

/*
 * 
 * Batuhan Duzgun - Computer Engineer
 * Yeditepe University - 2017
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		List<TaxPolicy> taxPoliciesForIndividualCustomer = new ArrayList<TaxPolicy>();
		taxPoliciesForIndividualCustomer.add(new KDVTax());
		taxPoliciesForIndividualCustomer.add(new OTVTax());
		
		ShoppingChart shoppingChartForIndividualCustomer = new ShoppingChart();
		shoppingChartForIndividualCustomer.addProduct(new Product(new Money(100, Currency.TL), "Apple"));
		shoppingChartForIndividualCustomer.addProduct(new Product(new Money(50, Currency.TL), "Banana"));
		shoppingChartForIndividualCustomer.addProduct(new Product(new Money(5, Currency.TL), "Water"));

		
		Customer individualCustomer = new IndividualCustomer.IndividualCustomerBuilder("Batuhan", "Duzgun", 0.11)
																					.setAge((short)29)
																				    .setClaimToUseDiscountedPrices(false)
																				    .setTaxPolicies(taxPoliciesForIndividualCustomer)
																				    .setShoppingChart(shoppingChartForIndividualCustomer)
																				    .build();
		
		
		
		

		List<TaxPolicy> taxPoliciesForEnterpriseCustomer = new ArrayList<TaxPolicy>();
		taxPoliciesForEnterpriseCustomer.add(new OTVTax());
		
		ShoppingChart shoppingChartForEnterpriseCustomer = new ShoppingChart();
		shoppingChartForEnterpriseCustomer.addProduct(new Product(new Money(1000, Currency.TL), "Apple"));
		shoppingChartForEnterpriseCustomer.addProduct(new Product(new Money(500, Currency.TL), "Banana"));
		shoppingChartForEnterpriseCustomer.addProduct(new Product(new Money(50, Currency.TL), "Water"));

		
		Customer enterpriseCustomer = new EnterpriseCustomer.EnterpriseCustomerBuilder("Batuhan", "Duzgun", 0.08)
																					.setAge((short)29)
																					.setClaimToUseDiscountedPrices(true)
																					.setTaxPolicies(taxPoliciesForEnterpriseCustomer)
																					.setShoppingChart(shoppingChartForEnterpriseCustomer)
																					.build();
		
		TaxCalculator taxCalculator = new TaxCalculator();
		
		Money taxPriceOfIndividualCustomer = taxCalculator.calculateTotalTax(individualCustomer);
		Money taxPriceOfEnterpriseCustomer = taxCalculator.calculateTotalTax(enterpriseCustomer);
		
		System.out.println(taxPriceOfIndividualCustomer);
		System.out.println(taxPriceOfEnterpriseCustomer);
	}

}
