package com.java8.task1;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetDescendingOrder {

	public static void main(String[] args) {
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
	}

}
