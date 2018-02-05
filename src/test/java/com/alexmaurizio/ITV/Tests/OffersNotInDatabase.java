package com.alexmaurizio.ITV.Tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.alexmaurizio.ITV.Business.CheckoutProcessor;
import com.alexmaurizio.ITV.Business.FileLoader;
import com.alexmaurizio.ITV.Models.Product;

class OffersNotInDatabase {

	@Test
	void test() {

		// Load DB - The offer DB contains products that are not in the main database! 
		// Console should warn about it		
		ArrayList<Product> products = FileLoader.loadProducts("C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\product_db");		
		products = FileLoader.matchSpecialOffers(products, "C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\special_prices_nonpresent"); 

		// Instance Processor
		CheckoutProcessor processor = new CheckoutProcessor(products);

		// Load B, then A, then B
		processor.acceptScan("B");
		processor.acceptScan("A");
		processor.acceptScan("B");

		// Calculate Result
		Double result = processor.calculate();

		// Check if 0.95 as the requirements
		assertTrue(result.equals(0.95D));   


	}

}
