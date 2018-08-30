/**
 *		
 */
package com.medium;

import java.util.LinkedList;
import java.util.Queue;

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
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
-------------------------------------------------------

You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

Example:

Input:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

Output:
1-2-3-7-8-11-12-9-10-4-5-6-NULL

*
*/
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};

public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if( head == null )return head;
        Queue<Node> ls = new LinkedList<>();
        flatten( head, ls );
        Node curr = ls.remove();
        Node root = curr;
        root.child = null;
        for( Node n : ls ){
            curr.next = n;
            n.prev = curr;
            curr = n;
            curr.child = null;
        }
        return root;
        
    }
    public void flatten( Node head, Queue<Node> ls ){
        if( head == null )return;
        ls.add( head );
        flatten( head.child,ls );
        flatten( head.next,ls );
    }
}
