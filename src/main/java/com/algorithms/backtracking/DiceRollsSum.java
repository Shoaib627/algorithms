package com.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class DiceRollsSum {

	// TODO: How to add the the choosen to result;
	public static void main(String[] args) {

		diceRolls(3);
	}

	static void diceRolls(int dice) {
		List<Integer> choosen = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<>();
		diceHelper(dice, choosen, result);
		System.out.println(result);

	}

	static void diceHelper(int dice, List<Integer> choosen, List<List<Integer>> result) {

		if (dice == 0) {
			// base case
			// no dice left to roll
			System.out.println(choosen);
			
			
			// **** Important ****
			// To the result we need a add deep copy of choosen.
			// Adding plain choosen to result, is pass by reference, and at the end of call
			// stack choose will be empty
			result.add(new ArrayList<>(choosen));
			//System.out.println(result);

		}

		else {

			// some dice left to roll;
			// handle one die

			// for each value the die can have:

			for (int i = 1; i <= 6; i++) {

				// ........ choose
				choosen.add(i);

				// ........ explore
				diceHelper(dice - 1, choosen, result);

				// ........ un-choose
				choosen.remove(choosen.size() - 1);
			}
		}
	}
}