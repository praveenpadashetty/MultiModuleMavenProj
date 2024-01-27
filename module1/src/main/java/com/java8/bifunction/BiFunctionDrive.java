package com.java8.bifunction;

import java.util.function.BiFunction;

public class BiFunctionDrive {

	public static void main(String[] args) {
		BiFunction<String, Double, Product> bifunc = (name, price) -> new Product(name, price);
		Product p = bifunc.apply("Jeans", 1200.00);
		System.out.println(p.getPrice());
		BiFunction<Product, Integer, Double> bicost = (pro, qty) -> {
			return pro.getPrice() * qty;
		};
		System.out.println(bicost.apply(p, 3));
	}
}
