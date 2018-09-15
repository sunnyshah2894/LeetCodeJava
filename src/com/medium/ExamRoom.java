/**
 *		
 */
package com.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

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
https://leetcode.com/problems/exam-room/description/
-------------------------------------------------------

In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.

When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)

Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.

 

Example 1:

Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
Output: [null,0,9,4,2,null,5]
Explanation:
ExamRoom(10) -> null
seat() -> 0, no one is in the room, then the student sits at seat number 0.
seat() -> 9, the student sits at the last seat number 9.
seat() -> 4, the student sits at the last seat number 4.
seat() -> 2, the student sits at the last seat number 2.
leave(4) -> null
seat() -> 5, the student​​​​​​​ sits at the last seat number 5.

​​​​​​​

Note:

    1 <= N <= 10^9
    ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
    Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.

*
*/
public class ExamRoom {

    class Interval{
        int start;
        int end;
        Interval( int start, int end ){
            this.start = start;
            this.end = end;
        }
    }
    
    int N;
    PriorityQueue<Interval> pq;
    
    public ExamRoom(int N) {
        this.N = N;
        pq = new PriorityQueue<>( 100000 , new Comparator<Interval>(){
            public int compare( Interval a, Interval b ){
                if( (a.end-a.start)/2 == (b.end-b.start)/2 )
                    return a.start - b.start;
                else return (b.end-b.start) - (a.end - a.start);
            }
        });
    }
    
    public int seat() {
        
        if( pq.size() == 0 ){
            pq.offer( new Interval(0,2*(N-1)) );
            return 0;
        }
        else if( pq.size() == 1 && pq.peek().start < 0 && pq.peek().end > N-1 ){
                pq.clear();
                pq.offer( new Interval(0,2*(N-1)) );
                return 0;
        }
        else{
            Interval temp = pq.poll();
            int result = temp.start + (temp.end - temp.start)/2;
            
            if( result != 0 ){
                pq.offer( new Interval(temp.start,result) );
            }
            if( result != N-1 ){
                pq.offer( new Interval(result,temp.end) );
            }
            return result;
        }
    }
    
    public void leave(int p) {
        
        if( pq.size() == 1 && pq.peek().start < 0 && pq.peek().end > N-1 ){
            pq.clear();
            pq.offer( new Interval(0,2*(N-1)) );
            return;
        }
        
        Interval before = null, after = null;
        
        for( Interval i : pq ){
            
            if( i.start == p )
                after = i;
            if( i.end == p )
                before = i;
        }
        
        if( after == null && before == null )return;
        
        if( after != null )
            pq.remove( after );
        if( before != null )
            pq.remove( before );
        
        
        
        if( after==null ){
            if( before.start < 0 )
                before.start = (-1) * ( before.end + (before.end - before.start) ) ;
            pq.offer( new Interval( before.start , before.end + (before.end - before.start) ) );
            return ;
        }
        if( before==null ){
            if( after.end > N-1 )
                after.start = -1*(after.end);
            pq.offer( new Interval( after.start - (after.end-after.start) , after.end ) );
            return;
        }
        
        
        if( before.start < 0 )
            before.start = -1*(after.end);
        if( after.end > N-1 )
            after.end = -1*(before.start);
        
        pq.offer( new Interval( before.start, after.end ) );
        return;
    }
}
