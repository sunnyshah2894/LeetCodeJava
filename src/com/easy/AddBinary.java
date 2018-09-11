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
https://leetcode.com/problems/add-binary/description/
-------------------------------------------------------

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

*
*/
public class AddBinary {
    public String addBinary(String a, String b) {
        
        char answer[] = new char[500];
        char A[] = a.toCharArray();
        char B[] = b.toCharArray();
        
        int currA = A.length-1;
        int currB = B.length-1;
        
        int prevCarry = 0, index = 0;
        
        while( currA>=0 || currB>=0 || prevCarry>0 ){
            
            int aNum = (currA>=0)?(A[currA] - '0'):0;
            int bNum = (currB>=0)?(B[currB] - '0'):0;
            answer[index++] = (( aNum ^ bNum ^ prevCarry )>0 )?'1':'0' ;
            
            prevCarry = ( aNum + bNum + prevCarry > 1 )?1:0;
            currA--; currB--;
            
        }
        StringBuilder result = new StringBuilder();
        for( int i=0 ; i<index; i++ ){
            result.insert(0,answer[i]);
        }
        return new String(result);
    }
}
