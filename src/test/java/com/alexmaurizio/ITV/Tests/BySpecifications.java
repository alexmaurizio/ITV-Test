package com.alexmaurizio.ITV.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.alexmaurizio.ITV.Business.CheckoutProcessor;
import com.alexmaurizio.ITV.Business.FileLoader;
import com.alexmaurizio.ITV.Models.Product;

class BySpecifications {

  @Test
  void test() {

    // Load DB
    ArrayList<Product> products = FileLoader.loadProducts("C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\product_db");		
    products = FileLoader.matchSpecialOffers(products, "C:\\Development\\Java\\Workspace\\ITV-Test\\src\\test\\resources\\special_prices"); 

    // Instance Processor
    CheckoutProcessor processor = new CheckoutProcessor(products);

    // Load B, then A, then B
    processor.acceptScan("B");
    processor.acceptScan("A");
    processor.acceptScan("B");

    // Calculate Result
    Integer result = processor.calculate();

    // Check if 0.95 as the requirements
    assertTrue(result.equals(95));    	


  }

}
