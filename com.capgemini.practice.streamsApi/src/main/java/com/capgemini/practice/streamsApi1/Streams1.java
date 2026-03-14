/**
 * 
 */
package com.capgemini.practice.streamsApi1;

/**
 * 
 */
import java.util.*;
import java.util.stream.Collectors;

public class Streams1 {
    public static void main(String[] args) {
      int[] arr = {4,9,6,1,2};
      Arrays.stream(arr)
      .filter(n -> n > 3)
      .map(n -> n * 3)
      .forEach(System.out::println);
      
      System.out.println();
      Arrays.stream(arr)
      .filter(n -> n > 3)
      .map(n -> n * 3)
      .sorted()
      .limit(2)
      .forEach(System.out::println);
      
      System.out.println();
      List<Integer> even = Arrays.stream(arr)
      .filter(n -> n % 2 == 0)
      .boxed()
      .collect(Collectors.toList());
      System.out.println(even);
      
      System.out.println();
      List<Integer> nums = Arrays.asList(1,2,4,5,7);
      int sum = nums.stream().reduce(0, (a,b)-> a+b);
      System.out.println(sum);
      int sum1 = nums.stream().mapToInt(Integer::intValue).sum();
      System.out.println(sum1);
      Integer sum2 = nums.stream().reduce(0, (a,b)-> a+b);
      System.out.println(sum2);
  }
}