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
https://leetcode.com/problems/single-element-in-a-sorted-array/description/
-------------------------------------------------------

Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10

Note: Your solution should run in O(log n) time and O(1) space.

*
*/
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        
        int low = 0; 
        int high = nums.length - 1;
        while( low<high ){
         
            int mid = (low+high)/2;
            
            if( mid>0 && mid<nums.length-1 && nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1] ){
                return nums[mid];
            }
            else if( mid == nums.length-1 && nums[mid] != nums[mid-1]  ){
                return nums[mid];
            }
            else if( mid==0 && nums[mid] != nums[mid+1] )
                return nums[mid];
            
            if( mid%2 == 0 ){ //even index, then it shoud start here
                if( mid>0 && nums[mid-1] < nums[mid] ){ // it is in the right side
                    low = mid+1;
                }
                else   // it is on the left side
                    high = mid;
            }
            else{
                if( mid>0 && nums[mid-1] < nums[mid] ){ // it is in the right side
                    high = mid;
                }
                else   // it is on the left side
                    low = mid+1;
            }
            
        }
        return nums[low];
    }
}
