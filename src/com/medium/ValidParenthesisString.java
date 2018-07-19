/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/valid-parenthesis-string/description/
-------------------------------------------------------

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    An empty string is also valid.

Example 1:

Input: "()"
Output: True

Example 2:

Input: "(*)"
Output: True

Example 3:

Input: "(*))"
Output: True

Note:

    The string size will be in the range [1, 100].



*
*/
public class ValidParenthesisString {
	public boolean checkValidString(String s) {
        
        char ch[] = s.toCharArray();
        int sum = 0;
        for( char c: ch ){
            if( c=='*' || c=='(' )sum++;
            else sum--;
            if( sum<0 ) return false;
        }
        
        if( sum==0 ) return true;
        sum = 0;
        for( int i=ch.length-1 ; i>=0 ; i-- ){
            if( ch[i]=='*' || ch[i]==')' )sum++;
            else sum--;
            if( sum<0 )return false;
        }
        return true;
        
    }
}
