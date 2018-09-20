/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
https://leetcode.com/problems/minimum-height-trees/description/
-------------------------------------------------------

For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

Output: [1]

Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

Output: [3, 4]

Note:

    According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
    The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.




*
*/
public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][]edges ){
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
    
    public List<Integer> findMinHeightTreesMySol(int n, int[][] edges) {
        
        Map<Integer,List<Integer>> mp = new HashMap<>();
        List<Integer> ls[] = new ArrayList[n];
        Map<String,Integer> hs = new HashMap<>();
        
        for( int i=0 ; i<n ; i++ )
            ls[i] = new ArrayList<>();
        
        for( int i=0 ; i<edges.length ; i++ ){
            
            int x=edges[i][0];
            int y=edges[i][1];
            
            ls[x].add(y);
            ls[y].add(x);
            
        }
        int minHeight = Integer.MAX_VALUE;
        boolean visited[] = new boolean[n];
        for( int i=0 ; i<n ; i++ ){
            Arrays.fill(visited,false);
            int height = findHeight(i,0,minHeight,ls,visited,hs);
            if( mp.get( height ) == null ){
                mp.put( height, new ArrayList<>() );
            }
            mp.get(height).add(i);
            if( height<minHeight ){
                minHeight = height;
            }
        }
        return mp.get(minHeight);        
    }
    int findHeight( int node,int level,int mini,List<Integer> ls[],boolean visited[],Map<String,Integer> hs){
        visited[node] = true;
        if( level > mini )return level;
        String path = "" + node + "," ;
        if( ls[node].size() == 0 )return 0;
        else{
            int h = 0;
            for( int i : ls[node] ){
                if( !visited[i] ){
                    String t = path+i;
                    if( hs.containsKey(t) ){ 
                        h = Math.max( hs.get( t ) , h );
                    }
                    else{
                        int hi = findHeight(i,level+1,mini,ls,visited,hs);
                        h = Math.max( hi , h );
                        hs.put( t,hi );
                    }
                }
            }
            return 1+h;
        }
    }
}
