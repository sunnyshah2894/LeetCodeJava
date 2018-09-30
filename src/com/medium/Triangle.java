/**
 *		
 */
package com.medium;

import java.util.Arrays;
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
https://leetcode.com/problems/triangle/description/
-------------------------------------------------------

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*
*/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int dp[] = new int[triangle.size()+1];
        Arrays.fill( dp, Integer.MAX_VALUE );
        dp[0] = 0;
        int answer = Integer.MAX_VALUE;
        for( List<Integer> row: triangle ){
            
            answer = Integer.MAX_VALUE;
            for( int i=row.size()-1 ; i>=0 ; i-- ){
                int temp = row.get(i);
                if( i==0 )
                    dp[i] = dp[0] + temp;
                else
                    dp[i] = Math.min( dp[i-1], dp[i] ) + temp;
                answer = Math.min(answer,dp[i]);
            }
            
        }
        
        return answer;
        
    }
}
