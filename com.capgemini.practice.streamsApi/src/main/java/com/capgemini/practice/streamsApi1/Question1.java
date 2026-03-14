package com.capgemini.practice.streamsApi1;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
      List<Integer> nums = Arrays.asList(5,2,8,1,9);
      nums.stream().filter(n -> n % 2 != 0).sorted()
      .forEach(System.out::println);
  }
}