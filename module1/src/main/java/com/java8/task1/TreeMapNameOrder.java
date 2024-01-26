package com.java8.task1;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapNameOrder {

	public static void main(String[] args) {
		TreeMap<Student, Integer> map = new TreeMap<>();
		Student e1 = new Student("Praveen");
		Student e2 = new Student("Ram");
		Student e3 = new Student("Surya");
		Student e4 = new Student("Abhi");
		map.put(e1, 1);
		map.put(e2, 3);
		map.put(e3, 2);
		map.put(e4, 4);
		for (Map.Entry<Student,Integer > emap : map.entrySet()) {
			System.out.println(emap.getKey() + " " + emap.getKey().getName());
		}
	}
}

class Student implements Comparable<Student> {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		System.out.println("I am in compare");
		return this.getName().compareTo(o.getName());
	}
}