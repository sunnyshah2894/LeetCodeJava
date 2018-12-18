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
https://leetcode.com/problems/minimum-path-sum/description/
-------------------------------------------------------

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*
*/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        long dp[][] = new long[m][n];
        for( int i=0 ; i<m ; i++ )
            dp[i][0] = grid[i][0];
        
        for( int i=0 ; i<m ; i++ ){
            for( int j=0 ; j<n ; j++ ){
                
                if( i==0 )
                    if( j==0 )
                        dp[i][j] = grid[i][j];
                    else
                        dp[i][j] = grid[i][j] + dp[i][j-1];
                else if( j==0 )
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                else
                    dp[i][j] = grid[i][j] + Math.min( dp[i-1][j] , dp[i][j-1] );
                
            } 
        }
        return (int)dp[m-1][n-1];
        
    }
}
