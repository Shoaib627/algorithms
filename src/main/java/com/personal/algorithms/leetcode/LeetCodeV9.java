package com.personal.algorithms.leetcode;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import com.personal.algorithms.lists.ListNode;

public class LeetCodeV9 {



	public static boolean isPalindrome(ListNode head) {

		if (head == null) {
			return true;
		}

		ListNode slowPtr = head;
		ListNode fasrPtr = head;

		while (slowPtr.next != null && fasrPtr.next != null && fasrPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fasrPtr = fasrPtr.next.next;
		}

		ListNode rev;

		if (fasrPtr.next == null) {
			rev = slowPtr.next;
		} else {
			rev = slowPtr;
		}

		ListNode list = reverse(rev);

		ListNode current = head;
		ListNode s_current = list;

		while (s_current != null && current != null) {

			if (current.val != s_current.val) {
				return false;
			}
			current = current.next;
			s_current = s_current.next;
		}
		return true;
	}
	
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null || m == n) {
			return head;
		}
		
		int i = 1;
		ListNode current = head;
		ListNode prev = null;
		while(i < m) {
			prev = current;
			current = current.next;
			i++;
		}
		
		
		i = 1;
		ListNode result = null;

		while (current != null && i < n) {

			ListNode temp = current.next;
			current.next = result;
			result = current;
			current = temp;
			i++;
		}

		prev.next = result;
				
		return head;
	}
	
	
	public static ListNode reverse(ListNode head, int k) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode current = head;
		ListNode result = null;

		int i = 1;
		while (current != null && k <= i) {

			ListNode temp = current.next;
			current.next = result;
			result = current;
			current = temp;
		}
		return result;
	}

	public static ListNode reverse(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode current = head;
		ListNode result = null;

		while (current != null) {

			ListNode temp = current.next;
			current.next = result;
			result = current;
			current = temp;
		}
		return result;
	}

	public static void reorderList(ListNode head) {

		if (head == null) {
			return;
		}

		ListNode slowPtr = head;
		ListNode fasrPtr = head;

		while (slowPtr.next != null && fasrPtr.next != null && fasrPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fasrPtr = fasrPtr.next.next;
		}

		ListNode rev;

		if (fasrPtr.next == null) {
			rev = slowPtr.next;
			slowPtr.next = null;
		} else {
			rev = slowPtr;
			slowPtr = null;
		}

		ListNode list = reverse(rev);

		ListNode current = head;
		ListNode s_current = list;

		while (s_current != null && current != null) {

			ListNode temp = current.next;
			ListNode temp2 = s_current.next;

			current.next = s_current;
			s_current.next = temp;

			s_current = temp2;
			current = temp;
		}
	}

	public static int largestValsFromLabelsV2(int[] values, int[] labels, int num_wanted, int use_limit) {

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < labels.length; i++) {
			map.merge(labels[i], new ArrayList<>(Arrays.asList(values[i])), (old, current) -> {
				old.addAll(current);
				return old;
			});
		}

		System.out.println(map);

		return use_limit;
	}

	public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		for (int i = 0; i < labels.length; i++) {

			if(map.containsKey(labels[i])) {
				PriorityQueue<Integer> list = map.get(labels[i]);	
				list.add(values[i]);
				map.put(labels[i], list);
				
			}
			
			else {
				PriorityQueue<Integer> q =  new PriorityQueue<>(Collections.reverseOrder());
				q.add(values[i]);
				map.put(labels[i], q);

			}
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
			int index = 0;
			while (index < use_limit && !entry.getValue().isEmpty()) {
				queue.add(entry.getValue().poll());
				index++;
			}
		}

		int sum = 0;
		int index = 0;

		while (index < num_wanted && !queue.isEmpty()) {
			sum += queue.poll();
			index++;
		}
		return sum;
	}

	public int twoCitySchedCost(int[][] costs) {
		int minimum_cost = 0;

		int city_a = 0;
		int city_b = 0;

		for (int[] cost : costs) {
			if (city_a >= costs.length / 2) {
				minimum_cost += cost[1];
			} else if (city_b >= costs.length / 2) {
				minimum_cost += cost[0];
			} else {
				minimum_cost += Math.min(cost[0], cost[1]);
				if (cost[0] > cost[1]) {
					city_b++;
				} else {
					city_a++;
				}
			}
		}
		return minimum_cost;
	}
	
	public boolean hasGroupsSizeX(int[] deck) {

		int[] count = new int[10000];

		for (int card : deck) {
			count[card]++;
		}

		return findGCD(count, count.length) >= 2;
	}

	int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	int findGCD(int arr[], int n) {
		int result = arr[0];
		for (int i = 1; i < n; i++)
			result = gcd(arr[i], result);

		return result;
	}

	public String dayOfTheWeek(int day, int month, int year) {
		String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		int weekOfDay = Year.of(year).atMonth(Month.of(month)).atDay(day).getDayOfWeek().getValue() - 1;
		return weeks[weekOfDay];
	}
	



	public static int[][] intervalIntersection(int[][] A, int[][] B) {

		int i = 0;
		int j = 0;

		List<int[]> list = new ArrayList<>();

		while (i < A.length && j < B.length) {

			int[] a = A[i];

			int[] b = B[i];

			if (a[1] < b[0]) {
				i++;
			}

			else if (b[1] < a[0]) {
				j++;
			}

			else {

				int[] it = new int[2];

				it[0] = Math.max(a[0], b[0]);
				it[1] = Math.min(a[1], b[1]);

				if (a[1] < b[1]) {
					i++;
				}

				else {
					j++;
				}

				list.add(it);
			}

		}

		int[][] r = new int[list.size()][2];

		int index = 0;

		for (int[] it : list) {
			r[index++] = it;
		}

		return r;
	}
	
	
	
	public int minMoves(int[] nums) {

		int min = nums[0];
		int moves = 0;
		for (int i = 1; i < nums.length; i++) {
			if (min > nums[i]) {
				min = nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			moves += nums[i] - min;
		}
		return moves;
	}
	
	
	public static void main(String[] args) {

		System.out.println(Character.getNumericValue('2'));
		calculate("3+2*2+4*2");
	}

	
	public static int calculate(String s) {

		Stack<Character> stackA = new Stack<>();
		
		Stack<Character> stackB = new Stack<>();

		for (Character c : s.toCharArray()) {
			stackA.push(c);
		}

		return 0;
	}
	
	public double largestTriangleArea(int[][] p) {
		double res = 0;
		for (int[] i : p)
			for (int[] j : p)
				for (int[] k : p)
					res = Math.max(res, 0.5 * Math
							.abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - j[0] * i[1] - k[0] * j[1] - i[0] * k[1]));
		return res;
	}
	
	

	
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

		if (rec1[0] > rec2[0] && rec1[1] > rec2[1] && rec2[2] > rec1[0] && rec2[3] > rec1[1]) {
			return true;
		}

		else if (rec2[0] > rec1[0] && rec2[1] > rec1[1] && rec1[2] > rec2[0] && rec1[3] > rec2[1]) {
			return true;

		}
		return false;

	}
}