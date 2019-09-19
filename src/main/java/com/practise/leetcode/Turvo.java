package com.practise.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Turvo {

	public static void main(String[] args) {
		
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 
        
        int[] arr = new int[n];
        
		for (int i = 0; i < n; i++) {

			arr[i] = sc.nextInt();
		}
		

   		System.out.println(Arrays.toString(solve(arr, n, new int[] {1, 2, 3}, 3)));

	}
	
	
	public static int findBeauty(int[] arr, int p) {
		

		Integer distance = null;

		Integer begin_index = null;
		Integer end_index = null;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == p) {

				if (begin_index == null) {
					begin_index = i;
				}

				else if (end_index == null) {
					end_index = i;
				}

				if (begin_index != null && end_index != null) {

					if (distance == null || end_index - begin_index < distance) {
						distance = end_index - begin_index;
					}
					
					begin_index = i;
					end_index = null;
				}
			}
		}

		return distance == null ? -1 : distance;
	}
	
	
	public static class IndexStore {

		public Integer distance;

		public Integer begin_index;

		public Integer end_index;

		public IndexStore(Integer distance, Integer begin_index, Integer end_index) {
			super();
			this.distance = distance;
			this.begin_index = begin_index;
			this.end_index = end_index;
		}
		
		
		
		public IndexStore() {
			this.distance = null;
			this.begin_index = null;
			this.end_index = null;
		}
		
		

	}

	public static int[] solve(int[] arr, int N, int[] queries, int Q) {

		Map<Integer, IndexStore> map = new HashMap<>();

		for (int i = 0; i < Q; i++) {

			map.put(queries[i], new IndexStore());
		}

		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {

				IndexStore store = map.get(arr[i]);

				Integer distance = store.distance;
				Integer begin_index = store.begin_index;
				Integer end_index = store.end_index;

				if (begin_index == null) {
					begin_index = i;
				}

				else if (end_index == null) {
					end_index = i;
				}

				if (begin_index != null && end_index != null) {

					if (distance == null || end_index - begin_index < distance) {
						distance = end_index - begin_index;
					}

					begin_index = i;
					end_index = null;
				}

				map.put(arr[i], new IndexStore(distance, begin_index, end_index));
			}
		}

		int[] result = new int[Q];
		for (int i = 0; i < queries.length; i++) {

			Integer distance = map.get(queries[i]).distance;
			result[i] = distance == null ? -1 : distance;
		}

		return result;
	}


}
