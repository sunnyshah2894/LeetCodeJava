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
https://leetcode.com/problems/find-bottom-left-tree-value/description/
-------------------------------------------------------

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:

Input:

    2
   / \
  1   3

Output:
1

Example 2:

Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7

Note: You may assume the tree (i.e., the given root node) is not NULL. 

*
*/
public class FindBottomLeftTreeValue {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	    
    static int maxDepthTillNow = -1;
    static int maxDepthValue = -1;
    public int findBottomLeftValue(TreeNode root) {
        maxDepthTillNow = -1;
        maxDepthValue = -1;
        findBottomLeftValue( root, 0 );
        return maxDepthValue;
    }
    
    public void findBottomLeftValue(TreeNode root, int depth){
        if(root == null)return;
        
        if( depth > maxDepthTillNow ){
            maxDepthTillNow = depth;
            maxDepthValue = root.val;
        }
        
        findBottomLeftValue(root.left, depth+1);
        findBottomLeftValue(root.right, depth+1);
        
    }

}
