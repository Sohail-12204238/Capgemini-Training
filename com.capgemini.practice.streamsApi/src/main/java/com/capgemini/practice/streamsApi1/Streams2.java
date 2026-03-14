/**
 * 
 */
package com.capgemini.practice.streamsApi1;

/**
 * 
 */

import java.util.*;

class Student{
  int id;
  String name;
  public Student(int id,String name){
    this.id = id;
    this.name = name;
  }
  
  @Override
  public String toString(){
    return "Student["+id+", Name: "+name+"]";
  }
}

public class Streams2 {
    public static void main(String[] args) {
      List<Student> students = Arrays.asList(
        new Student(101,"sohail"),
        new Student(103,"ashraf"),
        new Student(102,"shaik")
        );
      students.stream().filter(s -> s.id % 2 == 0).forEach(System.out::println);
  }
}
