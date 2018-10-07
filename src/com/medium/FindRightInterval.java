/**
 *		
 */
package com.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.medium.MergeIntervals.Interval;

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
https://leetcode.com/problems/find-right-interval/description/
-------------------------------------------------------

Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:

    You may assume the interval's end point is always bigger than its start point.
    You may assume none of these intervals have the same start point.

Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.

Example 2:

Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.

Example 3:

Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.


*
*/
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        
        int nums[] = new int[intervals.length];
        Map<Integer,Integer> hs = new HashMap<>();
        int result[] = new int[intervals.length];
        
        for( int i=0 ; i<intervals.length ; i++ ){
            nums[i] = intervals[i].start;
            hs.put( intervals[i].start,i );
        }
        Arrays.sort(nums);
        
        for( int i=0 ; i<intervals.length ; i++ ){
            int index = lowerBound( nums,intervals[i].end );
            if( index<0 || index>=intervals.length ){
                result[i] = -1;
            }
            else result[i] = hs.get(nums[index]);
        }
        
        return result;
    }
    
    int lowerBound( int nums[],int target ){
        int low = 0;
		int high = nums.length;
		while (low < high) {
			final int mid = (low + high) / 2;
            if( target == nums[mid] )
                return mid;
			else if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
    }
    
}
