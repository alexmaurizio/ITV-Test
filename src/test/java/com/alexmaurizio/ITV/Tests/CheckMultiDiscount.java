package com.alexmaurizio.ITV.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.alexmaurizio.ITV.Business.CheckoutProcessor;
import com.alexmaurizio.ITV.Business.FileLoader;
import com.alexmaurizio.ITV.Models.Product;

class CheckMultiDiscount {

  @Test
  void test() {

    // Load DB
    ArrayList<Product> products = FileLoader.loadProducts("C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\product_db");		
    products = FileLoader.matchSpecialOffers(products, "C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\special_prices"); 

    // Instance Processor
    CheckoutProcessor processor = new CheckoutProcessor(products);

    // Scan 14 As
    for(int i = 0; i < 14; i++)
      processor.acceptScan("A");    	

    // Calculate Result
    Integer result = processor.calculate();

    // 12 products = 3x1.30 -> 12x5.20 + 2 x 0.50 = 6.20
    assertTrue(result.equals(620));    	


  }

}
