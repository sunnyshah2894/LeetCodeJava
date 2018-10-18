/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.List;

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
https://leetcode.com/problems/leaf-similar-trees/description/
-------------------------------------------------------

Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Note:

    Both of the given trees will have between 1 and 100 nodes.


*
*/
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        
        getLeafSequence( root1,leaf1 );
        getLeafSequence( root2,leaf2 );
        
        if( leaf1.size() != leaf2.size() )return false;
        
        boolean isSimilar = true;
        for( int i=0 ; i<leaf1.size() ; i++ ){
            if( leaf1.get(i) != leaf2.get(i) )return false;
        }
        return true;
    }
    
    void getLeafSequence( TreeNode root,List<Integer> leaf ){
        if( root == null ) return;
        if( root.left == null && root.right == null ){
            leaf.add( root.val );
            return;
        }
        getLeafSequence(root.left,leaf);
        getLeafSequence(root.right,leaf);
    }
    
}
