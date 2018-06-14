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
https://leetcode.com/problems/reverse-linked-list/description/
-------------------------------------------------------

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?


*
*/
public class ReverseLinkedList {
	public ListNode reverseListIterative(ListNode head) {
        ListNode root = null;
        
        ListNode currNode = root;
        ListNode nodeToAdd = head;
        while( nodeToAdd != null ){
            ListNode temp = new ListNode(nodeToAdd.val);
            temp.next = currNode;
            currNode = temp;
            nodeToAdd = nodeToAdd.next;
        }
        return currNode;
    }
	public ListNode reverseList(ListNode head) {
        return reverseListRecursive( head,null );
    }
    public ListNode reverseListRecursive( ListNode currNode , ListNode nextNode ){
        
        if( currNode == null ){
            return nextNode; 
        }
        else{
            ListNode temp = new ListNode( currNode.val );
            temp.next = nextNode;
            ListNode root = reverseListRecursive( currNode.next , temp );
            return root;
        }
        
    }
	
}
