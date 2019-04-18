package com.personal.algorithms.lists;

public class DeleteLastOccurenceFromLinkedList {

	public static void main(String[] args) {

		ListNode node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 6, 4, 5, 6 });

		PrintLinkedList.printIterative(deleteLastOccurrence(node, 6));

		node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 6, 4, 5, 6, 6 });

		PrintLinkedList.printIterative(deleteLastOccurrence(node, 6));
		
		
		node = LinkedListGenerator.getList(new int[] { 1 });

		PrintLinkedList.printIterative(deleteLastOccurrence(node, 6));
		
		node = LinkedListGenerator.getList(new int[] { 1 });

		PrintLinkedList.printIterative(deleteLastOccurrence(node, 1));

	}
	
	
	public static ListNode deleteLastOccurrence(ListNode node, int val) {

		if (node == null) {
			return null;
		}

		ListNode current = node;

		ListNode last_occurence = null;
		ListNode previous_last_occurence = null;

		ListNode previous = null;

		while (current != null) {

			if (current.val == val) {
				last_occurence = current;
				previous_last_occurence = previous;
			}
			previous = current;
			current = current.next;
		}

		if (last_occurence != null) {

			if (previous_last_occurence == null) {
				node = node.next;
			}

			else {
				previous_last_occurence.next = last_occurence.next;

			}

		}
		return node;
	}
}