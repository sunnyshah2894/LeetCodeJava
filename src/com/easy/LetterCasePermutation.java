/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.List;

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
https://leetcode.com/problems/letter-case-permutation/description/
-------------------------------------------------------

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

Note:

    S will be a string with length at most 12.
    S will consist only of letters or digits.


*
*/
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> ls = new ArrayList<>();
        permute( S.toCharArray(),S,0,ls );
        return ls;
    }
    void permute( char ch[],String S,int index,List<String> ls ){
        
        if( index >= ch.length ){
            ls.add( new String(ch) );
            return;
        }
        
        if( Character.isLetter(ch[index]) ){
            permute( ch,S,index+1,ls );
            if( ch[index] >= 97 ){
                ch[index] = (char)(ch[index] - 32);
            }
            else{
                ch[index] = (char)(ch[index] + 32);
            }
            permute( ch,S,index+1,ls );
        }
        else{
            permute( ch,S,index+1,ls );
        }
        
    }
}
