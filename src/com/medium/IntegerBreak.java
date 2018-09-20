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
https://leetcode.com/problems/integer-break/description/
-------------------------------------------------------

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

*
*/
public class IntegerBreak {
	public int integerBreak(int n) {
	    
        if( n == 2 ) return 1;
        if( n == 3 ) return 2;
        if ( n%3 == 0 ){
            return (int) Math.pow( 3, (n/3) );
        } 
        else if ( n%3 == 2 ){
            return (int) Math.pow( 3, (n/3) )*2;
        }
        else {
            return (int) Math.pow( 3,(n/3-1) )*4;
        }
        
    }
}
