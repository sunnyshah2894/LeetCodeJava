/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/construct-string-from-binary-tree/description/
-------------------------------------------------------
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:

Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".

Example 2:

Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.


*
*/
public class ConstructStringFromBinaryTree {
	
	class TreeNode{
		int val;
		TreeNode left, right;
	}
	
	public String tree2str(TreeNode t) {
        StringBuilder bstString = new StringBuilder("");
        bstPreOrderTraversal( t , bstString );
        return new String(bstString);
    }
    public void bstPreOrderTraversal(TreeNode t, StringBuilder bstString){
        if( t == null )return;
        bstString.append( t.val+"" );
        if( t.left == null && t.right == null ) return;
        
        if( t.left != null ){
            bstString.append("(");
            bstPreOrderTraversal( t.left , bstString );
            bstString.append(")");
        }
        else if( t.right !=null ){
            bstString.append( "()" );
        }
        if( t.right != null ){
            bstString.append("(");
            bstPreOrderTraversal( t.right , bstString );
            bstString.append(")");
        }
    }
}
