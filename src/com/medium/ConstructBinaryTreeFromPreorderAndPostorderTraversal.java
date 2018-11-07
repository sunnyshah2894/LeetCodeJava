/**
 *		
 */
package com.medium;

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
https://leetcode.com/contest/weekly-contest-98/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
-------------------------------------------------------

Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

 

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

 

Note:

    1 <= pre.length == post.length <= 30
    pre[] and post[] are both permutations of 1, 2, ..., pre.length.
    It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.


*
*/
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        return solve( 0, pre.length-1, 0, post.length-1, pre, post );
        
    }
    TreeNode solve( int l1, int r1, int l2, int r2, int[] pre, int[] post ){
        
        
        if( l1>r1 || l2>r2 || l1>=pre.length || l2>=pre.length || r1>=pre.length || r2>=pre.length )
            return null;
        
        
        TreeNode temp = new TreeNode(pre[l1]);
        
        if( l1 == r1 )
            return temp;
        
        int count = 1 ;
        for( int i=l2 ; i<=r2; i++ ){
            
            if( post[i] == pre[l1+1] ){
                break;
            }
            else count++;
            
        }
                
        temp.left = solve( (l1 + 1), count+l1, l2, l2+count-1, pre, post );
        temp.right = solve( ( l1 + 1 + count), r1, l2+count, r1-1, pre, post );
        return temp;
        
    }
}
