package com.practise.leetcode;

import java.util.Collections;
import java.util.LinkedList;

public class Test123 {

	public static void main(String[] args) {
	
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(0);
		list.add(0);
		list.add(2);
		
		int i = Collections.binarySearch(list, 1);
		
		int j = 0;
		
		if(i >=0 ) {
			j = i;
		}
		else {
			j = Math.abs(Math.abs(i) - 1);
			if(j == list.size()) {
				j = j -1;
			}
		}
		
		System.out.println(j);

	}

}
