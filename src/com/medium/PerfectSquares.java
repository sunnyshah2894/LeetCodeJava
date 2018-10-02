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
https://leetcode.com/problems/perfect-squares/description/
-------------------------------------------------------

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

*
*/
public class PerfectSquares {
    public int numSquares(int n) {
        
        int dp[] = new int[n+1];
        Arrays.fill( dp,Integer.MAX_VALUE );
        dp[0] = 0;
        
        for( int i=1 ; i<(int)Math.sqrt(n)+2 ; i++ ){

            int j=i*i;
            if( j>n )
                break;
            dp[j] = 1;
            for( int k=j ; k<n+1 ; k++ ){
                dp[k] = Math.min( dp[k],dp[k-j] + 1 );
            }
            
        }
        
        return dp[n];
        
    }
}
