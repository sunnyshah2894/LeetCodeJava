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
	https://github.com/sunnyshah2894
	https://leetcode.com/sunnyshah28
	https://www.linkedin.com/in/sunnyshah28
 *
 *
-------------------------------------------------------
https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
-------------------------------------------------------

There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

Now given all the cities and fights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.

Note:

    The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
    The size of flights will be in range [0, n * (n - 1) / 2].
    The format of each flight will be (src, dst, price).
    The price of each flight will be in the range [1, 10000].
    k is in the range of [0, n - 1].
    There will not be any duplicated flights or self cycles.


*
*/
public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        long minWeight[][] = new long[2][n];
        int size = flights.length;
        
        Arrays.fill(minWeight[0],Integer.MAX_VALUE);
        Arrays.fill(minWeight[1],Integer.MAX_VALUE);
        minWeight[0][src] = 0;
        minWeight[1][src] = 0;
        
        for( int i=0; i<=K ; i++ ){
            for( int j=0 ; j<size ; j++ ){
                int source = flights[j][0] , dest = flights[j][1] , cost = flights[j][2];
                minWeight[1][dest] = Math.min( minWeight[1][dest], minWeight[0][source] + cost );
            }
            for( int j=0 ; j<n ; j++ ){
                minWeight[0][j] = minWeight[1][j];
            }
        }
        if( minWeight[0][dst] >= Integer.MAX_VALUE )return -1;
        return (int)minWeight[0][dst];
        
    }
}
