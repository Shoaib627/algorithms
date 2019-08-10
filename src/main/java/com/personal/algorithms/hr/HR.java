package com.personal.algorithms.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class HR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(dayOfProgrammer(1800));
		List<Integer> a = new ArrayList<Integer>();
		a.add(4);
		a.add(6);
		a.add(5);
		a.add(3);
		a.add(3);
		a.add(1);

		
		pickingNumbers(a);
	}

	
	
	static long aVeryBigSum(long[] ar) {

		long sum = 0;
		
		for(int i = 0; i < ar.length; i++) {
			sum += ar[i];
		}
		
		return sum;
	}
	
	

	
	static int findMedian(int[] arr) {

		Arrays.sort(arr);

		return arr[(int) Math.ceil(arr.length / 2)];

	}

	static String[] bigSorting(String[] unsorted) {

		Arrays.sort(unsorted, new BigSorter());

		return unsorted;

	}

	static class BigSorter implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {

			if (o1.length() != o2.length()) {
				return o1.length() - o2.length();
			}

			for (int i = 0; i < o1.length(); i++) {
				if ((int)o1.charAt(i) < (int)o2.charAt(i))
					return -1;
				if ((int)o1.charAt(i) > (int)o1.charAt(i))
					return 1;
			}

			return 0;

		}
	}

	static String dayOfProgrammer(int year) {
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) ? "13.09." + year : "12.09." + year;
	}

	public static int pickingNumbers(List<Integer> a) {

		Collections.sort(a);

		int max = 0;

		for (int i = 0; i < a.size(); i++) {
			
			
		}

		return max;
	}

	static void bonAppetit(List<Integer> bill, int k, int b) {

		int sum = 0;

		for (int i = 0; i < bill.size(); i++) {

			sum += bill.get(i);
		}

		int actual = sum - bill.get(k);

		if (actual / 2 == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(b - actual/2);

		}
	}
	
	
	static int migratoryBirds(List<Integer> arr) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			Integer c = map.getOrDefault(arr.get(i), 0);
			map.put(arr.get(i), c + 1);
		}

		int max_so_far = Integer.MIN_VALUE;
		int key = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() > max_so_far || (entry.getValue() == max_so_far && entry.getKey() < key)) {
				key = entry.getKey();
				max_so_far = entry.getValue();
			}

		}
		return key;
	}
	
	
	static int[] closestNumbers(int[] arr) {

		Arrays.sort(arr);
		List<Integer> a = new ArrayList<Integer>();

		int min_diff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {

			if (Math.abs(arr[i] - arr[i + 1]) <= min_diff) {
				
				
				if (Math.abs(arr[i] - arr[i + 1]) < min_diff) {
					a.clear();
				}

				a.add(arr[i]);
				a.add(arr[i+1]);
				
				min_diff = Math.abs(arr[i] - arr[i + 1]);

			}
		}
		int[] b1 = new int[a.size()];

		for (int i = 0; i < a.size(); i++) {
			b1[i] = a.get(i);
		}
		return b1;
	}
	
	
	static int[] missingNumbers(int[] arr, int[] brr) {

		List<Integer> a = new ArrayList<Integer>();

		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			Integer c = map.getOrDefault(arr[i], 0);
			map.put(arr[i], c + 1);
		}

		Map<Integer, Integer> map2 = new TreeMap<>();
		for (int i = 0; i < brr.length; i++) {
			Integer c = map2.getOrDefault(brr[i], 0);
			map2.put(brr[i], c + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
			if (entry.getValue() != map.getOrDefault(entry.getKey(),0)) {
				a.add(entry.getKey());
			}
		}

		int[] b1 = new int[a.size()];

		for (int i = 0; i < a.size(); i++) {
			b1[i] = a.get(i);
		}
		
		return b1;

	}

}