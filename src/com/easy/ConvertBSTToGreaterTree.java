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
https://leetcode.com/problems/convert-bst-to-greater-tree/description/
-------------------------------------------------------

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

*
*/
public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        solve(root, 0);
        return root;
    }
    int solve( TreeNode root, int currSum ){
        
        if( root == null )
            return 0;
          
        root.val += currSum;
        if( root.right == null && root.left == null )
            return root.val - currSum;
      
        int rightSum = solve( root.right, currSum );
        
        root.val += rightSum;
        
        if( root.left != null ){
            int leftSum = solve( root.left, root.val );
            return leftSum - currSum + root.val;
        }
        else{
            return root.val - currSum;
        }
        
    }
}
