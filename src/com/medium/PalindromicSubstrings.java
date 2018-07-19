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
https://leetcode.com/problems/palindromic-substrings/description/
-------------------------------------------------------

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Note:

    The input string length won't exceed 1000.



*
*/
public class PalindromicSubstrings {
	public int countSubstrings(String s) {
	       boolean dp[][] = new boolean[s.length()][s.length()];
	        char ch[] = s.toCharArray();
	        
	        for( int i=0 ; i<ch.length ; i++ ){
	            for( int j=0 ; j<=i ; j++ ){
	                if( j == i )            dp[i][j] = true;
	                else if( i - j == 1 )   dp[j][i] = (ch[i] == ch[j]);
	                else                    dp[j][i] = ( dp[j+1][i-1] && ch[j] == ch[i] );
	            }
	        }
	        int answer = 0 ;
	        for( int i=0 ; i<ch.length ; i++ ){
	            for( int j=0 ; j<=i ; j++ ){
	                if( dp[j][i] )
	                    answer++;
	            }
	        }
	        return answer; 
	    }
}
