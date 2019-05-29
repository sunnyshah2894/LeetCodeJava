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
https://leetcode.com/problems/base-7/description/
-------------------------------------------------------

Given an integer, return its base 7 string representation.

Example 1:

Input: 100
Output: "202"

Example 2:

Input: -7
Output: "-10"

Note: The input will be in range of [-1e7, 1e7]. 

*
*/
public class ConvertToBase7 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder("");
        if(num==0)
            return "0";
        int n = Math.abs(num);
        while( n != 0 ){
            sb.append(n%7) ;
            n /= 7;
        }
        if( num < 0 )
            sb.append('-');
        
        return sb.reverse().toString();
    }
}
