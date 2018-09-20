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
https://leetcode.com/problems/replace-words/description/
-------------------------------------------------------

In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Note:

    The input will only have lower-case letters.
    1 <= dict words number <= 1000
    1 <= sentence words number <= 1000
    1 <= root length <= 100
    1 <= sentence words length <= 1000



*
*/
public class RaplaceWords {
	public String replaceWords(List<String> dict, String sentence) {
        String str[] = sentence.trim().split(" ") ;
        
        Set<String> roots = new HashSet<>();
        for( String s: dict ){
            roots.add(s);
        }
        
        for( int i=0 ; i<str.length ; i++ ){
            for( int j=1 ; j<= Math.min(100,str[i].length()) ; j++ ){
                if( roots.contains( str[i].substring( 0,j ) ) ){
                    str[i] = str[i].substring( 0,j );
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for( String s: str ){
        	result.append(s);
            result.append(" ");
        }
        return result.toString().trim();
    }
}
