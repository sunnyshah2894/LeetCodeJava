/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/unique-binary-search-trees-ii/description/
-------------------------------------------------------

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3



*
*/
public class UniqueBinarySearchTreesII {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
    public List<TreeNode> generateTrees(int n) {
        
        return generateTrees(1,n);
        
    }
    
    List<TreeNode> generateTrees( int start, int end ){
        
        List<TreeNode> ls = new ArrayList<>();
        if( start>end ){
            return ls;
        }
        if( start == end ){
            ls.add( new TreeNode(start) );
        }
        else{
            for( int i=start ; i<=end ; i++ ){
                List<TreeNode> leftNodes = generateTrees( start,i-1 );
                List<TreeNode> rightNodes = generateTrees( i+1,end );
                if( i==start ){
                    for( TreeNode rn : rightNodes ){
                        TreeNode curr = new TreeNode( i );
                        curr.left = null;
                        curr.right = rn;
                        ls.add( curr );
                    }
                }
                else if( i==end ){
                    for( TreeNode ln : leftNodes ){
                        TreeNode curr = new TreeNode( i );
                        curr.left = ln;
                        curr.right = null;
                        ls.add( curr );
                    }
                }
                else{
                    for( TreeNode ln : leftNodes ){
                        for( TreeNode rn : rightNodes ){
                            TreeNode curr = new TreeNode( i );
                            curr.left = ln;
                            curr.right = rn;
                            ls.add( curr );
                        }
                    }
                }
            }
        }
        return ls;
        
    }
    
}
