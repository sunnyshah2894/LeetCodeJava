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
https://leetcode.com/problems/power-of-two/description/
-------------------------------------------------------

Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1

Example 2:

Input: 16
Output: true
Explanation: 24 = 16

Example 3:

Input: 218
Output: false



*
*/
public class PowerOf2 {
	public boolean isPowerOfTwo(int n) {
        if( n<=0 ) return false;
        for( int i=0; i<32 ; i++ ){
            if( (n & ( 1<<i )) == n  )return true;
        }
        return false;
    }
}
