package com.java8.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComperatorStringDemo {

	public static void main(String[] args) {
		// 6. Use Comparator inerface to sort given list of Employees in the alphabetic
		// order of their name
		List<Employee> employeeList = new ArrayList<>();
		Employee e1 = new Employee("Praveen");
		Employee e2 = new Employee("Ram");
		Employee e3 = new Employee("Surya");
		Employee e4 = new Employee("Abhi");
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.sort(new NameComperatorImpl());
		for (Employee employee : employeeList)
			System.out.println(employee.getName());

		Employee e5 = new Employee("Bharat");
		employeeList.add(e5);
		// With Lambda
		Comparator<Employee> comp = (o1, o2) -> {
			return o1.getName().compareTo(o2.getName());
		};
		employeeList.sort(comp);
		for (Employee employee : employeeList)
			System.out.println(employee.getName());

		// Descending order by Employee name
		// 11. Use Collections.Sort to sort the given list of Employees in decending
		// order of their name
		Collections.sort(employeeList, Collections.reverseOrder());
		for (Employee employee : employeeList)
			System.out.println(employee.getName());

		System.out.println("");
		Employee e6 = new Employee("Tanya");
		employeeList.add(e6);

		// With Lambda
		employeeList  = employeeList.stream().sorted(comp.reversed()).collect(Collectors.toList());
		for (Employee employee : employeeList)
			System.out.println(employee.getName());
	}
}

class NameComperatorImpl implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		System.out.println("I am in compare");
		return o1.getName().compareTo(o2.getName());
	}
}

class Employee implements Comparable<Employee> {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(String name) {
		this.name = name;
	}

	// This is for printing reverse order
	@Override
	public int compareTo(Employee o) {
		System.out.println("I am in compareTo");
		return this.getName().compareTo(o.getName());
	}
}