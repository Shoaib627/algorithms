package com.practise.leetcode;

import com.algorithms.lists.ListNode;

public class MyLinkedList {

	ListNode head;

	int length;

	/** Initialize your data structure here. */
	public MyLinkedList() {

		this.length = 0;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		
		if(index < 0 || index >= length) {
			return -1;
		}

		int count = 0;

		ListNode cur = head;

		while (cur != null && count < index) {
			cur = cur.next;
			count++;
		}
		return cur != null ? cur.val : -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		ListNode new_node = new ListNode(val);

		if (head == null) {
			head = new_node;
		}
		
		else {
			new_node.next = head;
			head = new_node;
		}
		length++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {

		ListNode cur = head;
		ListNode prev = null;
		while (cur != null) {
			prev = cur;
			cur = cur.next;
		}

		prev.next = new ListNode(val);
		length++;

	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {

		if (index > length) {
			return;
		}

		ListNode cur = head;
		ListNode prev = head;

		ListNode new_node = new ListNode(val);
		length++;

		if (index == 0) {
			new_node.next = head;
			head = new_node;
			return;
		}

		int count = 0;

		while (cur != null && count < index) {
			prev = cur;
			cur = cur.next;
			count++;
		}

		prev.next = new_node;
		new_node.next = cur;

	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {

		if (index < 0 || index >= length) {
			return;
		}
		
		length--;

		if(index == 0) {
			head = head.next;
			return;
		}
		
		ListNode cur = head;
		ListNode prev = null;

		int count = 0;

		while (cur != null && count < index) {
			prev = cur;
			cur = cur.next;
			count++;
		}

		prev.next = cur.next;
	}
}