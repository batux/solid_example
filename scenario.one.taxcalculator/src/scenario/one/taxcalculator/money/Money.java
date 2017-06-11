package scenario.one.taxcalculator.money;

public class Money {

	private double amount;
	private Currency currency;
	
	public Money() {
		this.setAmount(0);
		this.setCurrency(Currency.NONE);
	}
	
	public Money(double amount, Currency currency) {
		this.setAmount(amount);
		this.setCurrency(currency);
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Money addMoney(Money money) {
		
		if(money == null) {
			return this;
		}
		
		double lastAmount = this.getAmount() + money.getAmount();
		
		if(this.getCurrency() == null || this.getCurrency() == Currency.NONE) {
			this.setCurrency(money.getCurrency());
		}
		
		this.setAmount(lastAmount);
		
		return new Money(this.getAmount(), this.getCurrency());
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	
}
