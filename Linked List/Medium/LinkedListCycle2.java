// https://leetcode.com/problems/linked-list-cycle-ii/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Two pointer ->
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            // if they meet at some node then create new node from start and keep iterating till both new and start meets
            if(slow == fast){
                ListNode entry = head;
                while(entry != slow){
                    slow = slow.next;
                    entry = entry.next;
                }
                
                // if they meet then thats start node of loop. hence retrun that
                return entry;
            }
        }
        
        // if loop is not there then return null
        return null;
    }
}