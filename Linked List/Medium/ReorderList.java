// https://leetcode.com/problems/reorder-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode getMid(ListNode head){
        // Two pointers ->
        ListNode slow = head;
        ListNode fast = head;
        
        // fast pointer running in 2x speed of slow 
        // if fast reaches end point then its obivous that slow will at middle point
        // hence retrun slow node
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        // edge case if head is null then just return it
        if(head == null || head.next == null)
            return head;
        
        // keeping three nodes -> prev, current, post
        ListNode prev = null;
        ListNode current = head;
        ListNode post = head.next;
        
        // we can move till which last node which is null
        while(current != null){
            // basically now LL is like this :  prev -> current -> post
            current.next = prev;
            
            // after this : prev <- current (no link) post 
            // updating each pointer by 1 node
            prev = current;
            current = post;
            if(post != null) // checking null condition
                post = post.next;
        }
        // once current reached null node then prev is on last node hence return that 
        return prev;
    }
    
    public void reorderList(ListNode head) {
        /*
        list -> 1-2-3-4-3-2-1 -> make reverse of it from middle -> 1-2-3-1-2-3-4
        and point head1 at first and head2 at start of reverse list which is mid and keep comparing value
        now attch head1 to head2 then inc head1 and now attach head2 to head 1 and inc head2.
        keep doint it until LL ends and make last node(head1) to point null else it will form cycle
       */
        ListNode head1 = head; // storing head1
        ListNode mid = getMid(head); // getting middle node to reverse from there
        ListNode head2 = reverseList(mid); // reverse link from middle and get start point of reverse list
        
        while(head1 != null && head2 != null){
            // making head1 points to head2 and inc head1 by next node
            ListNode temp = head1.next;
            head1.next = head2;
            head1 = temp;
            
            // making head2 points to head1 and inc head2 by next node
            temp = head2.next;
            head2.next = head1;
            head2 = temp;
        }
        
        // last node should be point to null hence adding it(else it will form cycle)
        if(head1 != null)
            head1.next = null;
    }
}