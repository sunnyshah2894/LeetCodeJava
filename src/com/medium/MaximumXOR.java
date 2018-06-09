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
https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
-------------------------------------------------------

Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.


*
*/
public class MaximumXOR {
    public int findMaximumXOR(int[] nums) {
    	/*
    	 * We check whether there is a pair that can make a particular target.
    	 * But Target can be anything like in binary 2 numbers may XOR to either 11011 or 11111 or 11100 . etc
    	 * So, we have to solve 2 problems now:
    	 * 	1) How to find the 2 pairs:
    	 * 			if A^B = target then target^A=B and target^B=A
    	 * 			so, we can make use of a HashSet. for A in the hashset, we should find (A^target) i.e. B. If present, then we have found the
    	 * 			max pair
    	 * 
    	 * 	2) How do we find the targets:
    	 * 			Lets say the max MSB(leftmost bit in binary) of all numbers is at ith position. Then target can be [1][(i-1)0s].
    	 * 			eg if i=7 target can be 10000000
    	 * 			If we find a pair with the above target, we should go on to check for 11000000
    	 * 			If we again find such a pair, we should target: 11100000
    	 * 			But now if we cant find a pair, we should use target: 11010000
    	 * 
    	 * 			And so on.
    	 * 
    	 * Overall complexity of the above algorithm is O(n*32) = O(n)
    	 * 
    	 * 
    	 */
    	
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
    
    /*
     * The above solution can be solved using a trie. Here instead of using a hashset to check if a number B to maximize XOR with A is
     * present or not, we use a trie and go on opposite direction with respect to bit representation of the number A.
     * 
     * Following optimization got me 94%:
     * We do not start from the root of the trie. And instead we start from the higest MSB encountered in the list of all numbers.
     * 
     * 
     */
    static class Trie{
        Trie children[];
        Trie(){
            children = new Trie[2];
        }
    }
    public int findMaximumXORUsingTrie(int[] nums) {
        
        Trie root = new Trie();
        int firstMSB = 31;
        for( int num: nums ){
            Trie currNode = root;
            for( int i=31; i>=0 ; i-- ){
                int bit = ((num&(1<<i))>0)?1:0;
                firstMSB = Math.max( firstMSB, i) ; 
                if( currNode.children[bit] == null ){
                    currNode.children[bit] = new Trie();
                }
                currNode = currNode.children[bit] ;
            }
       
        }
        int ans = 0 ;
        for( int num: nums ){
            Trie currNode = root;
            int currAns = 0;
            for( int i=firstMSB ; i>=0 ; i-- ){
                int bit = ((num&(1<<i))>0)?1:0;
                if( currNode.children[bit^1] != null ){
                    currAns += (1<<i);
                    currNode = currNode.children[bit^1];
                }
                else{
                    currNode = currNode.children[bit];
                }
            }
            ans = Math.max(currAns,ans);
        }
        
        return ans;
    }
}
