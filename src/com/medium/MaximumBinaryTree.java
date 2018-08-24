/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/maximum-binary-tree/description/
-------------------------------------------------------

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

Example 1:

Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1

Note:

    The size of the given array will be in the range [1,1000].


*
*/
public class MaximumBinaryTree {
	/**
	 * 
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree( nums,0,nums.length-1 );
    }
    
    TreeNode constructMaximumBinaryTree( int[] nums, int l , int r ){
        if( l>r ) return null;
        if( l==r ) return new TreeNode(nums[l]);
        
        int maxIndex = l;
        for( int i=l+1 ; i<=r ; i++ )
            if( nums[i] > nums[maxIndex] )
                maxIndex = i;
        
        TreeNode parent = new TreeNode(nums[maxIndex]);
        parent.left = constructMaximumBinaryTree( nums,l,maxIndex-1 );
        parent.right = constructMaximumBinaryTree( nums,maxIndex+1,r );
        
        return parent;
    }
}
