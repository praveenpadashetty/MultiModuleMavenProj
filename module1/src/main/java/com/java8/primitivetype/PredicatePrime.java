package com.java8.primitivetype;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicatePrime {
	public static void main(String[] args) {
		// Write an IntPredicate to verify if the given number is a primenumber
		Predicate<Integer> pred = num -> {
			int mid = num / 2;
			if (num <= 1) {
				return false;
			}
			for (int i = 2; i <= mid; i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		};
		System.out.println(pred.test(13));

		// Write an IntConsumer to print square of the given number

		Consumer<Integer> consume = i -> System.out.println(i * i);
		consume.accept(5);

		// Write a IntSupplier to give random int below 5000. .
		Supplier<Integer> getOtp = () -> ThreadLocalRandom.current().nextInt(1, 5000);
		System.out.println(getOtp.get());
	}
}
