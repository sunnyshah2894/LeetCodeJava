/**
 *		
 */
package com.easy;

import com.easy.BalancedBinaryTree.TreeNode;

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
https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
-------------------------------------------------------

*
*/
public class InsertIntoBST {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode insertIntoBST(TreeNode root, int val) {
        if( root == null ){
            root = new TreeNode(val);
            return root;
        }
        if( root.val > val ){
            root.left = insertIntoBST( root.left,val );
        }
        if( root.val < val ){
            root.right = insertIntoBST( root.right,val );
        }
        
        return root;
    }
}
