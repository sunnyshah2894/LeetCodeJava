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
https://leetcode.com/problems/ugly-number-ii/description/
-------------------------------------------------------

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note:  

    1 is typically treated as an ugly number.
    n does not exceed 1690.

*
*/
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        
        int dp[] = new int[2*n] ; 
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int index = 1;
        
        dp[0] = 1;
        int temp = n;
        while( temp-->0 ){
            dp[index++] = Math.min( dp[p2]*2 , Math.min(dp[p3]*3,dp[p5]*5) );
            if( dp[index-1] == dp[p2]*2 )
                p2++;
            if( dp[index-1] == dp[p3]*3 )
                p3++;
            if( dp[index-1] == dp[p5]*5 )
                p5++;
        }
        
        return dp[n-1];
        
    }
}
