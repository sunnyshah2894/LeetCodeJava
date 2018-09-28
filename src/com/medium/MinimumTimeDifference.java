/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.Collections;
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
https://leetcode.com/problems/minimum-time-difference/description/
-------------------------------------------------------

Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

Example 1:

Input: ["23:59","00:00"]
Output: 1

Note:

    The number of time points in the given list is at least 2 and won't exceed 20000.
    The input time is legal and ranges from 00:00 to 23:59.

*
*/
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        
        List<Integer> ls = new ArrayList<>();
        
        for( String t : timePoints ){
            String str[] = t.split(":");
            int hrs = Integer.parseInt( str[0] );
            int mins = Integer.parseInt( str[1] );
            ls.add( hrs*60 + mins );
        }
        
        Collections.sort( ls );
        
        int minDistance = Integer.MAX_VALUE;
        
        for( int i=1 ; i<ls.size() ; i++ ){
            minDistance = Math.min( minDistance,ls.get(i) - ls.get(i-1) );
        }
        minDistance = Math.min( minDistance, 1440 - ls.get( ls.size()-1 ) + ls.get(0)   );
        
        
        return minDistance;
    }
}
