package com.alexmaurizio.ITV.Tests;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.alexmaurizio.ITV.Business.CheckoutProcessor;
import com.alexmaurizio.ITV.Business.FileLoader;
import com.alexmaurizio.ITV.Models.Product;

class WrongSKUs {

	@Test
	void test() {
			
		// Load DB
		ArrayList<Product> products = FileLoader.loadProducts("C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\product_db");		
		products = FileLoader.matchSpecialOffers(products, "C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\special_prices"); 
		
		// Instance Processor
		CheckoutProcessor processor = new CheckoutProcessor(products);
		
		// Scan random stuff, should not crash
		for(int i = 0; i < 10; i++)
		{
			processor.acceptScan("A"); 
			processor.acceptScan("B"); 
			processor.acceptScan("43%%%%%56"); 
			processor.acceptScan("54wqae5"); 
			processor.acceptScan("A"); 
			processor.acceptScan("B"); 
			processor.acceptScan("asa"); 
			processor.acceptScan("A"); 
			processor.acceptScan("D"); 
			processor.acceptScan("$%&/@@C"); 
		}
		   	    	
    	// Calculate Result
    	processor.calculate();
    	
    	
    	
    	// Should not crash
    	
		
	}

}
