package com.personal.algorithms.lists;

public class LinkedListUtil {

	public static Integer getLinkedListLength(ListNode headNode) {
		ListNode currentNode = headNode;
		Integer length = 0;

		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}

		return length;
	}
	
	public static ListNode getMiddleElement(ListNode headNode) {
		ListNode slowPtr = headNode;
		ListNode fastPtr = headNode;


		while (fastPtr != null && fastPtr.getNext()!=null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
		}

		return slowPtr;
	}
	
	public static void printLinkedList(ListNode headNode) {
		ListNode currentNode = headNode;

		System.out.print("HEAD -> ");

		while (currentNode != null) {
			System.out.print(currentNode.getVal() + " -> ");
			currentNode = currentNode.getNext();
		}
		System.out.print("NULL");

		System.out.println();

	}
	
	public static ListNode insertNodeAtBegining(ListNode headNode, Integer val) {

		if (headNode == null) {
			return new ListNode(val);
		}

		else {
			ListNode node = new ListNode(val);
			node.setNext(headNode);
			return node;
		}
	}
	
	
	public static ListNode insertNodeAtEnd(ListNode headNode, Integer val) {
		
		if (headNode == null) {
			return new ListNode(val);
		}

		
		ListNode currentNode = headNode;
		ListNode prevNode = null;


		while (currentNode != null) {
			prevNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
		prevNode.setNext(new ListNode(val));

		return headNode;
	}
	
	public static ListNode insertNodeAtMiddle(ListNode headNode, Integer val) {
		
		ListNode fastPtr = headNode;
		ListNode slowPtr = headNode;

		while (fastPtr != null && fastPtr.getNext()!=null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr =	slowPtr.getNext();
		}
		
		ListNode temp = slowPtr.getNext();
		ListNode node = new ListNode(val);
		slowPtr.setNext(node);
		node.setNext(temp);

		return headNode;
	}
	
	public static ListNode insertNodeAtAGivenPosition(ListNode headNode, Integer position, Integer val) {
		
		if(position == 0)
			return insertNodeAtBegining(headNode, val);
		
		if (headNode == null) {
			return new ListNode(val);
		}
		
		Integer size = getLinkedListLength(headNode);
		
		if(position > size + 1 || position < 1) {
			throw new RuntimeException("Invalid position");
		}
		
		ListNode currentNode = headNode;
		Integer length = 1;

		while (currentNode != null && length < position) {
			length++;
			currentNode = currentNode.getNext();
		}
		
		ListNode temp = currentNode.getNext();
		ListNode node = new ListNode(val);
		currentNode.setNext(node);
		node.setNext(temp);

		return headNode;
	}
	
	
	public static ListNode deleteNodeAtBegining(ListNode headNode) {
		return headNode == null ? null : headNode.next;
	}
	
	public static ListNode deleteNodeAtEnd(ListNode headNode) {
		
		ListNode currentNode = headNode;
		ListNode prevNode = null;

		
		while (currentNode.next != null ) {
			prevNode = currentNode;
			currentNode = currentNode.getNext();

		}
		
		prevNode.next = null;
		return headNode;
	}
	
	
	
	public static ListNode reverse(ListNode headNode) {

		ListNode currentNode = headNode;
		ListNode result = null;

		while (currentNode.next != null) {
			ListNode next = headNode.next;

			headNode.next = result;

			result = currentNode;
			currentNode = next;
		}
		return result;
	}
	
	public static boolean isListEvenLength(ListNode headNode) {
		ListNode fastPtr = headNode;
		ListNode slowPtr = headNode;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return fastPtr == null;
	}
	
	public static boolean isPalindrome(ListNode head) {

		ListNode fastPtr = head;
		ListNode slowPtr = head;
		ListNode prev_of_slow_ptr = head;

		while (fastPtr != null && fastPtr.next != null) {
			prev_of_slow_ptr = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		if (fastPtr != null) {
			slowPtr = slowPtr.next;
		}

		prev_of_slow_ptr.next = null;
		ListNode currentNode = slowPtr;
		ListNode result = null;

		while (currentNode != null) {
			ListNode next = currentNode.next;
			currentNode.next = result;
			result = currentNode;
			currentNode = next;
		}

		printLinkedList(result);
		printLinkedList(head);

		ListNode currentNode1 = head;
		ListNode currentNode2 = result;

		while (currentNode1 != null && currentNode2 != null) {

			if (currentNode1.val != currentNode2.val) {
				return false;
			}

			currentNode1 = currentNode1.next;
			currentNode2 = currentNode2.next;
		}

		return !(currentNode1 != null || currentNode2 != null);

	}
}
