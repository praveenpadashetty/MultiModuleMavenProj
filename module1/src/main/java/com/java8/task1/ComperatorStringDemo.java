package com.java8.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComperatorStringDemo {

	public static void main(String[] args) {
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
		
		//Descending order by Employee name
		Collections.sort(employeeList,Collections.reverseOrder());
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

class Employee implements Comparable<Employee>{
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

	//This is for printing reverse order
	@Override
	public int compareTo(Employee o) {
		System.out.println("I am in compareTo");
		return this.getName().compareTo(o.getName());
	}
}