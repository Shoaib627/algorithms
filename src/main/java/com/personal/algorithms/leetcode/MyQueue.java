package com.personal.algorithms.leetcode;

import java.util.Stack;

class MyQueue {

	/** Initialize your data structure here. */

	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public MyQueue() {

		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {

		stack1.push(x);

	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}

		int a = stack2.pop();

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}

		return a;
	}

	/** Get the front element. */
	public int peek() {

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}

		int a = stack2.peek();

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}

		return a;

	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty();
	}
}