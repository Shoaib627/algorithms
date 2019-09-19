package com.algorithms.lists;

public class LinkedListGenerator {

	public static ListNode getList() {

		ListNode node = new ListNode(1);

		node.next = new ListNode(2);

		node.next.next = new ListNode(3);

		node.next.next.next = new ListNode(4);

		node.next.next.next.next = new ListNode(5);

		node.next.next.next.next.next = new ListNode(6);

		return node;
	}
	
	
	public static ListNode getList(int A[]) {

		if (A == null || A.length == 0) {
			return null;
		}

		ListNode node = new ListNode(A[0]);
		ListNode current = node;
		for (int i = 1; i < A.length; i++) {
			current.next = new ListNode(A[i]);
			current = current.next;
		}

		return node;
	}
	
}
