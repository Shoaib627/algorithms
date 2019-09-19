package com.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MyHashSet {

	Map<Integer, Integer> map;
	
    public MyHashSet() {
        this.map = new HashMap<>();
    }
    
    public void add(int key) {
    	map.put(key, 0);
    }
    
    public void remove(int key) {
        map.remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	return map.containsKey(key);
    }
}
