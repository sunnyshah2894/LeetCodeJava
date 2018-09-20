/**
 *		
 */
package com.medium;

import java.util.HashMap;
import java.util.Map;

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
https://leetcode.com/problems/house-robber-iii/description/
-------------------------------------------------------

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

*
*/
public class HouseRobberIII {
    public int rob(TreeNode root) {
        
        Map<TreeNode,Integer> myMap = new HashMap<>();
        return rob(root,myMap);
        
    }
    int rob( TreeNode root, Map<TreeNode,Integer> hs ){
        
        int answer = 0 ; 
        if( hs.containsKey( root ) )
            return hs.get( root );
        
        if( root == null )
            answer = 0;
        else{
            int resultIfNotChoosed = rob(root.left,hs) + rob(root.right,hs);
            int resultIfChoosed = root.val;

            if( root.left != null ){
                resultIfChoosed += rob( root.left.left,hs ) + rob(root.left.right,hs) ;
            }
            
            if( root.right != null ){
                resultIfChoosed += rob( root.right.left,hs ) + rob(root.right.right,hs) ;
            }
            answer = Math.max( resultIfNotChoosed,resultIfChoosed );    
        }
        hs.put( root,answer );
        return answer;
        
    }
}
