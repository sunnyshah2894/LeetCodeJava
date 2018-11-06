/**
 *		
 */
package com.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
https://leetcode.com/problems/brick-wall/description/
-------------------------------------------------------

There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Example:

Input: 
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
Output: 2
Explanation: 

Note:

    The width sum of bricks in different rows are the same and won't exceed INT_MAX.
    The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.

*
*/
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int startVal = 0 ;
        int endVal = 0;
        for( int i : wall.get(0) )
            endVal += i;

        Map<Integer,Integer> hs = new HashMap<>();
        for( int i=0 ; i<wall.size() ; i++ ){
            int sum = 0;
            for( int j=0 ; j<wall.get(i).size() ; j++ ){
                int val = wall.get(i).get(j);
                sum += val;
                hs.put( sum , hs.getOrDefault(sum,0) + 1 );
            }
        }
        if( hs.containsKey( startVal ) )
            hs.remove( startVal );
        if( hs.containsKey( endVal ) )
            hs.remove( endVal );
        
        int maxCount = 0 ;
        for( int k : hs.keySet() ){
            if( maxCount < hs.get( k ) )
                maxCount = hs.get(k);
        }
        
        return wall.size() - maxCount;
        
    }
}
