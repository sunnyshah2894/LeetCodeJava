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
https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
-------------------------------------------------------

Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].

Note:

    1 <= len(A), len(B) <= 1000
    0 <= A[i], B[i] < 100

*
*/
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        
        int dp[][] = new int[A.length+1][B.length+1];
        int answer = 0 ;
        
        for( int i=1 ; i<=A.length ; i++ ){
            for( int j=1 ; j<=B.length ; j++ ){
                if( A[i-1] == B[j-1] ){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                answer = Math.max( answer, dp[i][j] );
            }
        }
        
        return answer;
    }
}
