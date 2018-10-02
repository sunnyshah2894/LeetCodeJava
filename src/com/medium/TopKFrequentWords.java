/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
https://leetcode.com/problems/top-k-frequent-words/description/
-------------------------------------------------------

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:

Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:

Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Input words contain only lowercase letters.

Follow up:

    Try to solve it in O(n log k) time and O(n) extra space.

*
*/
public class TopKFrequentWords {
    class MyWord{
        String word;
        int count;
    }
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String,Integer> hs = new HashMap<>();
        for( String word : words )
            hs.put( word,hs.getOrDefault(word,0)+1 );
        
        PriorityQueue<MyWord> q = new PriorityQueue<>( k,new Comparator<MyWord>(){
            public int compare( MyWord a , MyWord b ){
                if( a.count == b.count )
                    return a.word.compareTo(b.word);
                else 
                    return b.count-a.count;
            }
        });
        
        for( String word : hs.keySet() ){
            MyWord temp = new MyWord();
            temp.word = word;
            temp.count = hs.get(word);
            q.offer( temp );
        }
        List<String> result = new ArrayList<>();
        for( int i=0 ; i<k ; i++ ){
            result.add( q.poll().word );
        }
        return result;
        
    }
}
