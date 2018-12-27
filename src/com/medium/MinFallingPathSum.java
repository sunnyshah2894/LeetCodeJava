/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/minimum-falling-path-sum/description/
-------------------------------------------------------

Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.

 

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation: 
The possible falling paths are:

    [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
    [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
    [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]

The falling path with the smallest sum is [1,4,7], so the answer is 12.

 

Note:

    1 <= A.length == A[0].length <= 100
    -100 <= A[i][j] <= 10

*
*/
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        
        int dp[][] = new int[A.length+1][A[0].length+1]; 
        
        for( int i=0 ; i<A.length ; i++ ){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        
        int answer = dp[A.length-1][0];
        for( int i=0 ; i<A.length ; i++ ){
            for( int j=0 ; j<A[0].length ; j++ ){
                
                if( i==0 )
                    dp[i][j] = A[i][j];
                else if( j==0 )
                    dp[i][j] = Math.min( dp[i-1][j], dp[i-1][j+1] ) + A[i][j];
                else
                    dp[i][j] = Math.min(Math.min( dp[i-1][j],dp[i-1][j+1] ), dp[i-1][j-1])+A[i][j];
                
                if( i == A.length-1 )
                    answer = Math.min( answer , dp[i][j] );
            }
        } 
        
        return answer;
        
    }
}
