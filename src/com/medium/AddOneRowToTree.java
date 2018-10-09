/**
 *		
 */
package com.medium;

import java.util.LinkedList;
import java.util.Queue;

import com.medium.BinaryTreeLevelOrderTraversal.TreeNode;

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
https://leetcode.com/problems/add-one-row-to-tree/description/
-------------------------------------------------------

Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:

Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   

Example 2:

Input: 
A binary tree as following:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

Output: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1

Note:

    The given d is in range [1, maximum depth of the given tree + 1].
    The given binary tree has at least one tree node.

*
*/
public class AddOneRowToTree {
	
	class TreeNode{
		/**
		 * @param i
		 */
		public TreeNode(int i) {
			val = i;
		}
		int val;
		TreeNode left, right;
	}
	
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        
        int depth = 1 ;
        if( d==1 ){
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            return temp;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while( depth<d-1 && !q.isEmpty() ){
            
            depth++;
            int noOfElements = q.size();
            while( noOfElements-->0 ){
                TreeNode temp = q.poll();
                if( temp.left!=null )
                    q.add( temp.left );
                if( temp.right!=null )
                    q.add( temp.right );
            }
            
        }
        
        while( !q.isEmpty() ){
            
            TreeNode temp = q.poll();
            
            TreeNode newNodeLeft = new TreeNode(v);
            newNodeLeft.left = temp.left;
            TreeNode newNodeRight = new TreeNode(v);
            newNodeRight.right = temp.right;
            
            temp.left = newNodeLeft;
            temp.right = newNodeRight;
            
        }
        
        return root;
        
    }
}
