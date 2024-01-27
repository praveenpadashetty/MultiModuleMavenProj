package com.java8.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDriver {

	public static void main(String[] args) {
		List<Product> products = getProductList();

		// Task1
		Predicate<Product> priceCondition1000 = prd -> prd.getPrice() > 1000;
		List<Product> list = products.stream().filter(priceCondition1000).collect(Collectors.toList());
		System.out.println(list);
		System.out.println("************************************************");

		// Task2
		Predicate<Product> categoryCondition = prd -> prd.getCategory().equals("Electronics");
		list = products.stream().filter(categoryCondition).collect(Collectors.toList());
		System.out.println(list);
		System.out.println("************************************************");

		// Task3
		Predicate<Product> priceCon = prd -> prd.getPrice() > 100;
		list = products.stream().filter(categoryCondition.and(priceCon)).collect(Collectors.toList());
		System.out.println(list);
		System.out.println("************************************************");

		// Task4
		list = products.stream().filter(categoryCondition.or(priceCon)).collect(Collectors.toList());
		System.out.println(list);
		System.out.println("************************************************");

		// Task5
		Predicate<Product> priceCondLessThan100 = prd -> prd.getPrice() < 100;
		list = products.stream().filter(categoryCondition.and(priceCondLessThan100)).collect(Collectors.toList());
		System.out.println(list);
		System.out.println("************************************************");

		// Task10 covering negate scenario (displays other then Electronics and greater than 1000)
		list = products.stream().filter(categoryCondition.negate().and(priceCondition1000)).collect(Collectors.toList());
		System.out.println(list);
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
