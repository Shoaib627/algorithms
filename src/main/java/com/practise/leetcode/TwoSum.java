package com.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    /** Initialize your data structure here. */
	
	
	Map<Integer, Integer> map ;
	
    public TwoSum() {
        this.map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
    	Integer count = map.get(number);
        map.put(number, count == null ? 1: count + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			int i = entry.getKey();
			int j = value - i;
			if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) {
				return true;
			}

		}
		return false;
	}
}