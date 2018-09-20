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
https://leetcode.com/problems/partition-list/description/
-------------------------------------------------------

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

*
*/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        
        ListNode dummy = new ListNode( 0 );
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode lastSmaller = prev;
        while( curr!=null ){
            if( curr.val < x ){
                prev.next = curr.next;
                curr.next = lastSmaller.next;
                lastSmaller.next = curr;
                lastSmaller = curr;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
        
    }
}
