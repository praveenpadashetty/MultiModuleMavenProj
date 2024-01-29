package com.java8.task1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SecondHighestNum {

	public static void print2largest(int arr[]) {
		int i, max, secondMax;
		if (arr.length < 2) {
			System.out.print(" Invalid Input ");
			return;
		}

		max = secondMax = Integer.MIN_VALUE;
		for (i = 0; i < arr.length; i++) {
			/*
			 * If current element is greater than first then update both first and second
			 */
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			}

			/*
			 * If arr[i] is in between first and second then update second
			 */
			else if (arr[i] > secondMax && arr[i] != max)
				secondMax = arr[i];
		}

		if (secondMax == Integer.MIN_VALUE)
			System.out.print("There is no second largest" + " element\n");
		else
			System.out.print("The second largest element" + " is " + secondMax);
	}

	public static void main(String[] args) {
		int array[] = { 12, 35, 1, 10, 34, 1 };
		print2largest(array);

		// With Lambda
		List<Integer> list1 = Arrays.asList(12, 35, 1, 10, 34, 1);
		Function<List<Integer>, Integer> func = (list) -> {
			int i, max, secondMax;
			if (list.size() < 2) {
				System.out.print(" Invalid Input ");
				return 0;
			}
			max = secondMax = Integer.MIN_VALUE;
			for (i = 0; i < list.size(); i++) {
				if (list.get(i) > max) {
					secondMax = max;
					max = list.get(i);
				} else if (list.get(i) > secondMax && list.get(i) != max)
					secondMax = list.get(i);
			}
			if (secondMax == Integer.MIN_VALUE)
				return 0;
			else
				return secondMax;

		};
		System.out.println("\nfrom lambda "+func.apply(list1));
	}

}
