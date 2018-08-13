/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
-------------------------------------------------------
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2

Example 2:

Input: 1->1->2->3->3
Output: 1->2->3


*
*/
public class RemoveDuplicatesFromSortedList {
	 public ListNode deleteDuplicates(ListNode head) {
	        
	        if( head == null || head.next == null )return head;
	        ListNode prev = head;
	        ListNode curr = head;
	        int currVal = head.val;
	        while( curr != null ){
	            if( currVal != curr.val ){
	                prev.next = curr;
	                currVal = curr.val;
	                prev = curr;
	            }
	            curr = curr.next;
	        }
	        prev.next = null;
	        return head;
	    }
}
