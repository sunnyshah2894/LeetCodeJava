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
https://leetcode.com/problems/ransom-note/description/
-------------------------------------------------------

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true


*
*/
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        int countAlphaRansomNote[] = new int[26];
        int countAlphaMagazine[] = new int[26];
        char charsInRansomNote[] = ransomNote.toCharArray();
        char charsInMagazine[] = magazine.toCharArray();
        
        for( char ch: charsInRansomNote ){
            countAlphaRansomNote[ch-'a']++;
        }
        for( char ch: charsInMagazine ){
            countAlphaMagazine[ch-'a']++;
        }
        boolean result = true;
        
        for( int i=0 ; i<26 ; i++ ){
            if( countAlphaMagazine[i] < countAlphaRansomNote[i] ){
                result = false;
                break;
            }
        }
        return result;
        
    }
}
