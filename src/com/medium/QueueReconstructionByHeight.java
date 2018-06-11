/**
 *		
 */
package com.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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
https://leetcode.com/problems/queue-reconstruction-by-height/description/
-------------------------------------------------------

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]



*
*/
public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?o2[0]-o1[0]:o1[1]-o2[1];
           }
        });
        List<int []> ls = new LinkedList<>();
        for( int i=0; i<people.length; i++ ){
            ls.add( people[i][1] , people[i] );
        }
        return ls.toArray(new int[0][]);
        
    }
}
