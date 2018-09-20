/**
 *		
 */
package com.medium;

import java.util.ArrayList;
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
https://leetcode.com/problems/daily-temperatures/description/
-------------------------------------------------------

Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]. 

*
*/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        
        List<Integer> occurences[] = new List[71];
        for( int i=0 ; i<71 ; i++ )
            occurences[i] = new ArrayList<>();
        
        for( int i=0 ; i<temperatures.length ; i++ )
            occurences[temperatures[i]-30].add(i);
        
        int result[] = new int[temperatures.length];
        for( int i=0 ; i<temperatures.length ; i++ ){
            int minIndex = temperatures.length ; 
            for( int j=temperatures[i]-30+1 ; j<71 ; j++ ){
                
                if( occurences[j].size() == 0 )
                    continue;
                
                int index = lowerBound( occurences[j],occurences[j].size(),i );
                if( index == 0 && occurences[j].get(0) > i )
                    minIndex = Math.min( minIndex,occurences[j].get(0)-i );
                if( index != occurences[j].size() )
                    minIndex = Math.min( minIndex,occurences[j].get(index)-i );
                
            }
            if( minIndex == temperatures.length )
                minIndex = 0;
            result[i] = minIndex;
        }
        return result;
        
    }
    
    /*
	 * -If searched element doesn't exist function returns index of first
	    element which is bigger than searched value.
     * -If searched element is bigger than any array element function returns first index after last
	    element.
     * -If searched element is lower than any array element
        function returns index of first element.
     * -If there are many values
	    equals searched value function returns first occurrence.<br>
	 */
    public static int lowerBound(List<Integer> array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array.get(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
