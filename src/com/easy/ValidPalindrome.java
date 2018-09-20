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
https://leetcode.com/problems/valid-palindrome/description/
-------------------------------------------------------

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false



*
*/
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        
        s = lowerCaseString(s);
        char ch[] = s.toCharArray();
        
        int left = 0 , right = s.length()-1 ;
        
        while( left < right ){
            if( !isAlphaNumeric(ch[left]) ) left++;
            else if( !isAlphaNumeric(ch[right]) ) right--;
            else if( ch[left] != ch[right] )
                return false;
            else{
                left++ ; right-- ;
            }
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char c){
        return ( Character.isLetter(c) || Character.isDigit(c) );
    }
    
    public String lowerCaseString(String s) {
        char ch[] = s.toCharArray();
        for( int i=0 ; i<s.length() ; i++ ){
            if( Character.isLetter(ch[i]) && Character.isUpperCase(ch[i]) ){
                ch[i] = Character.toLowerCase(ch[i]);
            }
        }
        return new String(ch);
    }
}
