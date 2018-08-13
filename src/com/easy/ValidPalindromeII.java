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
https://leetcode.com/problems/valid-palindrome-ii/description/
-------------------------------------------------------

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:

Input: "aba"
Output: True

Example 2:

Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:

    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.


*
*/
public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
        
        char ch[] = s.toCharArray();
        
        int left = 0 , right = s.length()-1;
        boolean deleted = true;
        
        while( left<right ){
            if( ch[left] != ch[right] ){
                break;
            }
            left++ ; right--;
        }
        
        //delete left 
        int tleft = left , tright = right;
        left++;
        while( left<right ){
            if( ch[left] != ch[right] ){
                deleted = false;
            }
            left++ ; right--;
        }
        
        if( deleted )return true;
        else{
            //delete right
            deleted = true;
            left = tleft;
            right = tright-1;
            while( left<right ){
                if( ch[left] != ch[right] ){
                    deleted = false;
                }
                left++ ; right--;
            }
        }
        
        return deleted;
        
    }
}
