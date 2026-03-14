package com.capgemini.practice.streamsApi1;

import java.util.*;

class Student1{
	int id;
	String name;
	public Student1(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return "Student["+id+",Name: "+name+"]";
	}
}

public class Streams3 {
	public static void main(String[] args) {
		List<Student1> students = Arrays.asList(
				new Student1(101,"sohail"),
				new Student1(103,"ashraf"),
				new Student1(104,"khan"),
				new Student1(102,"shaik")
		);
		students.stream().sorted(Comparator.comparingInt(s -> s.id))
		.forEach(System.out::println);
		System.out.println();
		students.stream().sorted(Comparator.comparing(s -> s.name)).forEach(System.out::println);
		System.out.println();
		students.stream().sorted(Comparator.comparingInt((Student1 s) -> s.id).reversed()).forEach(System.out::println);
		System.out.println();
		students.stream().sorted(Comparator.comparing((Student1 s) -> s.name).reversed()).forEach(System.out::println);
		System.out.println("---------------------------------------");
		students.stream().sorted(Comparator.comparing((Student1 s) -> s.name).reversed().thenComparingInt(s -> s.id)).forEach(System.out::println);
		System.out.println();
	}
}
