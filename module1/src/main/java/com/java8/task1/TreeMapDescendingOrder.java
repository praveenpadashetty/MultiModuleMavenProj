package com.java8.task1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
		System.out.println("****************************************************");
		
		//Lambda
		map = new TreeMap<>(Comparator.reverseOrder());
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 1);
		map.put(6, 6);
		
		map.entrySet().stream().forEach(e-> System.out.println(e));
		System.out.println("****************************************************");
		Map<Integer, Integer> sortedMap = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (oldKey, newKey) -> oldKey,
						LinkedHashMap::new));
		for(Map.Entry<Integer, Integer> emap : sortedMap.entrySet()) {
			System.out.println(emap.getKey() +" "+ emap.getValue());
		}
	}

}
