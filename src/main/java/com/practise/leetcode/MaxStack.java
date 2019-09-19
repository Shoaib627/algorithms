package com.practise.leetcode;

import java.util.Stack;

class MaxStack {

	Stack<Integer> a;

	Stack<Integer> max;

	Stack<Integer> temp;

	public MaxStack() {

		this.a = new Stack<>();
		this.max = new Stack<>();
		this.temp = new Stack<>();
	}

	public void push(int x) {

		a.push(x);


		if (max.isEmpty() || max.peek() <= x) {
			max.push(x);
		} else {
			max.push(max.peek());
		}
	}

	public int pop() {
		this.max.pop();
		return a.pop();
	}

	public int top() {
		return a.peek();
	}

	public int peekMax() {
		return max.peek();
	}

	public int popMax() {
		int max = this.max.peek();

		while (!a.isEmpty() && a.peek() < max) {
			this.max.pop();
			temp.push(a.pop());
		}

		a.pop();
		this.max.pop();

		while (!temp.isEmpty()) {
			push(temp.pop());
		}

		return max;
	}
}