package com.java8.funcinterface;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@FunctionalInterface
public interface FuncInterface {

	public void calculateCostOfProduct(List<Product> products);

	static void getProductDetails(List<Product> products) {
		Predicate<Product> priceCondition1000 = prd -> prd.getPrice() > 1000;
		Predicate<Product> categoryCondition = prd -> prd.getCategory().equals("Electronics");
		List<Product> list = products.stream().filter(categoryCondition.and(priceCondition1000))
				.collect(Collectors.toList());
		System.out.println(list);
	}

}
