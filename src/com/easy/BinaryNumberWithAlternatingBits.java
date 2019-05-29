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
https://leetcode.com/problems/binary-number-with-alternating-bits/description/
-------------------------------------------------------

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:

Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101

Example 2:

Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.

Example 3:

Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.

Example 4:

Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.


*
*/
public class BinaryNumberWithAlternatingBits {
	public boolean hasAlternatingBits(int n) {
        String binRep = Integer.toBinaryString(n);
        char ch[] = binRep.toCharArray();
        int index = 0;
        while( index<ch.length && ch[index] != '1' ){
            index++;
        }
        while( index<ch.length-1 ){
            if( ch[index] == ch[index+1] ){
                return false;
            }
            index++;
        }
        
        return true;
        
    }
}
