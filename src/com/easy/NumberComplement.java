/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/number-complement/description/
-------------------------------------------------------

Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:

    The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    You could assume no leading zero bit in the integer’s binary representation.

Example 1:

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:

Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.


*
*/
public class NumberComplement {
	public int findComplement(int num) {
        
        char ch[] = Integer.toBinaryString(num).toCharArray();
        int n = ch.length ; 
        int ans = 0;
        int pow = 1;
        for( int i=0; i<n; i++ ){
            ans += (((ch[n-1-i]-'0')+1)%2)*pow;
            pow = pow<<1;
        }
        return ans;
        
    }
}
