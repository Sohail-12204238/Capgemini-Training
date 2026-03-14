/**
 * 
 */
package com.capgemini.practice.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public interface HashMapQuestion1 {
	public static void question1(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i : arr) {
			map.put(i,map.getOrDefault(i, 0)+1);
		}
		for(Map.Entry<Integer,Integer> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		for(int i : map.values()) {
			
		}
	}
}
