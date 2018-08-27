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
https://leetcode.com/problems/count-complete-tree-nodes/description/
-------------------------------------------------------

Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6



*
*/
public class CountCompleteTreeNodes {
	
	class TreeNode{
		TreeNode left,right;
	}
	
    public int countNodes(TreeNode root) {
        if( root == null )return 0;
        
        int leftHeight = 0, rightHeight = 0;
        TreeNode curr = root;
        while(curr!=null){
            leftHeight++;
            curr = curr.left;
        }
        curr = root;
        while(curr!=null){
            rightHeight++;
            curr = curr.right;
        }
        
        if( leftHeight == rightHeight ){
            return (1<<leftHeight)-1;
        }
        
        else return 1+countNodes(root.left)+countNodes(root.right);
        
    }
}
