/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.List;

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
	https://leetcode.com/problems/binary-tree-paths/description/
	-------------------------------------------------------
	Given a binary tree, return all root-to-leaf paths.
	
	Note: A leaf is a node with no children.
	
	Example:
	
	Input:
	
	   1
	 /   \
	2     3
	 \
	  5
	
	Output: ["1->2->5", "1->3"]
	
	Explanation: All root-to-leaf paths are: 1->2->5, 1->3
	
 *
 */
public class BinaryTreePaths {
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<>();
        findAllPaths( root, new String("") , ls );
        return ls;
    }
    
    void findAllPaths( TreeNode root, String s, List<String> res ){
        if( root == null )return;
        if( root.left == null && root.right == null ){ // this is the leaf node
            res.add(s + root.val);
            return;
        }
        findAllPaths(root.left , s+root.val+"->" , res );
        findAllPaths(root.right , s+root.val+"->" , res );
        return;
    }
	
}
