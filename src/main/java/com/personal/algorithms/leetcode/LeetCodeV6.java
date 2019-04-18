package com.personal.algorithms.leetcode;

import java.util.Arrays;

public class LeetCodeV6 {

	public static void main(String[] args) {

		System.out.println(verifyPreorderV2(new int[] { 2, 1 }));
		System.out.println(verifyPreorder(new int[] { 2, 1 }));
		String data = "";

		String[] arr = data.split(",");

		System.out.println(Arrays.toString(arr));

		System.out.println(arr.length);

	}


	public TreeNode bstFromPreorder(int[] preorder) {
		
		if(preorder == null|| preorder.length == 0) {
			return null;
		}

		return bstFromPreorder(preorder, 0, preorder.length - 1);
	}

	public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
		
		if(start > end ) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[start]);
		
		if(start == end) {
			return root;
		}
		
		int index = start;
		
		for (int i = start; i <= end; i++) {
			if (preorder[start] < preorder[i]) {
				break;
			}
			index = i;
		}
		
		root.left = bstFromPreorder(preorder, start + 1, index);
		root.right = bstFromPreorder(preorder, index + 1, end);
		
		return root;

	}
	
    public static boolean verifyPreorder(int[] preorder) {
        
    	if(preorder == null|| preorder.length == 0) {
			return true;
		}

		return verifyPreorder(preorder, 0, preorder.length - 1);
    }


	private static boolean verifyPreorder(int[] preorder, int start, int end) {

		if (start < end) {

			int i = start + 1;
			for (i = start + 1; i <= end; i++) {
				if (preorder[start] < preorder[i]) {
					break;
				}

			}

			for (int j = i; j <= end; j++) {
				if (preorder[start] > preorder[j]) {
					return false;
				}

			}

			return verifyPreorder(preorder, start + 1, i - 1) && verifyPreorder(preorder, i, end);

		}

		return true;
	}
	

	 
	  public static boolean verifyPreorderV2(int[] preorder) {
	        return helper(preorder,0,preorder.length-1);
	    }
	    
	    public static boolean helper(int arr[],int start,int end){
	        if(start>end)
	            return true;
	        
	        int root = arr[start];
	        int i = start+1;
	        for(i=start+1;i<=end;i++){
	            if(root<arr[i])
	                break;
	        }
	        for(int j=i;j<=end;j++)
	            if(root>arr[j])
	                return false;
	        
	        return helper(arr,start+1,i-1) && helper(arr,i,end);
	        
	    }

}
