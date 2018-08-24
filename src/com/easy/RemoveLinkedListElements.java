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
https://leetcode.com/problems/remove-linked-list-elements/description/
-------------------------------------------------------

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

*
*/
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        
        if( head == null ) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currNode = head;
        ListNode prevNode = dummy;
        
        while( currNode != null ){
            if( currNode.val == val ){
                prevNode.next = currNode.next;
            }
            else{
                prevNode = prevNode.next;
            }
            currNode = currNode.next;
        }
        return dummy.next;
    }
}
