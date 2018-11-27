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
https://leetcode.com/problems/random-pick-with-weight/description/
-------------------------------------------------------

Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

    1 <= w.length <= 10000
    1 <= w[i] <= 10^5
    pickIndex will be called at most 10000 times.

Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]

Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

*
*/
public class RandomPickWithWeight {

    long sum[];
    long comSum = 0;
    public RandomPickWithWeight(int[] w) {
        
        sum = new long[w.length];
        sum[0] = w[0];
        comSum = w[0];
        for( int i=1 ; i<w.length ; i++ ){
            sum[i] += sum[i-1] + w[i];
            comSum += w[i];
        }
        
    }
    
    public int pickIndex() {
        
        long rand = (long)(Math.random() * comSum) + 1;
        return lowerBound( rand );
        
    }
    
    public int lowerBound(long target){
        
        int low = 0 ;
        int high = sum.length ; 
        while( low<high ){
            int mid = (low + high)/2;
            if( target <= sum[mid] ){
                high = mid;
            }
            else 
                low = mid+1;
        }
        return low;
        
    }
}
