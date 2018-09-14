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
https://leetcode.com/problems/first-unique-character-in-a-string/description/
-------------------------------------------------------

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 

*
*/
public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
        int count[] = new int[26];
        char sch[] = s.toCharArray();
        
        for( char ch: sch )
            count[ch-'a']++;
                
        int index = 0 ;
        for( char ch: sch ){
            if( count[ch-'a'] == 1 ) return index ;
            index++;
        }
        return -1;
   }
}
