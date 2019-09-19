package com.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

class HitCounter {

    /** Initialize your data structure here. */
	
	private Map<Integer, Integer> map;
	
    public HitCounter() {
        this.map = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        
    	Integer val = map.getOrDefault(timestamp, 0);
    	
    	map.put(timestamp, val+1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
    	int start_index = timestamp;
    	int end_index = timestamp - 300 > 0 ? timestamp - 300: 1;
    	int hits = 0;
    	for(int i = start_index; i > end_index; i--) {
    		hits += map.getOrDefault(i, 0);
    	}
    	return hits;
    }
}
