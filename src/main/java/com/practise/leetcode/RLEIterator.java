package com.practise.leetcode;

public class RLEIterator {

	int current_count;
	
	int current_index;
	
	int[] A;


	public RLEIterator(int[] A) {
		this.A = A;
		int current_index = 1;
		this.current_count = A[current_index - 1];

	}

	public int next(int n) {

		
		System.out.println(current_count);
		System.out.println(current_index);

		while(n > 0) {
			
			if(current_count == 0) {
				current_index = current_index + 2;
				if(current_index > A.length ) {
					return -1;
				}
				current_count = A[current_index - 1];
			}
			
			if(n <= current_count) {
				current_count = current_count - n;
				return A[current_index];
			}
			else {
				
				n = n - current_count;
				current_count = 0;
			}
		}
		return -1;
	}
}
