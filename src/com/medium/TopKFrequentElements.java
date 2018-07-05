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
	https://github.com/sunnyshah28
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/top-k-frequent-elements/description/
-------------------------------------------------------

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


*
*/
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer> ls[] = new List[nums.length+1];
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        
        for( int i: nums ){
            int count = mp.getOrDefault(i,0);
            mp.put(i,count+1);
        }
       
        for( int i: mp.keySet() ){
            int freq = mp.get(i);
            if( ls[freq] == null ){
                ls[freq] = new ArrayList<>();
            }
            ls[freq].add( i );
        }
        
        for( int i=nums.length ; i>0 ; i-- ){
            if( ls[i] != null )
                for( int j: ls[i] ){
                    if( k<=0 )return result;
                    result.add( j );
                    k--;
                }   
        }
        return result;
        
    }
}
