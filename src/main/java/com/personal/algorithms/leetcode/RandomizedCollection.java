package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedCollection {

	

	Map<Integer, List<Integer>> map;
	List<Integer> list;
	int lastIndex;

	public RandomizedCollection() {
		map = new HashMap<>();
		list = new ArrayList<>();
		lastIndex = 0;
	}
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		
		boolean fresh_insert = false;
        

		List<Integer> result = map.getOrDefault(val, new ArrayList<>());
		
		if(result.isEmpty()) {
			fresh_insert = true;
		}
        
        
		result.add(lastIndex);
		map.put(val, result);
		list.add(val);
		lastIndex++; 
            
       
        

		return fresh_insert;
	}
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {

		if (!map.containsKey(val)) {
			return false;
		}

		List<Integer> r = map.get(val);
		Integer index = r.get(r.size() - 1);
		 
		swap(index, lastIndex - 1);
		
		List<Integer> j = map.get(list.get(index));
		
		
		j.set(j.size() - 1, index);
		
		Collections.sort(j);
		
		map.put(list.get(index), j);
		
		list.remove(lastIndex - 1);

		r.remove(r.size() - 1);

		if (r.isEmpty()) {
			map.remove(val);
		}

		else {
			map.put(val, r);
		}

		lastIndex--;
		return true;

	}
    
    private void swap(int id1, int id2) {
        int temp = list.get(id1);
        list.set(id1, list.get(id2));
        list.set(id2, temp);
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	 Random rand = new Random();
         int idx = rand.nextInt(lastIndex);
         return list.get(idx); 
    }
}
