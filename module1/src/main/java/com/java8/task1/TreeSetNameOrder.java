package com.java8.task1;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetNameOrder {

	public static void main(String[] args) {
		TreeSet<Employee1> employeeList = new TreeSet<>();
		Employee1 e1 = new Employee1("Praveen");
		Employee1 e2 = new Employee1("Ram");
		Employee1 e3 = new Employee1("Surya");
		Employee1 e4 = new Employee1("Abhi");
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);

		for (Employee1 employee : employeeList)
			System.out.println(employee.getName());
		System.out.println("*****************************************");
		
		System.out.println("--- Set after sorted (Reverse order) ---");
		employeeList.stream().sorted(Comparator.reverseOrder())
		.forEach(System.out::println);
		System.out.println("*****************************************");
		Employee1 e5 = new Employee1("Bharat");
		employeeList.add(e5);
		System.out.println("--- Set after sorted (Reverse order) ---");
		employeeList.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
				.forEach(System.out::println);
		System.out.println("*****************************************");
	}
}

class Employee1 implements Comparable<Employee1> {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee1(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee1 o) {
		System.out.println("I am in compare");
		return this.getName().compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		return "name "+name;
	}
}