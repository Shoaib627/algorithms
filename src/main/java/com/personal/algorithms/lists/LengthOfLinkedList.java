package com.personal.algorithms.lists;

public class LengthOfLinkedList {

	public static void main(String[] args) {

		ListNode node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 4 });

		System.out.println(lengthIterative(node));
		System.out.println(lengthRecursive(node));

		node = LinkedListGenerator.getList(new int[] { 1 });

		System.out.println(lengthIterative(node));
		System.out.println(lengthRecursive(node));

		node = LinkedListGenerator.getList(new int[] {});

		System.out.println(lengthIterative(node));
		System.out.println(lengthRecursive(node));

	}

	public static int lengthIterative(ListNode node) {

		if (node == null) {
			return 0;
		}

		int length = 0;
		ListNode current = node;

		while (current != null) {
			length++;
			current = current.next;
		}

		return length;
	}

	public static int lengthRecursive(ListNode node) {

		if (node == null) {
			return 0;
		}
		return 1 + lengthRecursive(node.next);
	}

}
