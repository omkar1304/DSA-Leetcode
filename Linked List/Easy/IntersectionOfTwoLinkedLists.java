// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Two pointer ->
        ListNode head1 = headA;
        ListNode head2 = headB;
        
        // if we keep looping this then at the end both pointer will meet as some point that point will be node of intersection.
        // for example -> if headA length 5 and headB length is 5 then after adding opposite length in each of one then both will be length of 11 so will get intersection point at some point.
        while(head1 != head2){
            head1 = head1 != null ? head1.next : headB;
            head2 = head2 != null ? head2.next : headA;
        }
        
        // once we get intesection point then return any node
        return head1;
        
    }
}