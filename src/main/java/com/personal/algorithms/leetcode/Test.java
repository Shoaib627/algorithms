package com.personal.algorithms.leetcode;

import static com.personal.algorithms.lists.LinkedListUtil.printLinkedList;

import com.personal.algorithms.lists.LinkedListUtil;

public class Test {

	public static void main(String[] args) {

		/*ListNode ll = new ListNode(1);

		printLinkedList(ll);

		ll = insertNodeAtBegining(ll, 0);

		printLinkedList(ll);

		ll = insertNodeAtEnd(ll, 2);

		printLinkedList(ll);

		ll = insertNodeAtEnd(ll, 5);

		printLinkedList(ll);
		
		ll = insertNodeAtMiddle(ll, 3);

		printLinkedList(ll);
		
		ll = insertNodeAtAGivenPosition(ll, 4, 4);
		
		printLinkedList(ll);
		
		ll = insertNodeAtEnd(ll, 6);

		printLinkedList(ll);
		
		ll = deleteNodeAtBegining(ll);
		ll = deleteNodeAtEnd(ll);

		printLinkedList(ll);*/
		
		ListNode ll = new ListNode(1);
	
		
		//System.out.println(isListEvenLength(ll));
		//printLinkedList(ll);
		
		System.out.println(LinkedListUtil.isPalindrome(ll));
		
		//printLinkedList(ll);

	}
	
	public static ListNode middleNode(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}

		return slowPtr;

	}
	
	
    public boolean hasCycle(ListNode head) {
        
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(slowPtr.equals(fastPtr)) {
				return true;
			}
		}
		
		return false;

    }
    
    
	public ListNode detectCycle(ListNode head) {

		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if (slowPtr.equals(fastPtr)) {
				return slowPtr;
			}
		}

		return null;
	}
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode currentNode = head;
		ListNode previousNode = null;

		while (currentNode != null) {

			if (currentNode.val == val) {
				if (previousNode != null) {
					previousNode.next = currentNode.next;
					head = head.next;
				}
			} else {
				previousNode = currentNode;
			}
			currentNode = currentNode.next;
		}
		return head;
	}
	
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode currentNode = head;
		ListNode previousNode = null;

		while (currentNode != null) {

			if (previousNode != null && previousNode.val == currentNode.val) {
				previousNode.next = currentNode.next;

			} else {
				previousNode = currentNode;
			}

			currentNode = currentNode.next;
		}

		return head;
	}
	
	public static  ListNode insertNodeAtEnd(ListNode headNode, Integer val) {
		
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

	public static ListNode oddEvenList(ListNode head) {
		

		return head;
	}

	public  ListNode getMiddleElement(ListNode headNode) {
		ListNode slowPtr = headNode;
		ListNode fastPtr = headNode;


		while (fastPtr != null && fastPtr.getNext()!=null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
		}

		return slowPtr;
	}

	public static ListNode reverse(ListNode head) {

		ListNode currentNode = head;
		ListNode result = null;

		while (currentNode != null) {
			ListNode next = currentNode.next;

			currentNode.next = result;

			result = currentNode;
			currentNode = next;
		}
		return result;
	}
	
	


	public ListNode getMiddleElementV2(ListNode headNode) {

		ListNode slowPtr = headNode;
		ListNode fastPtr = headNode;

		while (slowPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}
	
	public static boolean areListsSame(ListNode list1, ListNode list2) {
		printLinkedList(list1);
		printLinkedList(list2);

		ListNode currentNode1 = list1;
		ListNode currentNode2 = list2;

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
