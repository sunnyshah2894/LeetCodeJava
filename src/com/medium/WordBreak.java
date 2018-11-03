/**
 *		
 */
package com.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
https://leetcode.com/problems/word-break/description/
-------------------------------------------------------

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

*
*/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean dp[] = new boolean[ s.length() + 1 ];
        dp[0] = true;
        Set<String> hst = new HashSet<>();
        for( String st: wordDict )
            hst.add( st );
        
        for( int i=0 ; i<s.length()+1 ; i++ ){
            for( int j=0 ; j<=i ; j++  ){
                if( dp[j] && hst.contains(s.substring( j,i )) ){
                    dp[i] = true;
                }
                
            }
        }
        
        return dp[s.length()];
        
    }
}
