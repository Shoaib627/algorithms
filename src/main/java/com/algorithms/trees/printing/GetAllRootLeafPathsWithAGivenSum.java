package com.algorithms.trees.printing;

import java.util.ArrayList;
import java.util.List;

import com.practise.leetcode.TreeNode;

public class GetAllRootLeafPathsWithAGivenSum {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> result = new ArrayList<>();
		getAllPaths(root, new ArrayList<>(), result, sum);
		return result;
	}

	private void getAllPaths(TreeNode root, ArrayList<Integer> path, List<List<Integer>> result, int sum) {

		if (root == null) {
			return;
		}

		path.add(root.val);
		if (root.left == null && root.right == null) {

			if (sum == root.val) {
				result.add(path);
			}
			return;
		}

		getAllPaths(root.left, new ArrayList<>(path), result, sum - root.val);
		getAllPaths(root.right, new ArrayList<>(path), result, sum - root.val);

		return;
	}

	public static void main(String[] args) {
		
		GetAllRootLeafPathsWithAGivenSum g = new GetAllRootLeafPathsWithAGivenSum();
		
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		
		
		
		System.out.println(g.pathSum(root, 7));

	}

}
