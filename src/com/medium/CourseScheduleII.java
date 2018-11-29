/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
https://leetcode.com/problems/course-schedule-ii/description/
-------------------------------------------------------

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .

Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.

*
*/
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer> result = new ArrayList<>();
        List<Integer> parent[] = new List[numCourses+1];
        int countOutDegree[] = new int[numCourses+1];
        
        for( int i=0 ; i<numCourses+1 ; i++ ){
            parent[i] = new ArrayList<Integer>();
        }
        
        for( int i=0 ; i<prerequisites.length ; i++ ){
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
          
            parent[x].add(y);
            
            countOutDegree[y]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for( int i=0 ; i<numCourses ; i++ ){
            if( countOutDegree[i] == 0 ){
                q.offer( i );
            }
        }
        
        while( !q.isEmpty() ){
            int curr = q.poll();
            
            for( int p : parent[curr] ){
                countOutDegree[p]--;
                if( countOutDegree[p] == 0 ){
                    q.offer(p);
                }
            }
            result.add( curr );
            
        }
        
        if( result.size() != numCourses )
            return new int[0];
        int resultArray[] = new int[result.size()];
        int index = 0;
        for( int i=result.size()-1 ; i>=0 ; i-- ){
            resultArray[index++] = result.get(i);
        }
        return resultArray;
        
    }
}
