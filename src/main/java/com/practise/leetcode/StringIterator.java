package com.practise.leetcode;

// ["StringIterator","next","next","next","next","hasNext","next","next","next","next","next","hasNext","next","next","hasNext","next","next","hasNext","hasNext","next","next","next","next","next","next","next","next","next","next","next","next","hasNext","next","hasNext","hasNext","next","next","next","next","next","hasNext","hasNext","next","next","next","next","next"]

// [["G4X10v8G17x15A12c12d6F1A13K3z17U11Z17Z1F5J14L16o18o13M18h20n6R20Y8B5Q3f16C5y2b13W11B10A15p5O20K10v14U1e5k10e12l12E4s18p11"],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[]]

class StringIterator {

	
	private String str;

	private int current_index;

	private int so_far_frequency;

	private int max_frequency;
	
	
	public StringIterator(String compressedString) {

		this.str = compressedString;
		this.current_index = 0;
		this.so_far_frequency = 0;
		this.max_frequency = getFrequency(compressedString, current_index);
		
	}

	public char next() {
		if (hasNext()) {

			if (max_frequency > so_far_frequency) {
				so_far_frequency ++;
				return str.charAt(current_index);
			}

			else {
			
				current_index = current_index + String.valueOf(max_frequency).length() + 1;
				max_frequency = getFrequency(str, current_index);
				so_far_frequency = 0;
				return next();
			}
		}
		return ' ';

	}

	public boolean hasNext() {
		return !((current_index + String.valueOf(max_frequency).length() >= (str.length() - 1)
				&& so_far_frequency >= max_frequency));
	}

	public static int getFrequency(String str, int index) {

		StringBuffer b = new StringBuffer();
		for (int i = index + 1; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				b.append(str.charAt(i));
			} else {
				break;
			}
		}
		return Integer.parseInt(b.toString());
	}
	
	
	public boolean validMountainArray(int[] A) {
		boolean check_for_small = true;
		int down_count = 0;

		for (int i = 0; i < A.length - 1; i++) {

			if (A[i] == A[i + 1]) {
				return false;
			}

			if (check_for_small) {

				if (A[i] > A[i + 1]) {
					check_for_small = false;
				} else {
					down_count++;
				}
			}

			else {

				if (A[i] <= A[i + 1]) {
					return false;
				}
			}

		}
		return down_count != 0;
	}
}