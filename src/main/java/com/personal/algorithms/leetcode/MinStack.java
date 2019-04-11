package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class MinStack {

	/** initialize your data structure here. */

	Stack<Integer> stack;
	Stack<Integer> min_stack;

	public MinStack() {
		stack = new Stack<>();
		min_stack = new Stack<>();
	}

	public void push(int x) {

		stack.push(x);
		if (min_stack.isEmpty() || x < min_stack.peek()) {
			min_stack.push(x);
		} else {
			min_stack.push(min_stack.peek());
		}
	}

	public void pop() {

		try {
			stack.pop();
			min_stack.pop();
		} catch (EmptyStackException e) {
		}
	}

	public int top() {
		return stack.peek();

	}

	public int getMin() {
		return min_stack.peek();

	}
	
	
	public class Codec {
		List<String> urls = new ArrayList<>();

		public String encode(String longUrl) {
			urls.add(longUrl);
			return String.valueOf(urls.size() -1);
	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {
	    	int u = Integer.parseInt(shortUrl);
	        return  u < urls.size() ? urls.get(u): "";
	    }
	}
	
	
	class MyHashMap {

	    /** Initialize your data structure here. */
		
		
		int[] arr;
		
		public MyHashMap() {
			
			this.arr = new int[1000001];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = -1;
			}
		}
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	    	arr[key] = value;
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	    	return arr[key];
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	    	arr[key] = -1;
	    }
	}
	
	public char findTheDifference(String s, String t) {

		char c = 0;
		for (int i = 0; i < s.length(); i++) {
			c = (char) (c ^ s.charAt(i));
		}

		for (int i = 0; i < t.length(); i++) {
			c = (char) (c ^ s.charAt(i));
		}

		return c;

	}
}