/* Name: BulkFood.java
 * Project: Store Checkout System - Project 2 - Submission #2
 * Author: Adam B. Jost
 * Course: CPT-189 Section 80
 * Language: Java
 * Date: 3/31/2021 - Updated on 4/6/2021
*/

package store.systems;

import java.io.PrintWriter;

public class BulkFood extends Product {
	
	// Data fields
	
	private double weight; 
	
	
	// Constructors
	
	BulkFood() {}
	
	BulkFood(String descriptionVal, int quantityVal, double priceVal, double weightVal) {
		setDescription(descriptionVal);
		setQuantity(quantityVal);
		setPrice(priceVal);
		this.weight = weightVal;
	}
	
	// Getters
	
	public double getWeight() { return weight; }
	
	// Setters
	
	public void setWeight(double weightVal) { this.weight = weightVal; }
	
	@Override
	public void print(PrintWriter writer) {
		writer.printf("%3d %-28s$%7.2f\n", getQuantity(),getDescription(),calcTotal());
		
	}

	@Override
	public double calcTotal() { return getQuantity() * getPrice() * weight; }

}
