package com.personal.algorithms.leetcode;

public class MyCalendar {

	int[] start_arr;
	int[] end_arr;
	int number_of_bookings;

	public MyCalendar() {

		this.start_arr = new int[1000];
		this.end_arr = new int[1000];
		this.number_of_bookings = 0;
	}

	public boolean book(int start, int end) {

		if (number_of_bookings == 1000) {
			return false;
		}

		if (number_of_bookings == 0) {
			start_arr[0] = start;
			end_arr[0] = end;
			number_of_bookings++;
			return true;
		}

		int i = 0;

		while (i < number_of_bookings) {

			int s1 = start_arr[i];
			int e1 = end_arr[i];

			if (Math.max(start, s1) <= Math.min(end, e1)){
				return false;
			}
			i++;
		}

		start_arr[number_of_bookings] = start;
		end_arr[number_of_bookings] = end;
		number_of_bookings++;
		return true;

	}
}