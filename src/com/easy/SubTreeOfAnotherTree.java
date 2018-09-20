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
https://leetcode.com/problems/subtree-of-another-tree/description/
-------------------------------------------------------

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2

Given tree t:

   4 
  / \
 1   2

Return true, because t has the same structure and node values with a subtree of s.

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0

Given tree t:

   4
  / \
 1   2

Return false. 

*
*/
public class SubTreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if( s==null && t==null )return true;
        if( s==null || t==null )return false;
        
        boolean equal = false;
        if( s.val == t.val ){
            equal = equal || checkEqualSubTree( s,t );
        }
        
        if( equal )return true;
        
        equal = equal || isSubtree(s.left,t);
        equal = equal || isSubtree(s.right,t);
        return equal;
    }
    
    boolean checkEqualSubTree( TreeNode s, TreeNode t ){
        if( s==null && t== null )return true;
        if( s==null || t== null )return false;
        
        if( s.val != t.val ) return false;
        else return checkEqualSubTree(s.left,t.left) && checkEqualSubTree(s.right,t.right);
        
    }
}
