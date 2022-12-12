// https://leetcode.com/problems/linked-list-cycle/

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
    public boolean hasCycle(ListNode head) {
        // Two pointer ->
        ListNode slow = head;
        ListNode fast = head;
        
        // if anywhere slow pointer meets fast pointer that means loop is there 
        // hence return true
        while(fast != null && fast.next != null){
            slow = slow.next; // moving by 1 step
            fast = fast.next.next; //moving by 2 step
            if(slow == fast)
                return true;
        }
        
        // else return false
        return false;
    }
}