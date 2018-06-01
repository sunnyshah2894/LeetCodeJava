/**
 *		
 */
package com.easy;

import com.easy.BinaryTreePaths.TreeNode;

/**
 *
Author: 
	Sunny Shah 
	sunnyshah452@gmail.com 
	https://github.com/sunnyshah28
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
-------------------------------------------------------
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5


*
*/
public class ConvertSortedArrayToBinarySearchTree {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if( n==0 ) return null;
        if( n==1 ) return new TreeNode(nums[0]);
        
        return createHeightBalancedBST( nums, n, n/2 , 0 , n-1);
    }
    
    TreeNode createHeightBalancedBST(int []nums, int n , int mid, int left, int right){
        if(right<left) return null;
        if( right==left ) return new TreeNode(nums[mid]);
        TreeNode root = new TreeNode(nums[mid]);
        int midLeft = left + (mid - left)/2;
        int midRight = mid + 1 + (right - mid)/2;
        root.left = createHeightBalancedBST(nums, n, midLeft, left , mid-1);
        root.right = createHeightBalancedBST(nums, n, midRight, mid+1 , right);
        return root;
    }

}
