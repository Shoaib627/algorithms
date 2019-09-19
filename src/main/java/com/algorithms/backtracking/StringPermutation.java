package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		permute("AABC");

	}

	public static List<String> permute(String str) {
		List<String>  result = new ArrayList<String>();
		permuteHelper(str, "", result);
		return result;
	}

	public static void permuteHelper(String available, String choosen, List<String> result) {
		
		//System.out.println("********* Avaialble *********  " + available + " ********Choosen***********  " + choosen);

		if (available.isEmpty() && isPalindrome(choosen)) {
			System.out.println(choosen);
			result.add(new String(choosen));
		}

		else {

			for (int i = 0; i < available.length(); i++) {
				char c = available.charAt(i);
				
				// choose
				choosen = choosen + c;
				available = available.substring(0, i) + available.substring(i + 1);

				// explore
				permuteHelper(available, choosen, result);

				// unchoose
				choosen = choosen.substring(0, choosen.length() - 1);
				available = new StringBuilder(available).insert(i, c).toString();

			}
		}
	}
	
	
	public static boolean isPalindrome(String text) {
	    String clean = text.replaceAll("\\s+", "").toLowerCase();
	    int length = clean.length();
	    int forward = 0;
	    int backward = length - 1;
	    while (backward > forward) {
	        char forwardChar = clean.charAt(forward++);
	        char backwardChar = clean.charAt(backward--);
	        if (forwardChar != backwardChar)
	            return false;
	    }
	    return true;
	}
}