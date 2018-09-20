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
https://leetcode.com/problems/valid-anagram/description/
-------------------------------------------------------

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?


*
*/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char sch[] = s.toCharArray();
        char tch[] = t.toCharArray();
        int count[] = new int[26];
        for(char ch: sch){
            count[ch-'a']++;
        }
        for(char ch: tch){
            count[ch-'a']--;
        }
        for(int i: count){
            if(i!=0)return false;
        }
        return true;
    }
}
