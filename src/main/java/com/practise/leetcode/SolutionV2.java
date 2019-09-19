package com.practise.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SolutionV2 {

	Map<Integer, List<Integer>> map;
	
    Random random;


    public SolutionV2(int[] w) {
        this.random = new Random();

        this.map = new HashMap<>();
        
    	for (int i = 0; i < w.length; i++) {

    		List<Integer> list = map.getOrDefault(w[i], new ArrayList<>());
    		list.add(i);
    		map.put(w[i], list);
		}
    	
    	System.out.println(map);
    }
    
	public int pick(int target) {
		List<Integer> list = map.get(target);
		return list.get(random.nextInt(list.size()));
	}
}
