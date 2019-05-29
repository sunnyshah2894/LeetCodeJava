/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/factorial-trailing-zeroes/description/
-------------------------------------------------------

Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.

Note: Your solution should be in logarithmic time complexity.

*
*/
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        
        int count = 0;
        long start = 5;
        long num = n;
        while( num>=start ){
            count +=  num/start;
            start *= 5;
        }
        
        return count;
    }
}
