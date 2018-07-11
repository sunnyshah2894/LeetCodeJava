/**
 *		
 */
package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
https://leetcode.com/problems/subsets-ii/description/
-------------------------------------------------------

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


*
*/
public class SubSetsII {
	static class myArray{
        List<Integer> ar;

        public myArray(){
            ar = new ArrayList<>();
        }

        public int hashCode() {
            // Collections.sort(ar);
            int hashCode = 1;
            for (int e : this.ar )
                hashCode = 31*hashCode + e;
            return hashCode;
        }
        @Override

        public boolean equals(Object obj) {

            if (obj == null) return false;
            if (!(obj instanceof myArray))
                return false;
            else{
                myArray otherObj = (myArray) obj;
                if( otherObj.ar.size() != this.ar.size() )
                    return false;
                // Collections.sort( otherObj.ar );
                // Collections.sort( this.ar );
                for( int i=0 ; i<otherObj.ar.size() ; i++ ){
                    if( otherObj.ar.get(i) != ar.get(i) )
                        return false;
                }
            }
            return true;
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //Set<myArray> result = new HashSet<>();
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> resultList = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        Arrays.sort(nums);
        derivePowerSet( nums , visited , result, 0);
        
        for( List<Integer> a: result ){
            resultList.add(a);
        }
        
        return resultList;
    }
    
    void derivePowerSet( int[] nums, boolean visited[] , Set<List<Integer>> powerSet , int index ){
        
        if( nums.length == 0 ){
            powerSet.add( new ArrayList<Integer>() );
            return;
        }
        visited[index] = true;
        if( index == nums.length - 1 ){
            List<Integer> ls1 = new ArrayList<>();
            for( int i=0 ; i<nums.length ; i++ ){
                if( visited[ i ] )
                    ls1.add( nums[i] );
            }
            powerSet.add( ls1 );
            
            visited[index] = false;
            List<Integer> ls2 = new ArrayList<>();
            for( int i=0 ; i<nums.length ; i++ ){
                if( visited[ i ] )
                    ls2.add( nums[i] );
            }
            powerSet.add( ls2 );
            return;
        }
        
        derivePowerSet( nums, visited, powerSet, index+1 );
        
        visited[index] = false;
        derivePowerSet( nums, visited, powerSet, index+1 );
        
    }
}
