// https://leetcode.com/problems/odd-even-linked-list/

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
    public ListNode oddEvenList(ListNode head) {
        // if LL contains less than 3 nodes then return head as it is
        if(head == null || head.next == null || head.next.next == null)
            return head;
        
        // calculating length of LL and making tail to point at last node of LL
        ListNode tail = head;
        int length = 1;
        while(tail.next != null){
            tail = tail.next;
            length = length + 1;
        }
        
        // now we are keeping three pointer -> odd -> even -> oddpost
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddpost = head.next.next;
        int jump = 1;
        
        // here we are pointing out odd.next to oddpost so we can skip that even node 
        // and attaching that even node to tail node and keep updating tail node so every next even node will get added
        // and we have to this until we completely connect all odd nodes to next to each other which will get using jump variable
        while(jump < length){
            odd.next = oddpost;
            tail.next = even;
            tail = even;
            
            odd = oddpost;
            even = oddpost.next;
            oddpost = oddpost.next.next;
            jump = jump + 2;
            
        }
        
        // at last point that last even node(tail) to null to complete LL and return head
        tail.next = null;
        return head;
    }
}