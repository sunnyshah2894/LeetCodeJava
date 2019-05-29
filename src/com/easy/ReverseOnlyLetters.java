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
https://leetcode.com/problems/reverse-only-letters/description/
-------------------------------------------------------

Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.


Example 1:

Input: "ab-cd"
Output: "dc-ba"

Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

 

Note:

    S.length <= 100
    33 <= S[i].ASCIIcode <= 122 
    S doesn't contain \ or "

*
*/
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        
        char ch[] = S.toCharArray();
        
        int low = 0 ; 
        int high = S.length()-1;
        
        while( low < high ){
            
            if( ( (ch[low]<='Z' && ch[low] >='A') || ( ch[low]<='z' && ch[low] >='a' ) ) && ( (ch[high]<='Z' && ch[high] >='A') || ( ch[high]<='z' && ch[high] >='a' ) ) ){
                
                char t = ch[low];
                ch[low] = ch[high];
                ch[high] = t;
                low++;
                high--;
                
            }
            
            if( !( (ch[low]<='Z' && ch[low] >='A') || ( ch[low]<='z' && ch[low] >='a' ) ) ){
                low++;
            }
            if( !( (ch[high]<='Z' && ch[high] >='A') || ( ch[high]<='z' && ch[high] >='a' ) ) ){
                high--;
            }
            
        }
        
        return new String(ch);
        
    }
}
