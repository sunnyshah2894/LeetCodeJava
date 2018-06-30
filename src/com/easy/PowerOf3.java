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
https://leetcode.com/problems/power-of-three/description/
-------------------------------------------------------

Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true

Example 2:

Input: 0
Output: false

Example 3:

Input: 9
Output: true

Example 4:

Input: 45
Output: false

Follow up:
Could you do it without using any loop / recursion?


*
*/
public class PowerOf3 {

	/*
	 * Power of 3 are only divisible by Powers of 3
	 * 
	 * we can use 3^19 as one power to test all powers against as 3^20 overflows in case of int data type.
	 * 
	 */
	public boolean isPowerOfThree(int n) {
        return ( n>0 && (1162261467%n)==0);
        
        /*
         * OR
         * 
         * 
       	if( n<1 ) return false;
        
        while(n%3==0) {
            n/=3;
        }
        return (n==1);
         * 
         * 
         */
        
    }
	
}
