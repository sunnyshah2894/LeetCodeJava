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
https://leetcode.com/problems/count-numbers-with-unique-digits/description/
-------------------------------------------------------

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99]) 

*
*/
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int dp[] = new int[Math.max(n+1,3)];
        dp[0]=1;
        dp[1]=10;
        dp[2]=91;
        for( int i=3 ; i<=n ; i++ ){
            dp[i] = dp[i-1] + (dp[i-1]-dp[i-2])*( ((10-i+1)>0)?(10-i+1):0 );
        }
        return dp[n];
    }
}
