/**
 *		
 */
package com.medium;

import java.util.Arrays;
import java.util.Comparator;

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
https://leetcode.com/problems/non-overlapping-intervals/description/
-------------------------------------------------------

Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:

    You may assume the interval's end point is always bigger than its start point.
    Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

Example 1:

Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

Example 2:

Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

Example 3:

Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

*
*/
public class EraseOverlapIntervals {
	
	class Interval{
		int start;
		int end;
	}
    public int eraseOverlapIntervals(Interval[] intervals) {
        
        Arrays.sort( intervals, new Comparator<Interval>(){
            public int compare( Interval a, Interval b ){
                return a.end - b.end;
            }
        });
        
        int count = 0 ;
        int currLast = Integer.MIN_VALUE;
        for( int i=0 ; i<intervals.length ; i++ ){
            if( intervals[i].start >= currLast ){
                currLast = intervals[i].end;
                count++;
            }
        }
        return intervals.length-count;
        
    }
}
