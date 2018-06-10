/**
 *		
 */
package com.hard;

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
https://leetcode.com/problems/median-of-two-sorted-arrays/description/
-------------------------------------------------------

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5




*
*/
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int mergedArray[] = new int[n+m],index = 0;
        int i = 0 , j = 0;
        int div = (n+m)/2;
        while( i < n || j < m){
            
            if( i < n && j < m && nums2[j] > nums1[i] ){   	// both num1 and num2 not finished and current num2 value is bigger
                mergedArray[index++] = nums1[i];
                i++;
            }
            else if( i < n && j < m ){						// both num1 and num2 not finished and current num1 value is bigger
                mergedArray[index++] = nums2[j] ;
                j++;
            }
            else if( i<n) {									// num1 is not finished and num2 is finished
                mergedArray[index++] = nums1[i];i++;
            }
            else{											// num2 is not finished and num1 is finished
                mergedArray[index++] = nums2[j];j++;
            }
            if( index > div)break;							// we have merged the arrays till the median, we do not want any more merging
            
        }
        
        if( (m+n)%2 == 1 ){ 			//odd sized merged array
            return mergedArray[div];
        }
        else{							//even sized merged array
            return (mergedArray[div-1]+mergedArray[div])/2.0;
        }
        
    }
}
