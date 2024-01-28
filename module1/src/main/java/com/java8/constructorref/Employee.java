package com.java8.constructorref;

public class Employee {
	String name;
	Long account;
	Double salary;
	
	public Employee(String name, Long account, Double salary) {
		super();
		this.name = name;
		this.account = account;
		this.salary = salary;
	}
	
	public void getEmployeeDetails() {
		System.out.println("name "+name);
		System.out.println("account "+account);
		System.out.println("salary "+salary);
	}

}
