/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
https://leetcode.com/problems/merge-intervals/description/
-------------------------------------------------------

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.



*
*/
public class MergeIntervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        
        Collections.sort( intervals, new Comparator<Interval>(){
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
			
		}) ;
        
        if( intervals.size() == 0 )return result;
        
        int start = intervals.get(0).start , end = intervals.get(0).end ; 
        Interval lastTemp = intervals.get(0);
        for( int i = 1 ; i<intervals.size() ; i++ ){
            Interval temp = intervals.get(i) ;
            if( temp.start > end ){  // start of new interval
                result.add( lastTemp );
                start = temp.start;
                end = temp.end;
            }
            else{
                end = Math.max(temp.end,end);
                temp.end = end ;
                temp.start = start;
            }
            lastTemp = temp;
        }
        result.add( lastTemp );
        
        return result;
    }
}
