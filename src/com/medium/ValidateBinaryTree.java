/**
 *		
 */
package com.medium;

/**
 *
Author: 
	Sunny Shah 
	sunnyshah452@gmail.com 
	https://github.com/sunnyshah2894
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/validate-binary-search-tree/description/
-------------------------------------------------------

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:

Input:
    2
   / \
  1   3
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.




*
*/
public class ValidateBinaryTree {
	class TreeNode{
		int val;
		TreeNode right, left;
	}
	
	public boolean isValidBST(TreeNode root) {
        return checkIfValidBST(root, Long.MIN_VALUE , Long.MAX_VALUE);
    }
    
    boolean checkIfValidBST(TreeNode root, long min, long max){
        if( root == null ) return true;
        
        if( root.val >= max || root.val <= min ) return false;
        return ( checkIfValidBST(root.left , min , root.val) && checkIfValidBST( root.right, root.val , max ) );
    }
}
