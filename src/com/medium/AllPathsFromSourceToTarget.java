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
https://leetcode.com/problems/all-paths-from-source-to-target/description/
-------------------------------------------------------

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Note:

    The number of nodes in the graph will be in the range [2, 15].
    You can print different paths in any order, but you should keep the order of nodes inside one path.

*
*/
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int n = graph.length-1;
        List<List<Integer>> result = new ArrayList<>();
        solve( 0,n,graph,result,new ArrayList<Integer>() );
        
        return result;
  
    }
    
    public void solve( int start, int last, int[][] graph, List<List<Integer>> result, List<Integer> currPath ){
        
        if( start == last ){
            List<Integer> temp = new ArrayList<>(currPath);
            temp.add( start );
            result.add(temp);
            return ;
        }
        currPath.add( start );
        for( int next: graph[start] ){
            
            solve( next,last,graph,result,currPath );
            
        }
        currPath.remove(currPath.size()-1);
        
    }
    
}
