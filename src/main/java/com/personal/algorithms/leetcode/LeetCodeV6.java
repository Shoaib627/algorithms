package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.personal.algorithms.lists.LinkedListGenerator;
import com.personal.algorithms.lists.ListNode;
import com.personal.algorithms.lists.PrintLinkedList;

public class LeetCodeV6 {

	public static void main(String[] args) {
		ListNode node2 = LinkedListGenerator.getList(new int[] { 1, 4, 3, 2, 5, 2 });
		PrintLinkedList.printIterative(partition(node2, 3));
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		
		if(preorder == null|| preorder.length == 0) {
			return null;
		}

		return bstFromPreorder(preorder, 0, preorder.length - 1);
	}

	public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
		
		if(start > end ) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[start]);
		
		if(start == end) {
			return root;
		}
		
		int index = start;
		
		for (int i = start; i <= end; i++) {
			if (preorder[start] < preorder[i]) {
				break;
			}
			index = i;
		}
		
		root.left = bstFromPreorder(preorder, start + 1, index);
		root.right = bstFromPreorder(preorder, index + 1, end);
		
		return root;

	}
	
    public static boolean verifyPreorder(int[] preorder) {
        
    	if(preorder == null|| preorder.length == 0) {
			return true;
		}

		return verifyPreorder(preorder, 0, preorder.length - 1);
    }


	private static boolean verifyPreorder(int[] preorder, int start, int end) {

		if (start < end) {

			int i = start + 1;
			for (i = start + 1; i <= end; i++) {
				if (preorder[start] < preorder[i]) {
					break;
				}

			}

			for (int j = i; j <= end; j++) {
				if (preorder[start] > preorder[j]) {
					return false;
				}

			}

			return verifyPreorder(preorder, start + 1, i - 1) && verifyPreorder(preorder, i, end);

		}

		return true;
	}
	

	 
	  public static boolean verifyPreorderV2(int[] preorder) {
	        return helper(preorder,0,preorder.length-1);
	    }
	    
	    public static boolean helper(int arr[],int start,int end){
	        if(start>end)
	            return true;
	        
	        int root = arr[start];
	        int i = start+1;
	        for(i=start+1;i<=end;i++){
	            if(root<arr[i])
	                break;
	        }
	        for(int j=i;j<=end;j++)
	            if(root>arr[j])
	                return false;
	        
	        return helper(arr,start+1,i-1) && helper(arr,i,end);
	        
	    }
	    
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

			if (l1 == null && l2 == null) {
				return null;
			}

			ListNode l1ptr = l1;
			ListNode l2ptr = l2;
			ListNode head = new ListNode(0);

			ListNode cur = head;
			while (l1ptr != null && l2ptr != null) {

				if (l1ptr.val > l2ptr.val) {
					cur.next = l2ptr;
					l2ptr = l2ptr.next;
				}

				else {
					cur.next = l1ptr;
					l1ptr = l1ptr.next;
				}

				cur = cur.next;
			}

			if (l1ptr != null) {
				cur.next = l1ptr;

			}

			if (l2ptr != null) {
				cur.next = l2ptr;
			}

			return head.next;
		}
		
		
	
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> q = new PriorityQueue<>(new mergeComparator());
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				q.add(lists[i]);
			}
		}

		ListNode head = new ListNode(0);
		ListNode cur = head;

		while (!q.isEmpty()) {
			ListNode entry = q.poll();
			cur.next = entry;
			if (entry.next != null) {
				q.add(entry.next);
			}
			cur = cur.next;
		}
		return head.next;
	}

	public class mergeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return Integer.compare(o1.val, o2.val);
		}
	}
	
	
	public static ListNode oddEvenList(ListNode head) {
		
		if(head == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode even_current = dummy;
		ListNode current = head;
		ListNode prev = null;
		int count = 1;
		while (current != null) {

			if (count % 2 == 0) {
				prev.next = current.next;
				current.next = null;
				even_current.next = current;
				even_current = even_current.next;
				current = prev.next;
			}

			else {
				prev = current;
				current = current.next;
			}

			count++;

		}

		prev.next = dummy.next;
		return head;
	}
	
	// [9,9,9,9,9,9,9,9,8]
	public ListNode plusOne(ListNode head) {

		ListNode rev = reverseList(head);
		ListNode currentNode = rev;
		ListNode previousNode = null;

		int carry_over = 1;
		while (currentNode != null) {

			int sum = currentNode.val + carry_over;

			if (sum <= 9) {
				currentNode.val = sum;
				carry_over = 0;
				break;
			}

			else {
				currentNode.val = sum % 10;
				carry_over = 1;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		if (carry_over == 1) {
			previousNode.next = new ListNode(1);
		}
		return reverseList(rev);
	}

	public static ListNode reverseList(ListNode head) {

		ListNode currentNode = head;
		ListNode previous = null;

		while (currentNode != null) {

			ListNode next = currentNode.next;

			currentNode.next = previous;

			previous = currentNode;

			currentNode = next;
		}

		return previous;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 != null && l2 == null) {
			return l1;
		}

		if (l1 == null && l2 != null) {
			return l2;
		}

		ListNode rl1 = reverseList(l1);
		ListNode rl2 = reverseList(l2);

		int carry_over = 0;

		ListNode cur1 = rl1;
		ListNode cur2 = rl2;

		ListNode res = new ListNode(0);

		ListNode dummy = res;

		while (cur1 != null || cur2 != null) {

			int sum = (cur1 != null ? cur1.val : 0) + (cur2 != null ? cur2.val : 0) + carry_over;

			if (sum <= 9) {
				carry_over = 0;
				dummy.next = new ListNode(sum);
			}

			else {
				carry_over = 1;
				dummy.next = new ListNode(sum % 10);
			}

			dummy = dummy.next;

			if (cur1 != null)
				cur1 = cur1.next;

			if (cur2 != null)
				cur2 = cur2.next;

		}

		if (carry_over == 1) {

			dummy.next = new ListNode(1);
		}

		return reverseList(res.next);
	}
	
	// 1, 4, 3, 2, 5, 2
	public static ListNode partition(ListNode head, int x) {
		
		if (head == null) {
			return null;
		}

		ListNode current = head;
		ListNode previous = null;
		
		ListNode dummy = new ListNode(0);
		ListNode dummyPtr = dummy;

		while (current != null) {

			if (current.val >= x) {

		
				dummyPtr.next = current;

				if (previous != null) {
					previous.next = current.next;
					current = current.next;
				}

				else {
					head = current.next;
					current = head;
				}
				
				dummyPtr = dummyPtr.next;
				dummyPtr.next = null;
			}

			else {
				previous = current;
				current = current.next;
			}
		}
		
		if (previous != null)
			previous.next = dummy.next;
		
		return head;
		
	}
	
	Map<Character, Integer> map = new HashMap<>();
	private Map<Character, Integer> fmap;

	public String customSortStringV2(String S, String T) {

		for (int i = 0; i < S.length(); i++) {

			map.put(S.charAt(i), i);
		}

		Character[] ch = new Character[T.length()];
		for (int i = 0; i < T.length(); i++) {
			ch[i] = T.charAt(i);
		}

		Arrays.sort(ch, new strComparator());
		
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < ch.length; i++) {
			b.append(ch[i]);
		}

		return b.toString();

	}

	
	public String customSortString(String S, String T) {

		for (int i = 0; i < S.length(); i++) {

			map.put(S.charAt(i), i);
		}
		
		Map<Character, Integer> fmap = new HashMap<>();


	
		for (int i = 0; i < T.length(); i++) {
			Integer count = fmap.getOrDefault(T.charAt(i), 0);
			fmap.put(T.charAt(i), count + 1);
		}

	
		StringBuffer b = new StringBuffer();
		
		for (int k = 0; k < S.length(); k++) {
			
			int i  = fmap.getOrDefault(S.charAt(k), 0);
			
			for (int j = 1; j <= i; j++) {
				b.append(S.charAt(k));
			}
		}
		
		for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {

			if (!map.containsKey(entry.getKey())) {

				int i = fmap.getOrDefault(entry.getKey(), 0);

				for (int j = 1; j <= i; j++) {
					b.append(entry.getKey());
				}
			}
		}


		return b.toString();

	}
	
	
	public class strComparator implements Comparator<Character> {

		@Override
		public int compare(Character o1, Character o2) {
			return Integer.compare(map.getOrDefault(o1, 0), map.getOrDefault(o2, 0));
		}
	}
	
	
	
	
	public List<String> wordSubsets(String[] A, String[] B) {

		Map<Character, Integer> Bmap = getFrequencyMapV2(B);

		List<String> result = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
			Map<Character, Integer> word_map = getFrequencyMap(A[i]);

			if (isMapSubSet(Bmap, word_map))
				result.add(A[i]);
		}

		return result;
	}

	public boolean isMapSubSet(Map<Character, Integer> Bmap, Map<Character, Integer> word_map) {
		for (Map.Entry<Character, Integer> entry : Bmap.entrySet()) {
			if (word_map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
				return false;
			}
		}
		return true;
	}
	
	
	public Map<Character, Integer> getFrequencyMapV2(String[] B) {
		Map<Character, Integer> Bmap  = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			
			Map<Character, Integer> word_map = getFrequencyMap(B[i]);
			
			for (Map.Entry<Character, Integer> entry : word_map.entrySet()) { 
				Integer cur_count = Bmap.getOrDefault(entry.getKey(), 0);		
				if(entry.getValue() > cur_count) {
					Bmap.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return Bmap;
	}


	public Map<Character, Integer> getFrequencyMap(String T) {
		Map<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			Integer count = fmap.getOrDefault(T.charAt(i), 0);
			fmap.put(T.charAt(i), count + 1);
		}
		return fmap;
	}
	
	
	public  String reverseWordsV2(String s) {
		String[] test = s.trim().split(" ");
		StringBuffer result = new StringBuffer();
		for (int i = test.length - 1; i >= 0; i--) {

			s = test[i].trim();

			if (s.length() > 0) {
				result.append(s);
				result.append(" ");
			}
		}
		return result.toString().trim();
	}
	
	
	public void reverseWords(char[] str) {

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < str.length; i++) {

			result.append(str[i]);
		}

		String lol = reverseWordsV2(result.toString());

		System.out.println(lol);

		str = lol.toCharArray();

		System.out.println(Arrays.toString(str));
		
		

	}

}