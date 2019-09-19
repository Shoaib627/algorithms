package com.practise.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    /** Initialize your data structure here. */
	
	Queue<Integer> queue_1 = new LinkedList<>();
	Queue<Integer> queue_2 = new LinkedList<>();

	
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue_1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	
    	while(queue_1.size() > 1) {
    		queue_2.add(queue_1.poll());
    	}
        int r = queue_1.poll();
        
         queue_1 = queue_2;
         queue_2 = new LinkedList<>();
        
        return r;
    }
    
    /** Get the top element. */
    public int top() {
        
    	while(queue_1.size() > 1) {
    		queue_2.add(queue_1.poll());
    	}
        int r = queue_1.peek();
        queue_2.add(r);
        
        queue_1 = queue_2;
        queue_2 = new LinkedList<>();
        
        return r;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
       return  queue_1.isEmpty();
        
    }
}