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
https://leetcode.com/problems/reverse-string/description/
-------------------------------------------------------

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh". 	

*
*/
public class ReverseString {
	public String reverseString(String s) {
        char ch[] = s.toCharArray();
        int n = s.length();
        for( int i=0; i<n/2; i++){
            char t = ch[i];
            ch[i] = ch[n-1-i];
            ch[n-1-i] = t;
        }
        return new String(ch);
    }
}
