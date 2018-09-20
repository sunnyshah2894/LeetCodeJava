/**
 *		
 */
package com.medium;

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
https://leetcode.com/problems/mirror-reflection/description/
-------------------------------------------------------

There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.

The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.

Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)
 
Example 1:

Input: p = 2, q = 1
Output: 2
Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.


Note:

    1 <= p <= 1000
    0 <= q <= p


*
*/
public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        
        for( int i=1 ; i<=q ; i++ ){
            int dist = (i*p);
            if( i%2 != 0 ){ //odd 
                if( dist%q == 0 ){
                    if( ((dist)/q)%2 == 0 )return 2;
                    else return 1;
                }
            }
            else{ //even
                if( dist%q == 0 ){
                    if( dist%2 == 0 ){
                        if( ((dist)/q)%2 != 0 )return 0;
                    }
                }
            }
        }
        return -1; 
    }
}
