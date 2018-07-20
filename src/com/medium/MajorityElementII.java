/**
 *		
 */
package com.medium;

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
	https://github.com/sunnyshah28
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/majority-element-ii/description/
-------------------------------------------------------

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]

Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]


*
*/
public class MajorityElementII {
	public List<Integer> majorityElement2(int[] nums) {
        int count = nums.length/3 ;
        Map<Integer,Integer> counter = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        
        for( int num: nums ){
            
            int currCount = counter.getOrDefault( num,0 );
            counter.put( num,currCount+1 );
            
            if( (currCount+1) > count ) result.add( num );
            
        }
        return new ArrayList<>(result);
    }
}
