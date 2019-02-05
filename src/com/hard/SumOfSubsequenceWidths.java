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
https://leetcode.com/problems/sum-of-subsequence-widths/description/
-------------------------------------------------------

Given an array of integers A, consider all non-empty subsequences of A.

For any sequence S, let the width of S be the difference between the maximum and minimum element of S.

Return the sum of the widths of all subsequences of A. 

As the answer may be very large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: [2,1,3]
Output: 6
Explanation:
Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.

 

Note:

    1 <= A.length <= 20000
    1 <= A[i] <= 20000

*
*/
public class SumOfSubsequenceWidths {
    public int sumSubseqWidths(int[] A) {
        
        long mod = 1000000007;
        long answer = 0;
        
        Arrays.sort( A );
        long power = 1;
        
        for( int i=0 ; i<A.length ; power = (power<<1)%mod , i++ ){
            
            long temp = ( ( ( ( power ) * A[i] ) % mod )  - ( ( (power) * A[A.length-1-i] ) % mod ) + mod ) % mod ;
            answer = (answer + temp) % mod;
            
        }
        
        return (int)answer;
        
    }
    public int sumSubseqWidthsFirstAttempt(int[] A) {
        
        long mod = 1000000007;
        long answer = 0;
        
        Arrays.sort( A );
        
        for( int i=0 ; i<A.length ; i++ ){
            
            long prev = ( pow( 2,i,mod ) - 1 ) % mod;
            long next = ( pow( 2,A.length-1-i,mod ) - 1 ) % mod;
            
            long temp = ( ( ( prev - next + mod ) % mod ) * A[i] ) % mod ;
            
            answer = (answer + temp) % mod;
            
        }
        
        return (int)answer;
        
    }
    
    public static long pow(long n, long p, long m) {
		long result = 1;
		if (p == 0)
			return 1;
		if (p == 1)
			return n;
		while (p != 0) {
			if (p % 2 == 1)
				result *= n;
			if (result >= m)
				result %= m;
			p >>= 1;
			n *= n;
			if (n >= m)
				n %= m;
		}
		return result;
	}
}
