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
https://leetcode.com/problems/add-digits/description/
-------------------------------------------------------

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?


*
*/
public class AddDigits {
	public int addDigitsFaster(int num) {
        if( num <= 9 )return num;
        else{
            return ((num%9)==0)?9:(num%9);
        }
    }
	public int addDigits(int num) {
        int t = num;
        while( t>9 ){
            int temp = t;
            t=0;
            while( temp!=0 ){
                t += (temp%10);
                temp /= 10;
            }
        }
        return t;
    }
}
