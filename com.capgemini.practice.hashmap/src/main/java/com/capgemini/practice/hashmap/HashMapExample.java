/**
 * 
 */
package com.capgemini.practice.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public interface HashMapExample {
	public static void example1() {
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(1, 4);
		map.put(2, 8);
		map.put(3, 16);
		map.put(5, null);
		map.put(5, 4);
		map.put(5, 8);
		
		HashMap<Integer,Integer> map1 = new HashMap<>();
		map1.put(1, 4);
		map1.put(2, 8);
		map1.put(3, 16);
		map1.put(5, null);
		map1.put(5, 4);
		map1.put(5, 8);
		System.out.println(map);
		System.out.println(map.containsKey(5));
		System.out.println(map.keySet());	
		System.out.println(map.getOrDefault(6, 99));
		System.out.println(map.toString());
		System.out.println(map.equals(map1));
		System.out.println(map.hashCode());
		System.out.println(map1.hashCode());
		for(Map.Entry<Integer,Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}
