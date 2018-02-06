package com.alexmaurizio.ITV.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.alexmaurizio.ITV.Business.CheckoutProcessor;
import com.alexmaurizio.ITV.Business.FileLoader;
import com.alexmaurizio.ITV.Models.Product;

class RealisticUseCase {

  @Test
  void test() {

    // Load DB with realistic products
    ArrayList<Product> products = FileLoader.loadProducts("C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\product_db_real");		
    products = FileLoader.matchSpecialOffers(products, "C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\special_prices_real"); 

    // Instance Processor
    CheckoutProcessor processor = new CheckoutProcessor(products);

    // Scan a lot of Amazon ASINs
    processor.acceptScan("B008A20QG8");    	
    processor.acceptScan("B076ZWVPXL");    	   	
    processor.acceptScan("B06XGDPKYL");    	
    processor.acceptScan("B0183QNQ1C");    	
    processor.acceptScan("B0183QNQ1C");    	
    processor.acceptScan("B01N322FR3");    	
    processor.acceptScan("B01MEFF9QN");    	
    processor.acceptScan("B01N322FR3");    	

    // Calculate Result
    Integer result = processor.calculate();

    // Math time
    assertTrue(result.equals(6876));    	


  }

}
