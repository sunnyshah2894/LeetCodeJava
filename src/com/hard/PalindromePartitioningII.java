/**
 *		
 */
package com.hard;

import java.util.Arrays;

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
https://leetcode.com/problems/palindrome-partitioning-ii/description/
-------------------------------------------------------

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

*
*/
public class PalindromePartitioningII {
    public int minCut(String s) {
        
        boolean dp[][] = new boolean[s.length()][s.length()];
        
        for( int i=0 ; i<s.length() ; i++ ){
            dp[i][i] = true;
            for( int j=0 ; j<i ; j++ ){
                if( j+1 == i && s.charAt(j) == s.charAt(i) ){
                    dp[j][i] = true;
                }
                else{
                    dp[j][i] = s.charAt(j) == s.charAt(i) ? dp[j+1][i-1] : false;
                }
            }
        }
        
        int count[] = new int[s.length()];
        Arrays.fill(count,s.length()+3);
        
        for( int i=0 ; i<s.length() ; i++ ){
            for( int j=i ; j<s.length() ; j++ ){
                if( dp[i][j] ){
                    
                    int prev = 0;
                    if( i-1 >= 0 ){
                        prev = 1 + count[i-1];
                    }
                    count[j] = Math.min(count[j],prev);
                    
                }
            }
        }
        
        return count[s.length()-1];
        
    }
}
