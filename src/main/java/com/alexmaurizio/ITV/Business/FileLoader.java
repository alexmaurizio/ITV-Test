package com.alexmaurizio.ITV.Business;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.alexmaurizio.ITV.Models.Product;

public class FileLoader {

	/**
	 * Loads the products from a semicolon-separated list
	 */
	public static ArrayList<Product> loadProducts(String path) {

		// The return array
		ArrayList<Product> products = new ArrayList<Product>();

		// Load the file from Path
		File file = new File(path);

		// Launch Scanner
		try (Scanner scanner = new Scanner(file)) {

			// Iterate Lines and generate products
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				// Split the semicolon and populate
				String[] parts = line.split(";");

				// Populate new product
				Product product = new Product();
				product.setSku(parts[0]);
				product.setName(parts[1]);
				product.setPrice(Integer.parseInt(parts[2]));

				// Add it to the array 
				products.add(product);
			}

			scanner.close();

		} catch (IOException e) {
			System.err.println("[FATAL] The DATABASE File was not found. The path is hardcoded for now, sorry! Just point the path to the product_db file in /src/main/resources/ ");
			System.exit(-1);
		}

		// Return
		return products;


	}

	/**
	 * Loads special offers from a semicolon-separated file and matches against DB
	 */
	public static ArrayList<Product> matchSpecialOffers(ArrayList<Product> products, String path) {

		// Load the file from Path
		File file = new File(path);

		// Launch Scanner
		try (Scanner scanner = new Scanner(file)) {

			// Iterate Lines and generate products
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				// Split the semicolon and populate
				String[] parts = line.split(";");

				String  newSku = parts[0];				
				Integer specPriceTrigger = Integer.parseInt(parts[1]);
				Integer specPrice = Integer.parseInt(parts[2]);
				Boolean found = false;

				// Check if there is a matching product in our database to add the special offer data					
				for (Product oldProd: products) {
					if(oldProd.getSku().equals(newSku))
					{
						// Populate the product with the special offer
						oldProd.setSpecialPrice(specPrice);
						oldProd.setSpecialPriceMinTrigger(specPriceTrigger);

						// Set and exit
						found = true;
						break;
					}
				}

				// If not found - WARN to the console
				if(!found) {
					System.out.println("[WARN] There is an offer for product " + newSku + ", but it's not in the database! Ignoring..");
				}
			}

			scanner.close();

		} catch (IOException e) {
			System.err.println("[FATAL] The SPECIAL OFFER File was not found. The path is hardcoded for now, sorry! Just point the path to the special_prices file in /src/main/resources/ ");
			System.exit(-1);
		}

		// Return
		return products;
	}

	/**
	 * Debug: Prints the database
	 */
	public static void printDatabase(ArrayList<Product> products) {
		System.out.println("\n---- LOADED DATABASE ----");

		for (Product p: products) {
			System.out.print("\nSKU: " + p.getSku());
			System.out.print(" \t Name: " + p.getName());
			System.out.println(" \t Price: " + String.format("%.2f", p.getPrice()) + "£");

			if(p.hasSpecialOffer())
			{
				System.out.println("----- SPECIAL OFFER! " + p.getSpecialPriceMinTrigger() + " for "+ String.format("%.2f", p.getSpecialPrice()) + "£ -----");
			}

		}
		System.out.println("\n-------------------------\n\n\n");
	}

}
