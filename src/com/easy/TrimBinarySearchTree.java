/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/trim-a-binary-search-tree/description/
-------------------------------------------------------

Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:

Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2

Example 2:

Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1



*
*/
public class TrimBinarySearchTree {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	 
	
	public TreeNode trimBST(TreeNode root, int L, int R) {
        if( root == null )return null;
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        if( root.val<L || root.val >R ){
            if( root.left != null )
                root = root.left;  
            else root = root.right;
        }
        return root;
        
    }

}
