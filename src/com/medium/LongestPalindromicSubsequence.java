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
https://leetcode.com/problems/longest-palindromic-subsequence/description/
-------------------------------------------------------

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"

Output:

4

One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:

"cbbd"

Output:

2

One possible longest palindromic subsequence is "bb". 

*
*/
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        
        char src[] = s.toCharArray();
        int n = src.length;
        char dst[] = new char[n];
        
        for( int i=n-1 ; i>=0 ; i-- ){
            dst[n-1-i] = src[i];
        }
        
        
        int dp[][] = new int[n+1][n+1];
        
        for( int i=1 ; i<=n ; i++ ){
            for( int j=1 ; j<=n ; j++ ){
                
                dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] );
                if( src[i-1] == dst[j-1] )
                    dp[i][j] = Math.max( dp[i][j],1+dp[i-1][j-1] );
                
            }
        }
        
        return dp[n][n];
        
    }
}
