package com.algorithms.lists;

public class InsertIntoLinkedList {

	public static void main(String[] args) {
		ListNode node = LinkedListGenerator.getList();

		PrintLinkedList.printIterative(insertAtBegining(null, 0));

		PrintLinkedList.printIterative(insertAtEnd(node, 9));

		PrintLinkedList.printIterative(insertAfterGivenNode(node, 6, 7));

		PrintLinkedList.printIterative(insertAfterGivenNode(node, 7, 8));

	}

	public static ListNode insertAtBegining(ListNode node, int val) {

		ListNode new_node = new ListNode(val);
		new_node.next = node;
		return new_node;
	}

	public static ListNode insertAtEnd(ListNode node, int val) {

		ListNode new_node = new ListNode(val);

		if (node == null) {
			return new_node;
		}

		ListNode current = node;
		ListNode prev = null;
		while (current != null) {
			prev = current;
			current = current.next;
		}

		prev.next = new_node;

		return node;
	}

	public static ListNode insertAfterGivenNode(ListNode node, int given_val, int val) {

		ListNode new_node = new ListNode(val);

		if (node == null) {
			return new_node;
		}

		ListNode current = node;

		while (current != null && current.val != given_val) {
			current = current.next;
		}
		ListNode temp = current.next;
		current.next = new_node;
		new_node.next = temp;

		return node;
	}
}