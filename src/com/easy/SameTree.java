/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/same-tree/description/
-------------------------------------------------------

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false

Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false




*
*/
public class SameTree {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
		
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null )
            return true;
        else if( p == null )
            return false;
        else if( q == null )
            return false;
        else{
            if( p.val != q.val ) 
                return false;
            else
                return (isSameTree(p.left, q.left) && isSameTree(p.right,q.right));
        }
    }
}
