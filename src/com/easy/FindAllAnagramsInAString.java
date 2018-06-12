/**
 *		
 */
package com.easy;

import java.util.ArrayList;
import java.util.List;

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
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
-------------------------------------------------------


Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


*
*/
public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        int pCount[] = new int[26] ;
        int sCount[] = new int[26] ;
        char sch[] = s.toCharArray() ;
        char pch[] = p.toCharArray() ; 
        
        for( char ch: pch ){
            pCount[ ch - 'a' ]++;
        }
        
        for( int i=0 ; i<=s.length()-p.length() ; i++ ){
            if( i==0 )
                for( int j=0; j<p.length(); j++)
                    sCount[sch[j]-'a']++;
            else{
                sCount[sch[i-1]-'a']--;
                sCount[sch[i+p.length()-1]-'a']++;
            }
            boolean equal = true;
            for( int j=0; j<26 ; j++)
                if( sCount[j] != pCount[j] )equal = false;
            
            if(equal) ls.add(i);
        }
        return ls;
    }
}
