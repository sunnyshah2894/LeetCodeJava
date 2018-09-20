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
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
-------------------------------------------------------

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?


*
*/
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if( head == null )return head;
        
        int size = 0 ;
        ListNode currNode = head;
        while( currNode != null ){
            currNode = currNode.next;
            size++;
        }
        
        int indexToRemove = size - n + 1;
        int currIndex = 1;
        currNode = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while( currIndex != indexToRemove ){
            currIndex++;
            prev = currNode;
            currNode = prev.next;
        }
        
        prev.next = currNode.next;
        return dummy.next;
        
    }
}
