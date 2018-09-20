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
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
-------------------------------------------------------

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:

Input: 1->1->1->2->3
Output: 2->3

*
*/
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        if( head == null || head.next == null ) return head;
        ListNode dummy = new ListNode(0);
        ListNode dummyDup = dummy;
        ListNode prev = head;
        ListNode curr = head.next;
        int currVal = prev.val;
        int count = 1;
        while( curr != null ){
            if( currVal != curr.val ){
                if( count == 1 ){
                    dummy.next = prev;
                    dummy = dummy.next;
                }  
                prev = curr;
                count = 1;
                currVal = curr.val;
            }
            else{
                count++;
            }
            curr = curr.next;
        }
        if( count == 1 ){
            dummy.next = prev;
        }
        else dummy.next = null;
        return dummyDup.next;   
    }
}
