/* Name: Shirt.java
 * Project: Store Checkout System - Project 2 - Submission #2
 * Author: Adam B. Jost
 * Course: CPT-189 Section 80
 * Language: Java
 * Date: 3/31/2021 - Updated on 4/6/2021
*/

package store.systems;

import java.io.PrintWriter;

public class Shirt extends Product {

	
	// Data fields 
	
	private String size;
	
	// Constructors
	
	Shirt() {}
	
	Shirt(String descriptionVal, int quantityVal, double priceVal, String sizeVal) {
		setDescription(descriptionVal);
		setQuantity(quantityVal);
		setPrice(priceVal);
		this.size = sizeVal;
	}
	
	// Getters
	
	public String getSize() { return size; }
	
	// Setters 
	
	public void setSize(String sizeVal) { this.size = sizeVal; }
	
	@Override
	public void print(PrintWriter writer) {
		writer.printf("%3d %-28s$%7.2f\n", getQuantity(),size + " " + getDescription(),calcTotal());
		
	}

}
