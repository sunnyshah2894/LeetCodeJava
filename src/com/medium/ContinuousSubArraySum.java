/**
 *		
 */
package com.medium;

import java.util.HashMap;
import java.util.Map;

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
https://leetcode.com/problems/continuous-subarray-sum/description/
-------------------------------------------------------

Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

Note:

    The length of the array won't exceed 10,000.
    You may assume the sum of all the numbers is in the range of a signed 32-bit integer.


*
*/
public class ContinuousSubArraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if( n==0 ) return false;
        else if( n==1 ) return false;
        int sum = 0;
        if( k!=0 ){
            for( int i=0; i<n ; i++ ){
                nums[i] %= k;
            }
        }
            
        Map<Integer,Integer> counter = new HashMap<>();
        counter.put( 0,-1 );
        if(nums[0]!=0)
            counter.put( nums[0] , 0 );
        sum = nums[0];
        int answer = 0 ;
        for( int i=1; i<n ; i++ ){
            if( k!=0 ){
                sum = (sum+nums[i])%k;
                if( counter.containsKey( (sum)%k ) && i-counter.get( (sum)%k ) > 1 ){
                    return true;
                }
            }
            else{
                sum = (sum+nums[i]);
                if( counter.containsKey( (sum) ) && i-counter.get(sum) > 1 ){
                    return true;
                }
            }
            if( !counter.containsKey(sum) )
                counter.put( sum , i );
        }
        return false;
    }
}
