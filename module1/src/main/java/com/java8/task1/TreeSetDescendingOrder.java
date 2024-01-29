package com.java8.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetDescendingOrder {

	public static void main(String[] args) {
		// Create a TreeSet that sorts the given set of numbers in reverse order
		TreeSet<Integer> uniqueNumbers = new TreeSet<>();
		uniqueNumbers.add(12);
		uniqueNumbers.add(1);
		uniqueNumbers.add(6);
		uniqueNumbers.add(3);

		NavigableSet<Integer> descendingSet = uniqueNumbers.descendingSet();
		Iterator<Integer> iterator = descendingSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("*****************************************");
		
		// with anonymus
		Comparator<Integer> cts = (i1,i2)->{
			return i2 -i1;
		};
		
		System.out.println(uniqueNumbers.stream().sorted(cts).collect(Collectors.toSet())); 
		System.out.println("*****************************************");
		
		// with lambda
		uniqueNumbers.add(10);
		uniqueNumbers.stream().sorted((i1, i2) -> i2.compareTo(i1)).forEach(System.out::println);

		System.out.println("*****************************************");
		//with List in reverse order 
		List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		List<Integer> sortedList = list.stream().sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList());
		System.out.println(sortedList);
	}

}
