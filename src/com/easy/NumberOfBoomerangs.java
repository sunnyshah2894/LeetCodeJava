/**
 *		
 */
package com.easy;

import java.util.HashMap;
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
https://leetcode.com/problems/number-of-boomerangs/description/
-------------------------------------------------------

Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:

Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]


*
*/
public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
        
        int row = points.length;
        Map<Integer,Integer> sumCount = new HashMap<>();
        int answer = 0;
        
        for( int i=0; i<row ; i++ ){
            sumCount.clear();
            for( int j=0; j<row ; j++ ){
                if( j==i )continue;
                int xdiff = Math.abs(points[i][0] - points[j][0]);
                int ydiff = Math.abs(points[i][1] - points[j][1]);
                int distance = xdiff*xdiff + ydiff*ydiff;
                int currCount = sumCount.getOrDefault( distance , 0 );
                answer += currCount;
                sumCount.put( distance, currCount+1 );
            }
        }
        return answer*2;
        
    }
}
