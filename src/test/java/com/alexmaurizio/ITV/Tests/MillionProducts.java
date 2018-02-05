package com.alexmaurizio.ITV.Tests;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.alexmaurizio.ITV.Business.CheckoutProcessor;
import com.alexmaurizio.ITV.Business.FileLoader;
import com.alexmaurizio.ITV.Models.Product;

class MillionProducts {

	@Test
	void test() {
			
		// Load DB
		ArrayList<Product> products = FileLoader.loadProducts("C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\product_db");		
		products = FileLoader.matchSpecialOffers(products, "C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\special_prices"); 
		
		// Instance Processor
		CheckoutProcessor processor = new CheckoutProcessor(products);
		
		// DISABLE CONSOLE LOG
		PrintStream originalStream = System.out;
		PrintStream dummyStream = new PrintStream(new OutputStream(){ public void write(int b) {}});
		System.setOut(dummyStream);
		
		// OVERLOAD the processor with millions scans
		for(int i = 0; i < 1000000; i++)
		{
			processor.acceptScan("A"); 
			processor.acceptScan("B"); 
			processor.acceptScan("C"); 
			processor.acceptScan("D"); 
		}
		
		// Reset the Console
		System.setOut(originalStream);
		   	    	
    	// Calculate Result
    	processor.calculate();    	

    	
		
	}

}
