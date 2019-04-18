package com.personal.algorithms.lists;

public class MiddleElementOfALinkedList {

	public static void main(String[] args) {

		ListNode node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 4, 5, 6 });

		System.out.println(getMiddleElementOfLinkedList(node));

		node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 4, 5 });

		System.out.println(getMiddleElementOfLinkedList(node));

		node = LinkedListGenerator.getList(new int[] { 1 });

		System.out.println(getMiddleElementOfLinkedList(node));
	}

	public static int getMiddleElementOfLinkedList(ListNode node) {

		if (node == null) {
			return -1;
		}

		ListNode slowPtr = node;
		ListNode fastPtr = node;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		return slowPtr.val;

	}
}