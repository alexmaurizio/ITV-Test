package com.alexmaurizio.ITV;

import java.util.ArrayList;

import com.alexmaurizio.ITV.Business.CheckoutProcessor;
import com.alexmaurizio.ITV.Business.FileLoader;
import com.alexmaurizio.ITV.Models.Product;

public class Main {

  public static void main(String[] args) {

    // Debug Flag
    Boolean debug = false;    	

    /**
     * STARTUP LOADING PHASE
     */

    // Load Products from the initial DB
    ArrayList<Product> products = FileLoader.loadProducts("C:\\Development\\Java\\Workspace\\ITV-Test\\src\\main\\resources\\product_db");

    // Load Special Offers
    products = FileLoader.matchSpecialOffers(products, "C:\\Development\\Java\\Workspace\\ITV-Test\\src\\main\\resources\\special_prices");    	

    // Debug Print Product Loaded
    if(debug)
      FileLoader.printDatabase(products);  	

    /**
     * 
     * END STARTUP LOADING PHASE
     * 
     * BEGIN CHECKOUT TRANSACTION
     * 
     */

    // Pass the loaded DB to the checkout processor
    CheckoutProcessor processor = new CheckoutProcessor(products);

    // Process the data!    	
    processor.acceptScan("B");
    processor.acceptScan("A");
    processor.acceptScan("B");


    // Debug Print Resulting Map
    if (debug)
      processor.printList();

    // Calculate the price and end the checkout session
    processor.calculate();

  }   

}
