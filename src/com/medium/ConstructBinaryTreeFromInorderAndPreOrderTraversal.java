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
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
-------------------------------------------------------

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

*
*/
public class ConstructBinaryTreeFromInorderAndPreOrderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if( preorder.length == 0 )return null;
    
        return buildTree( 0,0,preorder.length , preorder,inorder );
        
    }
    public TreeNode buildTree( int indexInPreOrder , int start, int end , int preorder[] , int inorder[] ){
        
        if( indexInPreOrder >= preorder.length )
            return null;
        
        if( start>end )return null;
        
        int indexOfRoot = start;
        for( int i=start ; i<inorder.length ; i++ ){
            if( inorder[i] == preorder[indexInPreOrder] ){
                indexOfRoot = i; 
                break;
            }
        }
        
        TreeNode root = new TreeNode(preorder[indexInPreOrder]);
        root.left = buildTree( indexInPreOrder+1,start,indexOfRoot-1,preorder, inorder );
        root.right =  buildTree( indexInPreOrder+indexOfRoot-start+1,indexOfRoot+1,end,preorder, inorder );
        
        return root;
        
    }
}
