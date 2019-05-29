/**
 *		
 */
package com.easy;

import java.util.HashMap;
import java.util.Map;

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
https://leetcode.com/problems/word-pattern/description/
-------------------------------------------------------

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

*
*/
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        
        Map<String, Character> mp = new HashMap<>();
        boolean isTaken[] = new boolean[26];
        String words[] = str.split(" ");
        char ch[] = pattern.toCharArray();
        if( ch.length != words.length ) return false;
        
        for( int i=0; i<words.length ; i++ ){
            
            if( mp.containsKey(words[i]) ){
                if( mp.get(words[i]) != ch[i] ){
                    return false;
                }
            }
            else{
                if( isTaken[ch[i] - 'a'] )
                    return false;
                mp.put( words[i], ch[i] );
                isTaken[ch[i] - 'a'] = true;
                
            }
            
        }
        return true;
        
    }
}
