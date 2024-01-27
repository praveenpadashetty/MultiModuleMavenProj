package com.java8.consumerandsupplier;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Product {
	private String printParam;
	private String name;
	private Double price;
	private String category;
	private String grade;

	public Product() {

	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public Product setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Product setCategory(String category) {
		this.category = category;
		return this;
	}

	public Product setGrade(String grade) {
		this.grade = grade;
		return this;
	}

	public Product setPrintParam(String printParam) {
		this.printParam = printParam;
		return this;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public String getGrade() {
		return grade;
	}

	//Task1
	public void print() {
		if (printParam.equals("CONSOLE")) {
			StringBuilder builder = new StringBuilder();
			builder.append("\nname " + name).append("\nprice " + price).append("\ncategory " + category)
					.append("\ngrade " + grade);
			System.out.println(builder.toString());
		}
		if (printParam.equals("FILE")) {
			System.out.println("This will print in File");
		}
	}

	//Task2
	public void updateCategoryBasedOnPrice(List<Product> products) {
		if (getGrade().equals("Premium")) {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getPrice() > 1000.00) {
					Product p = new Product().setName(products.get(i).getName());
					p.setGrade(getGrade());
					p.setPrice(products.get(i).getPrice());
					p.setCategory(products.get(i).getCategory());
					products.set(i, p);
				}
			}
		}
		System.out.println("Updated product list " + products);
		
	}
	
	//Task3
	public void updateNameBasedOnPrice(List<Product> products) {
		if (getName().equals("*")) {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getPrice() > 3000.00) {
					Product p = new Product().setName(products.get(i).getName()+getName());
					p.setGrade(products.get(i).getGrade());
					p.setPrice(products.get(i).getPrice());
					p.setCategory(products.get(i).getCategory());
					products.set(i, p);
				}
			}
		}
		System.out.println("Updated product list " + products);
		
		//Task4
		Predicate<Product> nameSuffixed = prd -> prd.getName().endsWith("*");
		List<Product> list = products.stream().filter(nameSuffixed)
				.collect(Collectors.toList());
		System.out.println(list);
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nname " + name).append("\nprice " + price).append("\ncategory " + category)
				.append("\ngrade " + grade);
		return builder.toString();
	}

}
