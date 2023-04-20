/* Name: CashRegister.java
 * Project: Store Checkout System - Project 2 - Submission #2
 * Author: Adam B. Jost
 * Course: CPT-189 Section 80
 * Language: Java
 * Date: 3/31/2021 - Updated on 4/6/2021
*/

package store.systems;

import java.io.PrintWriter;
import java.util.ArrayList;

public class CashRegister {
	
	// Data fields
	
	private double grandTotal;
	private ArrayList<Product> purchasedProducts;
	
	// Constructors 
	
	CashRegister() {  
		grandTotal = 0.0;
		purchasedProducts = new ArrayList<>();
	}
	
	// Getters
	
	public double getTotal() { return grandTotal; }
	public ArrayList<Product> getProductList() { return purchasedProducts; }
	
	// Setters
	
	public void setTotal(double totalAmount) { this.grandTotal = totalAmount; }
	public void setProducts(ArrayList<Product> productList) { this.purchasedProducts = productList; }
	
	// Methods 
	
	/**
	 * Adds new product and increases checkout total by the products calculated total.
	 * @param product: The product to be added.
	 */
	public void addProduct(Product product) { 
		purchasedProducts.add(product); 
		grandTotal += product.calcTotal();
	}

	public void subtractProduct(Product product) {
		purchasedProducts.subtract(product);
		grandTotal -= product.calcTotal();
	}

	//added a method to remove a product when at the cash register
	
	/**
	 * Prints the receipt displaying all of the products and the calculated grand total.
	 * @param writer: Object used to write the entire receipt to the open text file.
	 */
	public void printReceipt(PrintWriter writer) {
		for (Product product: purchasedProducts) { product.print(writer); }
	}

}
