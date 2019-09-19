package com.algorithms.trees.summation;

import java.util.TreeMap;

import com.algorithms.trees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class DiagonalSumRecursive {

	public static TreeMap<Integer, Integer> map;

	public DiagonalSumRecursive() {
		DiagonalSumRecursive.map = new TreeMap<>();
	}

	public void sum(TreeNode root, int index) {
		if (root == null) {
			return;
		}

		Integer sum = map.getOrDefault(index, 0);
		sum = sum + root.val;
		map.put(index, sum);

		sum(root.left, index + 1);
		sum(root.right, index);

	}

	public static void main(String[] args) {
		DiagonalSumRecursive ll = new DiagonalSumRecursive();
		ll.sum(TreeGenerator.getTree(), 0);
		System.out.println(map.values());
	}
}