// https://leetcode.com/problems/reverse-linked-list/

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
    public ListNode reverseList(ListNode head) {
        
        // edge case if head is null then just return it
        if(head == null)
            return head;
        
        // keeping three nodes -> prev, current, post
        ListNode prev = null;
        ListNode current = head;
        ListNode post = current.next;
        
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
}