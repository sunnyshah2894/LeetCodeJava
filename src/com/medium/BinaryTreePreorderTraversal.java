/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


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
https://leetcode.com/problems/binary-tree-preorder-traversal/description/
-------------------------------------------------------
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]




*
*/
public class BinaryTreePreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	List<Integer> ls = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        ls.clear();
        
        bstPreOrderTraversalIterative( root );
        
        return ls;
    }
    
    public void bstPreOrderTraversalIterative( TreeNode root ){
        
        Stack<TreeNode> callStack = new Stack<>();
        callStack.push( root );
        while( !callStack.isEmpty() ){
            
            TreeNode temp = callStack.pop();
            if( temp != null ){
                ls.add( temp.val );
                callStack.push( temp.right );
                callStack.push( temp.left );
            }
            
        }
        
    }
    
    public void  bstPreOrdertraversal( TreeNode root ){
        if( root == null )
            return;
        ls.add(root.val);
        bstPreOrdertraversal(root.left);
        bstPreOrdertraversal(root.right);
        
    }
}
