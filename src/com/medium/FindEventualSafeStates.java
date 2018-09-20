/**
 *		
 */
package com.medium;

import java.util.ArrayList;
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
https://leetcode.com/problems/find-eventual-safe-states/description/
-------------------------------------------------------

In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.

Illustration of graph

Note:

    graph will have length at most 10000.
    The number of edges in the graph will not exceed 32000.
    Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].

*
*/
public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        boolean visited[] = new boolean[graph.length];
        boolean isSafe[] = new boolean[graph.length];
        boolean currOpen[] = new boolean[graph.length];
        Arrays.fill( isSafe,true );
        List<Integer> ls = new ArrayList<>();
        for( int i=0 ; i<graph.length ; i++ ){
            if( !visited[i] )
                solution( i,ls,visited,isSafe,graph,currOpen );
        }
        for( int i=0 ; i<isSafe.length ; i++ ){
            if( isSafe[i] )
                ls.add(i);
        }
        return ls;
        
    }
    boolean solution( int node, List<Integer> ls, boolean visited[],boolean isSafe[], int[][] graph, boolean currOpen[] ){
        if( graph[node].length == 0 ){
            isSafe[node] = true;
            return true;
        }
        if( visited[node] ){
            return isSafe[node];
        }
        visited[node] = true;
        currOpen[node] = true;
        boolean safe = true;
        
        for( int i : graph[node] ){ 
            if( currOpen[i] ){
                isSafe[i] = false;
                safe = false;
            }
            safe = safe && solution( i,ls,visited,isSafe,graph,currOpen );
        }

        currOpen[node] = false;
        isSafe[node] = isSafe[node] && safe;
        return isSafe[node];
        
    }
}
