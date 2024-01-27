package com.java8.consumerandsupplier;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		// Write a supplier to produce a random product.
		Supplier<List<Product>> prod = () -> ConsumerDemo.getProductList();
		List<Product> list = prod.get();
		Random rand = new Random();
		System.out.println(list.get(rand.nextInt(list.size())).getName());

		// Write a supplier to produce a random OTP.
		Supplier<Long> getOtp = () -> ThreadLocalRandom.current().nextLong(100000, 999999);
		System.out.println(getOtp.get());
	}
}