/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
https://leetcode.com/problems/sort-characters-by-frequency/description/
-------------------------------------------------------

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


*
*/
public class SortCharactersByFrequency {
	
	public String frequencySort(String s){
		
		char sch[] = s.toCharArray();
		int count[] = new int[260];
		
		for( char ch: sch )
			count[ch]++;
		
		int index = 0;
		while( index != s.length() ){
			
			int maxValue = 0;
			int maxIndex = -1;
			for( int i=0 ; i<260 ; i++ ){
				if( maxValue < count[i] ){
					maxValue = count[i];
					maxIndex = i;
				}
			}
			while(maxValue-->0)
				sch[index++] = (char)maxIndex;
			
			count[maxIndex] = 0;
			
		}
		return new String(sch);
	}
	
	public String frequencySortUsingMap(String s) {
        
        char sch[] = s.toCharArray();
        Map<Character,Integer> mp = new HashMap<>();
        
        for(char ch: sch){
            int count = mp.getOrDefault(ch,0);
            mp.put(ch,count+1);
        }
        List<Map.Entry<Character, Integer>> ls = sortHashMapByValue(mp);
        int index = 0 ;
        for( Map.Entry<Character, Integer> entry: ls ){
            for( int i=0 ; i<entry.getValue() ; i++ ){
                sch[index++] = entry.getKey();
            }
        }
        return new String(sch);
        
    }
    public List<Map.Entry<Character, Integer>> sortHashMapByValue(Map<Character,Integer> map ){
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(set);
        Collections.sort( list, 
            new Comparator<Map.Entry<Character, Integer>>()
            {
                public int compare( Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2 )
                {
                    return (o2.getValue()).compareTo( o1.getValue() );
                }
            } 
        );
        return list;
    }
    
}
