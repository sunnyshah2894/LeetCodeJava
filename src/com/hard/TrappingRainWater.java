/**
 *		
 */
package com.hard;

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
https://leetcode.com/problems/trapping-rain-water/description/
-------------------------------------------------------

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

*
*/
public class TrappingRainWater {
    public int trap(int[] height) {
        
        int result = 0; 
        int currBar = 0;
        
        while( true ){
            
            int waterLodged = 0;
            int currIndex = currBar+1;
            while( currIndex<height.length && height[currIndex] < height[currBar] ){
                waterLodged += height[currBar] - height[currIndex];
                currIndex++;
            }
            
            if( currIndex >= height.length )break;
            currBar = currIndex;
            result += waterLodged;
            
        }
        
        if( currBar<height.length && height[currBar] != height[height.length-1] ){
            
            int barTill = currBar;
            currBar = height.length-1;
            while( true ){
            
                int waterLodged = 0;
                int currIndex = currBar-1;
                while( currIndex >= barTill && height[currIndex] < height[currBar] ){
                    waterLodged += height[currBar] - height[currIndex];
                    currIndex--;
                }
                if( currIndex < barTill )break;
                currBar = currIndex;
                result += waterLodged;

            }
            
        }
        return result;
    }
}
