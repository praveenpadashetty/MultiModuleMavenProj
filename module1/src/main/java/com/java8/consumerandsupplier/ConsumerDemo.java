package com.java8.consumerandsupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ConsumerDemo {

	public static void main(String[] args) {
		List<Product> products = getProductList();
		Product product = new Product();
		product = products.get(0);
		// Consumer
		Consumer<Product> p = t -> t.setPrintParam("FILE");
		p.accept(product);
		product.print();

		p = t -> {
			t.setGrade("Premium");
		};
		p.accept(product);
		product.updateCategoryBasedOnPrice(products);
		
		p = t -> {
			t.setName("*");
		};
		p.accept(product);
		product.updateNameBasedOnPrice(products);
		
		
		p = t -> {
			t.setName("*");
		};
		p.accept(product);
		product.updateNameBasedOnPrice(products);
		
		// Streams task
		//3. From the given list of the products get all the products with price> 1000/- and from electronics category. Change the name of the result list into CAP letters before printing. 
		Predicate<Product> categoryCondition = prd -> prd.getCategory().equals("Electronics");
		Predicate<Product> priceCon = prd -> prd.getPrice() > 1000;
		products = products.stream().filter(categoryCondition.and(priceCon)).collect(Collectors.toList());
		product.nameInCapsBasedOnPrice(products);
		
		//4. Calculate the count of all electronic products in the given list of products. 
		products = getProductList();
		System.out.println("Total Electronics products are "+products.stream().filter(categoryCondition).collect(Collectors.toList()).size());

	}

	public static List<Product> getProductList() {
		List<Product> products = new ArrayList<>();
		Product prod = new Product().setName("Fan").setPrice(1100.00).setCategory("Electronics").setGrade("Average");
		products.add(prod);
		prod = new Product().setName("Lights").setPrice(99.00).setCategory("Electronics").setGrade("Average");
		products.add(prod);
		prod = new Product().setName("Bulbs").setPrice(110.00).setCategory("Electronics").setGrade("Premium");
		products.add(prod);
		prod = new Product().setName("Shirt").setPrice(999.00).setCategory("Cloths").setGrade("Premium");
		products.add(prod);
		prod = new Product().setName("Pant").setPrice(1999.00).setCategory("Cloths").setGrade("Average");
		products.add(prod);
		prod = new Product().setName("Jeans").setPrice(3999.00).setCategory("Cloths").setGrade("Average");
		products.add(prod);
		return products;
	}

}
