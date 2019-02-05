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
https://leetcode.com/problems/reverse-linked-list-ii/description/
-------------------------------------------------------

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

*
*/
class ListNode{
	int val;
	ListNode next;
	public ListNode(int n){
		this.val = n;
	}
	
}
public class ReverseLinkedListII {
	
	public ListNode reverseBetweenMyApproah(ListNode head, int m, int n) {
        ListNode parentRoot = new ListNode(0);
        parentRoot.next = head;
        ListNode currNode = parentRoot;
        ListNode currNodePrev = parentRoot;
        int index = 0;
        while( index != m ){
            index++;
            currNodePrev = currNode;
            currNode = currNode.next;
        }
        
        ListNode headNode = currNode;
        ListNode nodeToAdd = currNode.next;
        ListNode nodePrevAddition = currNode;
        while( index!=n && nodeToAdd != null ){
            ListNode temp = nodeToAdd.next;
            nodeToAdd.next = headNode;
            nodePrevAddition.next = temp;
            headNode = nodeToAdd;
            nodeToAdd = temp;
            index++;
        }
        currNodePrev.next = headNode;
        return parentRoot.next;
    }
	
	/*
	 * 	Much cleaner approach;
	 * 
	 * 	Need 3 pointers:
	 * 	prevNode -> points to element before the reverse list start
	 * 	startNode -> element from where we will start reversing. This will become the last of the reversed subset
	 * 	nextNode -> node that should now come first in the next step of the reversing.	
	 * 
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
        
		if( head == null )return null;
		
		ListNode parentRoot = new ListNode(0);
        parentRoot.next = head;
        ListNode prevNode = parentRoot;
        
        int index = 1;
        while( index != m ){
            index++;
            prevNode = prevNode.next;
        }
        
        ListNode startNode = prevNode.next;
        ListNode nextNode = startNode.next;
        
        while( index!=n && nextNode != null ){
            startNode.next = nextNode.next;
            nextNode.next = prevNode.next;
            prevNode.next = nextNode;
            nextNode = startNode.next;
            index++;
        }
        return parentRoot.next;
    }
	
}
