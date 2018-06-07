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
https://leetcode.com/problems/perfect-number/description/
-------------------------------------------------------

We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.

Example:

Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14

Note: The input number n will not exceed 100,000,000. (1e8) 

*
*/
public class PerfectNumber {

	public boolean checkPerfectNumber(int num) {
	    if(num == 1) return false;
	    int ans = 1 ;
	    
	    for( int i=2 ; i<(int)(Math.sqrt(num)+1) ; i++ ){
	        if( num%i == 0 ){
	            ans += i + ( num/i );
	        }
	        if( ans > num ) break;
	    }
	    if( ans == num ) return true;
	    return false;
	
	}
}
