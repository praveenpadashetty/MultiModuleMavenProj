package com.java8.consumerandsupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
