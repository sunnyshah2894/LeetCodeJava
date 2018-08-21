/**
 *		
 */
package com.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
https://leetcode.com/problems/most-common-word/description/
-------------------------------------------------------

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.

 

Note:

    1 <= paragraph.length <= 1000.
    1 <= banned.length <= 100.
    1 <= banned[i].length <= 10.
    The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
    paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
    Different words in paragraph are always separated by a space.
    There are no hyphens or hyphenated words.
    Words only consist of letters, never apostrophes or other punctuation symbols.


*
*/
public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {

        char pch[] = paragraph.toCharArray();
        
        for( int i=0 ; i<pch.length ; i++ )
            if( pch[i] == '!' || pch[i] == '?' || pch[i] == '\'' || pch[i] == ';' || pch[i] == '.' || pch[i] == ',' )
                pch[i] = ' ';
        
        paragraph = new String(pch);
        
        String dict[] = paragraph.split("\\s+");
        Map<String, Integer> dictCount = new HashMap<>();
        Set<String> bannedWords = new HashSet<>();
        
        for( String word: banned ){
            bannedWords.add(word);
        }
        
        for( int i=0; i<dict.length; i++ ){
            dict[i] = dict[i].toLowerCase();
            if( !bannedWords.contains(dict[i]) )
                dictCount.put( dict[i] , dictCount.getOrDefault( dict[i] , 0 ) + 1 );
        }
        
        String mostFreq = "";
        int maxCount = 0;
        for( String word: dictCount.keySet() ){
            if( dictCount.get(word) > maxCount ){
                maxCount = dictCount.get(word);
                mostFreq = word;
            }
        }
        return mostFreq;
        
    }
}
