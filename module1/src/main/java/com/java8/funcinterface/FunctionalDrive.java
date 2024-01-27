package com.java8.funcinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalDrive {

	public static void main(String[] args) {
		List<Product> products = getProductList();

		// 1. Write a function to calculate the cost of all products in a given list of
		// products.
		FuncInterface funcInt = (List<Product> list) -> {
			List<Product> l = list.stream().collect(Collectors.toList());
			Double sum = 0.0;
			for (int i = 0; i < l.size(); i++) {
				sum += l.get(i).getPrice();
			}
			System.out.println("Cost of all products " + sum);
		};
		funcInt.calculateCostOfProduct(products);
		System.out.println("************************************************");

		// 2. Write a function to calculate the cost of all products whose prices is >
		// 1000/- in the given list of products.
		funcInt = (List<Product> list) -> {
			Predicate<Product> priceCondition1000 = prd -> prd.getPrice() > 1000;
			List<Product> l = products.stream().filter(priceCondition1000).collect(Collectors.toList());
			Double sum = 0.0;
			for (int i = 0; i < l.size(); i++) {
				sum += l.get(i).getPrice();
			}
			System.out.println("Cost of products have >1000 " + sum);
		};
		funcInt.calculateCostOfProduct(products);
		System.out.println("************************************************");

		// 3. Write a function to calculate the cost of all electronic products in the
		// given list of products.
		funcInt = (List<Product> list) -> {
			Predicate<Product> categoryCondition = prd -> prd.getCategory().equals("Electronics");
			List<Product> l = products.stream().filter(categoryCondition).collect(Collectors.toList());
			Double sum = 0.0;
			for (int i = 0; i < l.size(); i++) {
				sum += l.get(i).getPrice();
			}
			System.out.println("Cost of products have electronic category " + sum);
		};
		funcInt.calculateCostOfProduct(products);
		System.out.println("************************************************");

		// 4.Write a function to get all the products whose price is is > 1000/- and
		// belongs to electronic category.
		FuncInterface.getProductDetails(products);
		System.out.println("************************************************");
	}

	public static List<Product> getProductList() {
		List<Product> products = new ArrayList<>();
		Product.Builder build = new Product.Builder().setName("Fan").setPrice(1100.00).setCategory("Electronics")
				.setGrade("Premium");
		Product p1 = build.build();
		products.add(p1);
		build = new Product.Builder().setName("Lights").setPrice(99.00).setCategory("Electronics").setGrade("Average");
		p1 = build.build();
		products.add(p1);
		build = new Product.Builder().setName("Bulbs").setPrice(110.00).setCategory("Electronics").setGrade("Premium");
		p1 = build.build();
		products.add(p1);
		build = new Product.Builder().setName("Shirt").setPrice(999.00).setCategory("Cloths").setGrade("Premium");
		p1 = build.build();
		products.add(p1);
		build = new Product.Builder().setName("Pant").setPrice(1999.00).setCategory("Cloths").setGrade("Premium");
		p1 = build.build();
		products.add(p1);
		return products;
	}

}
