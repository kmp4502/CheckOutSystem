/* Name: Product.java
 * Project: Store Checkout System - Project 2 - Submission #2
 * Author: Adam B. Jost
 * Course: CPT-189 Section 80
 * Language: Java
 * Date: 3/31/2021 - Updated on 4/6/2021
*/

package store.systems;


import java.io.PrintWriter;

public abstract class Product {

	// Data fields
	
	private double price; // The price of the product.
	private int quantity; // The amount of the product being purchased.
	private String description; // The description of the product.	
	
	// Getters
	
	public double getPrice() { return price; }
	public int getQuantity() { return quantity; }
	public String getDescription() { return description; }
	
	// Setters 
	public void setPrice(double newPrice) { this.price = newPrice; }
	public void setQuantity(int newQuantity) { this.quantity = newQuantity; }
	public void setDescription(String newDescription) {this.description = newDescription; }
	
	// Methods
	
	/**
	 * Prints the product to the receipt.
	 * 
	 * @param writer: Object used to write the product to the open text file. 
	 */
	public abstract void print(PrintWriter writer);
	
	/**
	 * Calculates the total cost of product purchased.
	 * 
	 * @return: Total cost of the product (i.e. quantity * price).
	 */
	public double calcTotal() { return quantity * price; };
	
	
}
