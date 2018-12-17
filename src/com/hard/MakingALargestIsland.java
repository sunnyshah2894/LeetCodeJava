/**
 *		
 */
package com.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
https://leetcode.com/problems/making-a-large-island/description/
-------------------------------------------------------

In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).

Example 1:

Input: [[1, 0], [0, 1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

Example 2:

Input: [[1, 1], [1, 0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.

Example 3:

Input: [[1, 1], [1, 1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.

 

Notes:

    1 <= grid.length = grid[0].length <= 50.
    0 <= grid[i][j] <= 1.

*
*/
public class MakingALargestIsland {
    public int largestIsland(int[][] grid) {
        
        if( grid.length == 0 )
            return 0;
        
        int answer = 0 ;
        Map<Integer,Integer> hs = new HashMap<>();
        Map<String,Integer> mapPointToInt = new HashMap<>();
        
        answer = Math.max( answer,findLargest(grid,hs,mapPointToInt) );
        
        for( int i=0 ; i<grid.length ; i++ ){
            for( int j=0 ; j<grid[0].length ; j++ ){
                if( grid[i][j] == 0 ){
                    
                    Set<Integer> hst = new HashSet<>();
                    
                    if( i-1>=0 && grid[i-1][j] == 1 )
                        hst.add(mapPointToInt.get( (i-1)+","+j )) ;
                    if( j-1>=0 && grid[i][j-1] == 1 )
                        hst.add(mapPointToInt.get( i+","+(j-1) )) ;
                    if( i+1<grid.length && grid[i+1][j] == 1 )
                        hst.add(mapPointToInt.get( (i+1)+","+j )) ;
                    if( j+1<grid[0].length && grid[i][j+1] == 1 )
                        hst.add(mapPointToInt.get( i+","+(j+1) )) ;
                    
                    int tempAnswer = 1;
                    for( int num:hst ){
                        tempAnswer += hs.get(num);
                    }
                    answer = Math.max( answer , tempAnswer );
                    
                }
            }
        }
        
        return answer;
        
    }
    
    public int findLargest( int[][] grid, Map<Integer,Integer> hs , Map<String,Integer> mapPointToInt ){
        
        int answer = 0 ;
        int index = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for( int i=0 ; i<grid.length ; i++ ){
            for( int j=0 ; j<grid[0].length ; j++ ){
                if( !visited[i][j] ){
                    answer = dfs( i,j,grid,visited,mapPointToInt,index );
                    hs.put( index , answer );
                    index++;
                }
            }
        }
        return answer;
    }
    
    public int dfs( int i, int j, int grid[][] , boolean visited[][] , Map<String,Integer> mapPointToInt , int index ){
        
        if( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 || visited[i][j] )
            return 0;
       
        int count = 1 ;
        visited[i][j] = true;
        mapPointToInt.put( i+","+j , index );
        count += dfs( i-1,j,grid,visited,mapPointToInt,index );
        count += dfs( i,j-1,grid,visited,mapPointToInt,index );
        count += dfs( i+1,j,grid,visited,mapPointToInt,index );
        count += dfs( i,j+1,grid,visited,mapPointToInt,index );
        
        return count;
    }
    
}
