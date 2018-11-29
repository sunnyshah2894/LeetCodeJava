/**
 *		
 */
package com.hard;

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
https://leetcode.com/problems/edit-distance/description/
-------------------------------------------------------

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


*
*/
public class EditDistance {
    public int minDistance(String A, String B) {
        
        int dp[][] = new int[A.length()+1][B.length()+1];
        for( int i=0 ; i<A.length()+1 ; i++ ){
            for( int j=0 ; j<B.length()+1 ; j++ ){
                if( i==0 )
                    dp[i][j] = j;
                else if( j==0 )
                    dp[i][j] = i;
                else if( A.charAt( i-1 ) == B.charAt( j-1 ) ){
                    dp[i][j] = dp[i-1][j-1];
                }  
                else{
                    dp[i][j] = Math.min( dp[i][j-1], Math.min( dp[i-1][j],dp[i-1][j-1] ) ) + 1 ;
                }
                
            }
        }
        return dp[A.length()][B.length()];
        
    }
}
