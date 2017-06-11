package scenario.one.taxcalculator.tax;

import scenario.one.taxcalculator.money.Money;

public interface TaxPolicy {

	public Money calculateTax(Money money);
	
}
