package com.java8.bifunction;

public class Product {
	private String name;
	private Double price;

	public Product() {

	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public Product setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nname " + name).append("\nprice " + price);
		return builder.toString();
	}

}
