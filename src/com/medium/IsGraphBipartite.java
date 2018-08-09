/**
 *		
 */
package com.medium;

import java.util.HashSet;
import java.util.Set;

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
https://leetcode.com/problems/is-graph-bipartite/description/
-------------------------------------------------------

Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.

Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.

 

Note:

    graph will have length in range [1, 100].
    graph[i] will contain integers in range [0, graph.length - 1].
    graph[i] will not contain i or duplicate values.
    The graph is undirected: if any element j is in graph[i], then i will be in graph[j].



*
*/
public class IsGraphBipartite {
public boolean isBipartite(int[][] graph) {
        
        Set<Integer> hs1 = new HashSet<>();
        Set<Integer> hs2 = new HashSet<>();
        
        boolean visited[] = new boolean[graph.length];
        boolean flag = true;
        
        for( int i=0 ; i<graph.length ; i++ ){
            hs1.add(i);
            if( !visited[i] ) 
                flag = flag && isBipartite(i,graph,visited,hs1,hs2);  
        }
        return flag;
    }
    public boolean isBipartite( int node, int[][] graph , boolean visited[] , Set<Integer> hs1, Set<Integer> hs2 ){
        
        visited[node] = true;
        boolean putOthersIn2 = false;
        if( hs1.contains(node) ){
            putOthersIn2 = true;
        }
        boolean flag = true;
        for( int i=0 ; i<graph[node].length ; i++ ){
            if( visited[graph[node][i]] ){
                if( putOthersIn2 ){
                    if( hs1.contains(graph[node][i]) )return false;
                }
                else{
                    if( hs2.contains(graph[node][i]) )return false;
                }
            }
            else{
                
                if( putOthersIn2 ){
                    hs2.add( graph[node][i] );
                }
                else{
                    hs1.add( graph[node][i] );
                }
                flag = flag && isBipartite( graph[node][i],graph,visited,hs1,hs2 );
            }
            
        }
        return flag;
        
    }
}
