/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
https://leetcode.com/problems/find-duplicate-subtrees/description/
-------------------------------------------------------

Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4

The following are two duplicate subtrees:

      2
     /
    4

and

    4

Therefore, you need to return above trees' root in the form of a list.

*
*/
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        List<TreeNode> ls = new ArrayList<>();
        Set<String> st = new HashSet<>();
        Set<TreeNode> result = new HashSet<>();
        Set<String> resultString = new HashSet<>();
        
        if( root == null )
            return ls;
        
        duplicates( root,st,result,resultString );
        
        return (new ArrayList<TreeNode>(result));
        
    }
    public String duplicates( TreeNode root, Set<String> st, Set<TreeNode> result, Set<String> resultSet ){
        
        if( root == null )
            return new String(",");
        StringBuilder s = new StringBuilder();
        s.append( root.val );
        s.append( "," );
        s.append(duplicates( root.left,st,result,resultSet ));
        s.append( "," );
        s.append(duplicates(root.right,st,result,resultSet ));
        
        String key = s.toString();

        if( !resultSet.contains( key ) && st.contains( key ) ){
            result.add( root );
            resultSet.add( key );
        }
        st.add(key);
        return key;
    }
}
