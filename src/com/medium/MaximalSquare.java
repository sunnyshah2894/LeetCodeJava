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
https://leetcode.com/problems/maximal-square/description/
-------------------------------------------------------

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*
*/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        
        if( matrix.length == 0 )
            return 0;
        int dp[][] = new int[matrix.length][matrix[0].length];
        int answer = 0;
        for( int i=0 ; i<matrix.length ; i++ ){
            for( int j=0 ; j<matrix[0].length ; j++ ){
                if( i==0 || j==0 ){
                    dp[i][j] = (matrix[i][j] == '1')?1:0;
                }
                else if( matrix[i][j] == '1' ){
                    dp[i][j] = Math.min( dp[i][j-1] , Math.min( dp[i-1][j] , dp[i-1][j-1] ) )+1;
                }
                answer = Math.max( answer, dp[i][j]*dp[i][j] );
            }
        }
        
        return answer;
        
    }
}
