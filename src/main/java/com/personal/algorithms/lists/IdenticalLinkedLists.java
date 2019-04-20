package com.personal.algorithms.lists;

public class IdenticalLinkedLists {

	public static void main(String[] args) {
	

		PrintLinkedList.printIterative(swapPairs(LinkedListGenerator.getList(new int[] { 1, 2, 3, 4, 5, 6 })));

	}
	
	
	public static boolean areListsIdentical(ListNode node1, ListNode node2) {
		
		if(node1 == null && node2 == null) {
			return true;
		}
		
		if(node1 == null || node2 == null) {
			return false;
		}
		
		ListNode cur1 = node1;
		ListNode cur2 = node2;
		
		while(cur1 != null && cur2 != null) {
			
			if(cur1.val != cur2.val) {
				return false;
			}

			cur1 = cur1.next;
			cur2 = cur2.next;

		}

		if(cur1 != null || cur2 != null) {
			return false;
		}
	
		return true;
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		int len1 = lengthIterative(headA);
		int len2 = lengthIterative(headB);

		System.out.println(len1);
		System.out.println(len2);

		int stepsToMove = Math.abs(len1 - len2);
		ListNode cur = null;
		ListNode curV2 = null;
		if (stepsToMove > 0) {

			cur = len1 > len2 ? headA : headB;
			curV2 = len1 < len2 ? headA : headB;
		}

		else {
			cur = headA;
			curV2 = headB;

		}

		while (cur != null && stepsToMove > 0) {
			stepsToMove--;
			cur = cur.next;
		}

		while (cur != null && curV2 != null) {
			if (cur == curV2) {
				return cur;
			}

			cur = cur.next;
			curV2 = curV2.next;
		}

		return null;
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
	
	public static ListNode deleteDuplicatesV2(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode current = head;
		ListNode previous = null;

		while (current != null && current.next != null) {

			if (current.val == current.next.val) {

				if (previous != null) {
					previous.next = current.next;
					current = current.next;

				} else {
					head = head.next;
					current = head;
				}
			} else {
				previous = current;
				current = current.next;
			}
		}
		return head;
	}
	
	public static ListNode deleteDuplicatesV3(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode current = head;
		ListNode previous = null;

		Integer lastDeleteVal = null;

		while (current != null && current.next != null) {

			if (current.val == current.next.val) {

				if (previous != null) {
					previous.next = current.next;
					current = current.next;

				} else {
					head = head.next;
					current = head;
				}
				lastDeleteVal = current.val;
			}

			else {
				if (lastDeleteVal != null && lastDeleteVal == current.val) {
					if (previous != null) {
						previous.next = current.next;
						current = current.next;

					} else {
						head = head.next;
						current = head;
					}
				} else {
					previous = current;
					current = current.next;
				}

			}
		}

		if (lastDeleteVal != null && lastDeleteVal == previous.val) {
			head = head.next;
		}

		return head;
	}
	
	

	
	public static ListNode swapPairs(ListNode head) {
		ListNode current = head;
		ListNode previous = null;
		
		while (current != null && current.next != null) {
			
			ListNode next = current.next.next;
			if (previous != null) {
				previous.next = current.next;
			}
			else {
				head = current.next;
			}
			current.next.next = current;
			current.next = next;
			
			previous = current;

			current = next;
		}
		return head;
	}
}