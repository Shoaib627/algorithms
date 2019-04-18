package com.personal.algorithms.lists;

public class DeleteFromLinkedList {

	public static void main(String[] args) {

		ListNode node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 4 });

	/*	deleteAGivenKey(node, 2);

		PrintLinkedList.printIterative(node);

		PrintLinkedList.printIterative(deleteAGivenKey(node, 1));
		
		deleteEntireList(node);
		PrintLinkedList.printIterative(node);
		
		
		node = LinkedListGenerator.getList(new int[] { 1, 2, 3, 4 });
		
		PrintLinkedList.printIterative(node);*/

		node = deleteAtGivenPosition(node, 4);
		PrintLinkedList.printIterative(node);


		node = deleteEntireList(node);
		PrintLinkedList.printIterative(node);


	}

	public static ListNode deleteAGivenKey(ListNode node, int val) {

		ListNode current = node;
		ListNode previous = null;

		if (node == null) {
			return node;
		}

		if (current.val == val) {
			node = current.next;
			return node;
		}

		while (current != null && current.val != val) {

			previous = current;
			current = current.next;

		}

		if (current != null) {
			previous.next = current.next;
		}
		return node;

	}

	public static ListNode deleteAtGivenPosition(ListNode node, int position) {
		
		if (node == null) {
			return null;
		}

		ListNode current = node;
		ListNode previous = null;
		
		
		if(position == 0) {
			node = node.next;
			return node;
		}

		int current_position = 0;

		while (current != null && current_position < position) {

			previous = current;
			current = current.next;
			current_position++;

		}

		if (current != null) {
			previous.next = current.next;
		}
		return node;
	}

	public static ListNode deleteEntireList(ListNode node) {
		node = null;
		return node;
	}

}