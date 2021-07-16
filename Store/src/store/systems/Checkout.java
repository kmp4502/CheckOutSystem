/* Name: Checkout.java
 * Project: Store Checkout System - Project 2 - Submission #2
 * Author: Adam B. Jost
 * Course: CPT-189 Section 80
 * Language: Java
 * Date: 3/31/2021 - Updated on 4/6/2021
*/

package store.systems;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Checkout {
	
	public static void main (String[] args) throws IOException {
		
		// Open streams.
		FileInputStream fin = new FileInputStream("products.txt");
		FileOutputStream fout = new FileOutputStream("receipt.txt");
		Scanner scanner = new Scanner(fin);
		PrintWriter writer = new PrintWriter(fout);
		
		Product product = null; // Create a product object.
		CashRegister register = new CashRegister(); // Instantiate the CashRegister object.
		
		// Until the end of file is reached
		while (scanner.hasNext()) {
			// Parse the input 
			String type = scanner.nextLine().trim(); // Read in the type of product.
			String description = scanner.nextLine(); // Read in the product's description.
			String shirtSize = type.equals("SHIRT") ? scanner.next() : ""; // If it's a shirt, read in the shirt size.
			int supplyItemCount = type.equals("SUPPLIES") ? scanner.nextInt() : 0; // If it's office supplies, read in the count.
			int quantity = scanner.nextInt(); // Read in the quantity of the item.
			double weight = type.equals("BULKFOOD") ? scanner.nextDouble() : 0.0; // If it's bulk food, read in the weight.
			double price = scanner.nextDouble(); // Read in the price of the product.
			
			// Instantiate the current Product object accordingly.
			if (type.equals("SHIRT")){ product = new Shirt(description,quantity,price,shirtSize); }
			if (type.equals("SUPPLIES")){ product = new OfficeSupplies(description,quantity,price,supplyItemCount); }
			if (type.equals("BULKFOOD")){ product = new BulkFood(description,quantity,price,weight); }

		    register.addProduct(product); // Add instantiated product to ArrayList<Product>
		    scanner.nextLine(); // Finish current line in file
			scanner.nextLine(); // Move to next line in file
			
		}
		// Print all headings and '*' symbols to the receipt.
		for (int i=0; i<82; i++) { 
			writer.write("*"); // Print '*' symbols
			if((i==39)||(i==41)) writer.println(); // Move to a new line
			if(i==40) writer.printf("%3sCPT189 Super Selling Stuff Store%3s", "",""); // Print main title
			if(i==81) writer.printf("\n\n%-4s%-28s%-8s\n","Qty","Description","Total"); // Print headings
		}
		// Print the separator line made of '-' to the receipt.
		for (int i=0; i<38; i++) {
			writer.write("-"); // Print '-' to the receipt.
			if((i==2) || (i==29)) writer.write(" "); // Print a empty space.
			if (i==37) writer.println(); // Move to the next line.
		}
		
		register.printReceipt(writer); // Print the products that have been checked out to the receipt.
		
		// Print formatted totals and a thank you message to the receipt.
		writer.println("\n" + 
				"Grand total: $" + register.getTotal() + "\n" +
				"Items sold:  " + register.getProductList().size() + "\n\n" +
				"* Thank you for shopping at out store! *");
		
		// Close streams.
		writer.close();
		fout.close();
		scanner.close();
		fin.close();
	}

}
