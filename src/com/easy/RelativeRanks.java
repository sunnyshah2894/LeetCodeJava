/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/relative-ranks/description/
-------------------------------------------------------

Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:

Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.

Note:

    N is a positive integer and won't exceed 10,000.
    All the scores of athletes are guaranteed to be unique.


*
*/
public class RelativeRanks {
	public String[] findRelativeRanks(int[] nums) {
        
        int scoreToIndexMapping[][] = new int[nums.length][2];
        int index = 0 ;
        for( int score: nums ){
            scoreToIndexMapping[index][0] = score;
            scoreToIndexMapping[index][1] = index;
            index++;
        }
        Arrays.sort( scoreToIndexMapping , new Comparator<int[]>(){
            public int compare( int[] a, int[] b ){
                return b[0] - a[0];
            }
        } );
        
        String answer[] = new String[nums.length];
        index = 0;
        for( int[] score: scoreToIndexMapping ){
            if( index == 0 )
                answer[score[1]] = "Gold Medal";
            else if( index == 1  )
                answer[score[1]] = "Silver Medal";
            else if( index == 2 )
                answer[score[1]] = "Bronze Medal";
            else
                answer[score[1]] = Integer.toString( index+1 );
            index++;
        }
        return answer;
        
    }
}
