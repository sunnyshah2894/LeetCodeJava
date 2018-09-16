/**
 *		
 */
package com.medium;

/**
 *
Author: 
	Sunny Shah 
	sunnyshah452@gmail.com 
	https://github.com/sunnyshah28
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/unique-binary-search-trees/description/
-------------------------------------------------------

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*
*/
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        
        if( n==0 )return 0;
        else if( n==1 )return 1;
        else if( n==2 )return 2;
        
        int dp[] = new int[n+1];
        dp[0] = 1 ;
        dp[1] = 1 ;
        dp[2] = 2 ;
        for( int i=3 ; i<=n ; i++ ){
            for( int j=0 ; j<i ; j++ ){
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        
        return dp[n];
        
    }
}
