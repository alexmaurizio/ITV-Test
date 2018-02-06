package com.alexmaurizio.ITV.Business;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.alexmaurizio.ITV.Models.Product;

public class CheckoutProcessor {

  // Internal Data
  private ArrayList<Product> internalDatabase;
  private Map<Product, Integer> productCounter;
  private Integer finalInvoice;

  // Construct
  public CheckoutProcessor(ArrayList<Product> products) {

    // Populate DB and generate a new, empty HashMap
    this.internalDatabase = products;
    this.productCounter = new HashMap<Product, Integer>();
    this.finalInvoice = 0;

    // Log
    System.out.println("[INFO] Starting Checkout Process! Waiting for scans..");

  }

  // Methods

  /**
   * Accepts a String SKU and adds it to the internal checkout
   */
  public Boolean acceptScan(String sku)
  {
    // Check if the Internal DB has this product
    Product find = Product.findBySku(sku, internalDatabase);

    // Check if the product is in the DB
    if (find == null)
    {
      // Product is not in the DB, throw a warning, return false and continue
      System.out.println("[WARN] The scanned SKU `" + sku + "` was not found in the database! Continuing..");
      return false;
    }
    // Check if we scanned this product before
    if(productCounter.containsKey(find))
    {
      // Increase the counter
      productCounter.replace(find, productCounter.get(find)+1 );
    }		
    else
    {
      // Add in map
      productCounter.put(find, 1);			
    }

    // Accepted
    System.out.println("[INFO] Scanned Product " + sku + " - " + find.getName());
    return true;

  }

  /**
   * Prints and returns the actual map for debugging
   */
  public Map<Product, Integer> printList() {

    // Iterate and print the map
    System.out.println("\n\n\n-----------------------");
    System.out.println("---- PRODUCT LIST -----");
    for (Map.Entry<Product, Integer> entry : productCounter.entrySet())
    {
      System.out.println("-- " + entry.getKey().getName() + " \t Qty: " + entry.getValue());
    }
    System.out.println("-----------------------\n\n\n");

    // Return the map for convenience
    return productCounter;
  }

  /**
   * Calculate the final price, print the invoice and return the price
   */
  public Integer calculate() {

    // Set Number Format for formatting
    NumberFormat numFormat = NumberFormat.getCurrencyInstance(Locale.UK); 

    // Log END SCANS
    System.out.println("[INFO] Checkout & Scans Completed! Starting invoice calculation..");

    // Pretty Console
    System.out.println("\n\n\n----------------------------");
    System.out.println("------ FINAL INVOICE -------");
    System.out.println("----------------------------");

    // Iterate the map
    for (Map.Entry<Product, Integer> entry : productCounter.entrySet())
    {
      // Get the key and the count
      Product prod = entry.getKey();
      Integer count = entry.getValue();
      Integer thisCost;

      // For each product, check if there is a special price
      if (prod.hasSpecialOffer())
      {
        // Divide the count by the trigger, calculate how many discounts apply
        Integer timesDiscount = (int) Math.round(Math.floor(count / prod.getSpecialPriceMinTrigger()));

        // Count the remaining (non-special priced) products
        Integer discounted = prod.getSpecialPriceMinTrigger() * timesDiscount;
        Integer remaining = count - discounted;

        // Add to the total sum
        thisCost = (timesDiscount*prod.getSpecialPrice()) + (remaining * prod.getPrice());
      }
      else
      {
        // Normal processing
        thisCost = prod.getPrice() * count;				
      }

      // Print a line for this entry
      System.out.println(String.format("%4d", count) + "x " + prod.getName() + " \t " + numFormat.format(thisCost/100.0));

      // Print additional line when there is a special discount and it's applied
      if (prod.hasSpecialOffer() && count >= prod.getSpecialPriceMinTrigger())
        System.out.println("     >> BUY " + prod.getSpecialPriceMinTrigger() + " FOR " +  numFormat.format(prod.getSpecialPrice()/100.0));


      // Add to the invoice 
      finalInvoice += thisCost;			


    }

    // Pretty console and print the Invoice
    System.out.println("----------------------------");
    System.out.println("--- TOTAL PRICE: " +  numFormat.format(finalInvoice/100.0));
    System.out.println("----------------------------");
    System.out.println("--- THANKS FOR SHOPPING! ---");
    System.out.println("----------------------------\n\n");

    // Return the price
    return finalInvoice;

  }

}
