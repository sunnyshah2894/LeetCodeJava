/**
 *		
 */
package com.easy;

import java.util.Stack;

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
https://leetcode.com/problems/min-stack/description/
-------------------------------------------------------

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.


*
*/
class MinStack {
    
    long minimum = 0;
    Stack<Long> st;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<Long>();
    }
    
    public void push(int x) {
        long x1=x;
        if( st.isEmpty() ){
            minimum = x1;
        }
        if( x < minimum ){
            long t=x1;
            x1 = 2*x1 - minimum;
            minimum = t;
        }
        st.push(x1);
        
    }
    
    public void pop() {
        if( !st.isEmpty() ){
            long x = st.pop();
            if( x<minimum ){
                minimum = 2*minimum - x;
            }
        }
    }
    
    public int top() {
        if( !st.isEmpty() ){
            long x = st.peek();
            if( x<minimum ){ 
                return (int)minimum;
            }
            else return (int)x;
        }
        else 
            return -1;
    }
    
    public int getMin() {
        return (int)minimum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
