/**
 *		
 */
package com.hard;

import java.util.HashMap;
import java.util.HashSet;
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
https://leetcode.com/problems/longest-consecutive-sequence/description/
-------------------------------------------------------

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

*
*/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        
        Map<Integer,Integer> count = new HashMap<>();
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int answer = 0 ;
        for( int i=0 ; i<nums.length ; i++ ){
            
            if( visited.contains(nums[i]) )
                continue;
            
            visited.add( nums[i] );
            boolean leftIsPresent = visited.contains( nums[i]-1 );
            boolean rightIsPresent = visited.contains( nums[i]+1 );
            
            left.put( nums[i],left.getOrDefault(nums[i],0) );
            right.put( nums[i],right.getOrDefault(nums[i],0) );
            
            if( leftIsPresent ){
                left.put( nums[i], Math.max(left.getOrDefault(nums[i],0), left.get(nums[i]-1)+1 ) );
            }
            if( rightIsPresent ){
                right.put( nums[i], Math.max(right.getOrDefault(nums[i],0), right.get(nums[i]+1)+1 ) );
            }
            
            int currCount = 1 + left.get(nums[i]) + right.get(nums[i]) ;
            
            if( leftIsPresent ){
                right.put( nums[i]-left.get(nums[i]), currCount-1 );
            }
            if( rightIsPresent ){
                left.put( nums[i]+right.get(nums[i]), currCount-1 );
            }
            
            
            
            count.put( nums[i], currCount);
            answer = Math.max( answer, currCount );
        }

        
        return answer;
        
    }
}
