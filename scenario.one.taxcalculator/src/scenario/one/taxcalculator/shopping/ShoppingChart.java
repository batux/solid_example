package scenario.one.taxcalculator.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingChart {

	private List<Product> selectedProducts;
	
	public ShoppingChart() {
		this.setSelectedProducts(new ArrayList<Product>());
	}

	public List<Product> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(List<Product> selectedProducts) {
		this.selectedProducts = selectedProducts;
	} 
	
	public void addProduct(Product product) {
		
		if(product != null) {
			this.getSelectedProducts().add(product);
		}
	}
	
	public Product removeProduct(Product product) {
		
		if(product != null) {
			this.getSelectedProducts().remove(product);
			return product;
		}
		
		return null;
	}
	
	public Product removeProduct(int index) {
		
		if(index > -1) {
			return this.getSelectedProducts().remove(index);
		}
		
		return null;
	}
}
