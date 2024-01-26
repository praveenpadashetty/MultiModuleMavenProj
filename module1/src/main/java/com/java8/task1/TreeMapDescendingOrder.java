package com.java8.task1;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDescendingOrder {

	public static void main(String[] args) {
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 1);
		map.put(6, 6);
		for(Map.Entry<Integer, Integer> emap : map.entrySet()) {
			System.out.println(emap.getKey() +" "+ emap.getValue());
		}
	}

}
