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
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
-------------------------------------------------------

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6



*
*/
public class FlattenBinaryTreeToLinkedList {
	
	class TreeNode{
		int val;
		TreeNode right, left;
	}
	
	
	public void flatten(TreeNode root) {
        flattenTreeToLinkedList(root);
    }
    
    TreeNode flattenTreeToLinkedList(TreeNode root){
        if( root == null ){
            return null;
        }
        if( root.left == null && root.right == null )return root;
        
        TreeNode leftFlatten = flattenTreeToLinkedList( root.left );
        TreeNode rightFlatten = flattenTreeToLinkedList( root.right );
        if( leftFlatten != null && rightFlatten != null ){
            TreeNode tempRight = root.right;
            root.right = root.left;
            leftFlatten.right = tempRight;
            root.left = null;
            return rightFlatten;
        }
        else if( leftFlatten != null ){
            root.right = root.left;
            root.left = null;
            return leftFlatten;
        }
        else{
            return rightFlatten;
        }
          
    }
}
