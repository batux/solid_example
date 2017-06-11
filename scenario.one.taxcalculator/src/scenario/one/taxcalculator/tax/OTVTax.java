package scenario.one.taxcalculator.tax;

import scenario.one.taxcalculator.money.Currency;
import scenario.one.taxcalculator.money.Money;

public class OTVTax implements TaxPolicy {

	@Override
	public Money calculateTax(Money money) {
		
		if(money == null) {
			money = new Money();
			return money;
		}
		
		double amount = money.getAmount() * (0.1);
		Currency currency = money.getCurrency();
		
		return new Money(amount, currency);
	}

}
