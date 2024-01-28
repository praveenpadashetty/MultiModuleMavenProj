package com.java8.constructorref;

public class ConstructorReference {

	public static void main(String[] args) {
		TriFunction<String, Long, Double, Employee> tri= ( name,  account,  salary)->new Employee(name, account, salary);
		Employee e = tri.apply("Satish",2423443L,23432.432);
		e.getEmployeeDetails();
	}
}
