/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
https://leetcode.com/contest/weekly-contest-98/problems/find-and-replace-pattern/
-------------------------------------------------------

You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.

 

Note:

    1 <= words.length <= 50
    1 <= pattern.length = words[i].length <= 20

*
*/
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> result = new ArrayList<>();
        Map<Integer,Integer> myMap = new HashMap<>();
        
        for( int i=0 ; i<words.length ; i++ ){
            
            if( words[i].length() != pattern.length()  )
                continue;
            else{
                
                myMap.clear();
                boolean flag = true;
                boolean used[] = new boolean[300];
                char mapped[] = new char[300]; 
                boolean isMapped[] = new boolean[300];
                    
                for( int j=0 ; j<pattern.length() ; j++ ){
                    
                    if( isMapped[words[i].charAt(j)] ){
                        if( mapped[words[i].charAt(j)] != pattern.charAt(j) ){
                            flag = false;
                            break;
                        }
                    }
                    else{
                        
                        if( used[pattern.charAt(j)] ){
                            flag = false;
                            break;
                        }
                        else{
                            mapped[words[i].charAt(j)] = pattern.charAt(j);
                            isMapped[words[i].charAt(j)] = true;
                            used[pattern.charAt(j)] = true;
                        }
                        
                    }
                    
                }
                if( flag )
                    result.add(words[i]);
                
            }
            
        }
        return result;
        
    }
    
}
