package com.capgemini.practice.streamsApi1;

public class Streams4 {
	public static void main(String[] args) {
		
	}
}

class Employee {
    int id;
    String name;
    String department;
    double salary;
    int age;
	public Employee(int id, String name, String department, double salary, int age) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public double getSalary() {
		return salary;
	}
	public int getAge() {
		return age;
	}
}

