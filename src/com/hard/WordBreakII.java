/**
 *		
 */
package com.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
https://leetcode.com/problems/word-break-ii/description/
-------------------------------------------------------

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

*
*/
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> hst = new HashSet<>();
        for( String str : wordDict )
            hst.add( str );
        
        
        return solve( hst, s, 0, new HashMap<String, List<String>>() );
        
    }
    
    public List<String> solve( Set<String> hst, String s, int index, Map<String,List<String>> map){
        
        String nextStr = s.substring( index, s.length() );
        
        if( map.containsKey( nextStr ) )
            return map.get(nextStr);
        
        if( index >= s.length() )
            return null;
        
        List<String> resultCurr = new ArrayList<>();
        
        for( int j=index+1 ; j<s.length()+1 ; j++ ){
            
            String curr_word = s.substring(index,j);
            if( hst.contains( curr_word ) ){
                if( j == s.length() )
                    resultCurr.add(curr_word);
                List<String> temp = solve( hst,s,j,map );
                if( temp == null )continue;
                for( String str: temp )
                    resultCurr.add( curr_word + " " + str );
            }
        }
        map.put( nextStr,resultCurr );
        return resultCurr;
    }
}
