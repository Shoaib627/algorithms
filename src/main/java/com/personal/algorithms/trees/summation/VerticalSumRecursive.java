package com.personal.algorithms.trees.summation;

import java.util.TreeMap;

import com.personal.algorithms.trees.TreeGenerator;
import com.personal.algorithms.trees.TreeNode;

public class VerticalSumRecursive {

	public static TreeMap<Integer, Integer> map;

	public VerticalSumRecursive() {
		VerticalSumRecursive.map = new TreeMap<>();
	}

	public void sum(TreeNode root, int index) {
		if (root == null) {
			return;
		}

		Integer sum = map.getOrDefault(index, 0);
		sum = sum + root.val;
		map.put(index, sum);

		sum(root.left, index - 1);
		sum(root.right, index + 1);

	}

	public static void main(String[] args) {
		VerticalSumRecursive ll = new VerticalSumRecursive();
		ll.sum(TreeGenerator.getTree(), 0);
		System.out.println(map.values());
	}
}