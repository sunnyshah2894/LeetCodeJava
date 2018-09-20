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
https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
-------------------------------------------------------

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.



*
*/
public class SumRootToLeafNumbers {
	int answer = 0 ;
	class TreeNode{
		TreeNode left, right;
		int val;
	}
    public int sumNumbers(TreeNode root) {
        calc(root,0);
        return answer;
    }
    
    public void calc( TreeNode root,int currVal ){
        
        if( root == null ){
            return;
        }
        
        currVal = currVal * 10 + root.val;
        if( root.left == null && root.right == null ){
            answer += currVal;
            return;
        }
        calc( root.left,currVal );
        calc( root.right,currVal );
        
    }
}
