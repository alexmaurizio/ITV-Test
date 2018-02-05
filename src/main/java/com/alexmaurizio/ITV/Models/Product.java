package com.alexmaurizio.ITV.Models;

import java.util.ArrayList;

public class Product {
	
	// Attributes
	private String  sku;
	private String  name;
	private Double  price;
	private Double  specialPrice;
	private Integer specialPriceMinTrigger;

	
	// Getters & Setters	
	public String getSku()	{
		return sku;
	}	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}
	
	public Integer getSpecialPriceMinTrigger() {
		return specialPriceMinTrigger;
	}
	public void setSpecialPriceMinTrigger(Integer specialPriceMinimumTrigger) {
		this.specialPriceMinTrigger = specialPriceMinimumTrigger;
	}
	
	
	// Find By SKU Static Method
	// Searches an array of Products and return by SKU, else return null
	public static Product findBySku(String sku, ArrayList<Product> search)
	{
		for (Product oldProd: search) {
    		if(oldProd.getSku().equals(sku))
    		{
    			return oldProd;
    		}
    	}
		return null;
	}
	
	/**
	 * Check if there is a special offer for this product
	 */
	public Boolean hasSpecialOffer() {
		return this.specialPrice != null;
	}

}
