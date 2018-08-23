/**
 *		
 */
package com.medium;

import java.util.Arrays;

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
https://leetcode.com/problems/boats-to-save-people/description/
-------------------------------------------------------

The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)

Note:

    1 <= people.length <= 50000
    1 <= people[i] <= limit <= 30000



*
*/
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        boolean visited[] = new boolean[people.length];
        int index = lowerBound( people,people.length,limit );
        int answer = people.length - index;
       
        for( int i=index-1,j=0 ; i>j ; i-- ){
            if( !visited[i] && !visited[j] && people[i] + people[j] <= limit ){
                visited[i] = true;
                visited[j] = true;
                answer++;
                j++;
            }
        }
        for( int i=index-1 ; i>=0 ; i-- ){
            if( !visited[i] )answer++;   
        }
        return answer;
        
    }
    
    public static int lowerBound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
