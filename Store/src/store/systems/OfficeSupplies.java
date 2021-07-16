/* Name: OfficeSupplies.java
 * Project: Store Checkout System - Project 2 - Submission #2
 * Author: Adam B. Jost
 * Course: CPT-189 Section 80
 * Language: Java
 * Date: 3/31/2021 - Updated on 4/6/2021
*/

package store.systems;

import java.io.PrintWriter;

public class OfficeSupplies extends Product {
	
	// Data fields
	
	private int count;
	
	
	// Constructors
	
	OfficeSupplies() {}
	
	OfficeSupplies(String descriptionVal, int quantityVal, double priceVal, int countVal) {
		setDescription(descriptionVal);
		setQuantity(quantityVal);
		setPrice(priceVal);
		this.count = countVal;
	}
	
	// Getters
	
	public int getCount() { return count; }
	
	// Setters 
	
	public void setCount(int countVal) { this.count = countVal; }

	@Override
	public void print(PrintWriter writer) {
		writer.printf("%3d %-28s$%7.2f\n", getQuantity(), getDescription() + " (" + String.valueOf(count) +" count)", calcTotal());
	}

}
