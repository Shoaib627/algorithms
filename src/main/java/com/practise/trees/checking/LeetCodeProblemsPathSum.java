package com.practise.trees.checking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fundamentals.binarytrees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class LeetCodeProblemsPathSum {

	public List<String> binaryTreePaths(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}
		List<String> result = new ArrayList<>();
		paths(root, "", result);

		return result;
	}

	private void paths(TreeNode root, String path, List<String> result) {

		if (root == null) {
			return;
		}

		boolean isleaf = isNodeLeaf(root);

		if (isleaf) {
			path = path + root.val;
		} else {
			path = path + root.val + "->";
		}

		if (isleaf) {

			result.add(path);
		}

		paths(root.left, new String(path), result);
		paths(root.right, new String(path), result);

	}
	
	public int sumNumbers(TreeNode root) {

		if (root == null) {
			return 0;
		}

		ArrayList<Integer> result = new ArrayList<>();

		sumNumbers(root, 0, result);

		int r = 0;
		for (int i = 0; i < result.size(); i++) {
			r = r + result.get(i);
		}

		return r;
	}

	private void sumNumbers(TreeNode root, Integer temp, List<Integer> result) {

		if (root == null) {
			return;
		}

		temp = temp * 10 + root.val;

		if (isNodeLeaf(root)) {

			result.add(temp);
		}

		sumNumbers(root.left, new Integer(temp), result);
		sumNumbers(root.right, new Integer(temp), result);

	}
	
	public boolean isNodeLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}
	
	
    public String smallestFromLeaf(TreeNode root) {
        

		if (root == null) {
			return null;
		}
		ArrayList<String> result = new ArrayList<>();

		smallestFromLeaf(root, "", result);
		
		
		Collections.sort(result);
		
		return result.get(0);
    }
    
    
	private void smallestFromLeaf(TreeNode root, String temp, List<String> result) {

		if (root == null) {
			return;
		}


		temp = temp + (char) (root.val + 97);

		if (isNodeLeaf(root)) {

			StringBuffer b = new StringBuffer(temp);
			result.add(b.reverse().toString());
		}

		smallestFromLeaf(root.left, new String(temp), result);
		smallestFromLeaf(root.right, new String(temp), result);
	}
	
	class Solution {
		
		public boolean isNodeLeaf(TreeNode root) {
			return root.left == null && root.right == null;
		}

		String ans = "~";

		public String smallestFromLeaf(TreeNode root) {

			if (root == null) {
				return null;
			}

			smallestFromLeaf(root, "");

			return ans;
		}

		private void smallestFromLeaf(TreeNode root, String temp) {

			if (root == null) {
				return;
			}

			temp = temp + (char) (root.val + 97);

			if (isNodeLeaf(root)) {

				StringBuffer b = new StringBuffer(temp);
				String S = b.reverse().toString();
				if (S.compareTo(ans) < 0) {
					ans = S;
				}
			}

			smallestFromLeaf(root.left, new String(temp));
			smallestFromLeaf(root.right, new String(temp));
		}
	}

	public static void main(String[] args) {
		LeetCodeProblemsPathSum ll = new LeetCodeProblemsPathSum();
		System.out.println(ll.smallestFromLeaf(TreeGenerator.getTree()));

	}
	
	
	public Integer binaryToNum(String binary){
	    char[] numbers = binary.toCharArray();
	    Integer result = 0;
	    int count = 0;
	    for(int i=numbers.length-1;i>=0;i--){
	         if(numbers[i]=='1')result+=(int)Math.pow(2, count);
	         count++;
	    }
	    return result;
	}
	
	public int sumRootToLeaf(TreeNode root) {
		int sum = 0;
		sumRootToLeaf(root, "", sum);
		return sum;
	}

	public void sumRootToLeaf(TreeNode root, String temp, Integer sum) {

		if (root == null) {
			return;
		}

		temp = temp + root.val;
		if (isNodeLeaf(root)) {
			System.out.println(binaryToNum(temp));
			sum = sum + binaryToNum(temp);
		}

		sumRootToLeaf(root.left, new String(temp), sum);
		sumRootToLeaf(root.right, new String(temp), sum);

	}
}