/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
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
https://leetcode.com/problems/group-anagrams/description/
-------------------------------------------------------

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.


*
*/
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Integer> counter = new HashMap<>();
        List<List<String>> ls = new ArrayList<>();
        int index = 0 ;
        int indexOfList[] = new int[strs.length];
        int i = 0  ;
        for(String s: strs){
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            if( !counter.containsKey(new String(ch)) ){
                counter.put(new String(ch) , index++);
                indexOfList[i] = index - 1 ;
            }
            else{
                indexOfList[i] = counter.get(new String(ch)) ;
            }
            i++;
        }
        
        for( int j=0; j<index ; j++ ){
            ls.add( new ArrayList<String>() );
        }
        for( int j=0 ; j<strs.length ; j++ ){
            ls.get( indexOfList[j] ).add(strs[j]);
        }
        return ls;
        
    }
}
