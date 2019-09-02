package com.personal.algorithms.leetcode;

import java.util.Stack;

public class StockSpanner {

	
	public Stack<Integer> stack1;
	
	public Stack<Integer> stack2;

	
    public StockSpanner() {
    	stack1 = new Stack<>();
    	stack2 = new Stack<>();
    }
    
	public int next(int price) {

		int count = 1;

		stack2.push(price);

		while (!stack1.isEmpty() && stack1.peek() >= price) {
			stack2.push(stack1.pop());
			count++;
		}

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());

		}

		return count;
	}
}
