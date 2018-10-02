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
https://leetcode.com/problems/add-strings/description/
-------------------------------------------------------

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

*
*/
public class AddStrings {
    public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder();
        char ch1[] = num1.toCharArray();
        char ch2[] = num2.toCharArray();
        
        int num1Index = num1.length()-1;
        int num2Index = num2.length()-1;
        int prevCarry = 0;
        
        while( num1Index>=0  && num2Index>=0 ){
            int summation = prevCarry + (int)(ch1[num1Index]-'0') + (int)(ch2[num2Index]-'0');
            sb.append((char) (summation%10 + '0'));
            prevCarry = summation/10;
            num1Index--; num2Index--;
        }
        
        while( num1Index>=0 ){
            int summation = prevCarry + (int)(ch1[num1Index]-'0') ;
            sb.append((char) (summation%10 + '0'));
            prevCarry = summation/10;
            num1Index--;
        }
        
        while( num2Index>=0 ){
            int summation = prevCarry + (int)(ch2[num2Index]-'0') ;
            sb.append((char) (summation%10 + '0'));
            prevCarry = summation/10;
            num2Index--;
        }
        if( prevCarry != 0 )
            sb.append((char)(prevCarry+'0'));
        
        return sb.reverse().toString();
        
    }
}
