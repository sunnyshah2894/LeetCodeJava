/**
 *		
 */
package com.easy;

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
https://leetcode.com/problems/intersection-of-two-linked-lists/description/
-------------------------------------------------------
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.


*
*/
public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode curr = headA;
        int countA = 0;
        while( curr != null ){
            curr = curr.next;
            countA++;
        }
        
        curr = headB;
        int countB = 0;
        while( curr != null ){
            curr = curr.next;
            countB++;
        }
        int diff = Math.abs(countA - countB);
        ListNode curr2 ;
        if( countB > countA ){
            curr = headB;
            curr2 = headA;
        }
        else{
            curr = headA;
            curr2 = headB;
        }
        
        while( diff-->0 ){
            curr = curr.next;
        }
        
        while( curr != null && curr2 != null ){
            if( curr.equals(curr2) ){
                return curr;
            }
            curr = curr.next;
            curr2 = curr2.next ;
        }
        
        return null;
        
    }
}
