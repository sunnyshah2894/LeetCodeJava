/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/longest-repeating-character-replacement/description/
-------------------------------------------------------

Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

*
*/
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        char ch[] = s.toCharArray();
        int count[] = new int[26];
        
        int maxCountTillNow = 0, start=0, answer=0;
        for( int end=0 ; end<s.length() ; end++ ){
            count[ch[end]-'A']++;
            maxCountTillNow = Math.max( maxCountTillNow,count[ch[end]-'A'] );
            while( end-start+1-maxCountTillNow > k ){
                count[ch[start]-'A']--;
                start++;
            }
            answer = Math.max( end-start+1,answer );
        }
        return answer;
    }
}
