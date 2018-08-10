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
https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
-------------------------------------------------------

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4

Example 2:

Input: [0,1]
Output: 0



*
*/
public class BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
        
        int result = 0 ;
        for( int i=31 ; i>=0 ; i-- ){
            boolean isIthBitSetInN = ( (n & (1<<i)) > 0);
            boolean isIthBitSetInM = ( (m & (1<<i)) > 0);
            int temp = n;
            if( !isIthBitSetInN || !isIthBitSetInM ){
                continue;
            }
            else{
                temp = (( n ) | ((1<<i) - 1)) ^ ( 1<<i ) ;
                if( temp<m || temp>n ){
                    result = result | (1<<i);
                }
            }
        }
        return result;
    }
}
