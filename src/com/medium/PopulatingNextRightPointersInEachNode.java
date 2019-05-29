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
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
-------------------------------------------------------

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    Recursive approach is fine, implicit stack space does not count as extra space for this problem.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7

After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

*
*/
public class PopulatingNextRightPointersInEachNode {
	
	public class TreeLinkNode {	
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	 
	public void connect(TreeLinkNode root) {
        solve( root,null );
    }
    public void solve( TreeLinkNode root,TreeLinkNode prev ){
        if( root==null || ( root.left == null && root.right == null ) )
            return;
        if( prev != null )
            prev.right.next = root.left;
        root.left.next = root.right;
        if(prev == null)
            solve( root.left,null );
        else 
            solve( root.left,prev.right );
        solve( root.right,root.left );
    }
}
