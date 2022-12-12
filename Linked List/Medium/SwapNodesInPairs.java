// https://leetcode.com/problems/swap-nodes-in-pairs/

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
    public ListNode swapPairs(ListNode head) {
        // creating dummynode to link with head
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        
        // Two pointers 
        ListNode prev = dummyNode;
        ListNode current = head;
        
        while(current != null && current.next != null){
            // storing current.next.next in temp as we need to link it with current.next
            ListNode temp = current.next.next;
            
            // making connections ->
            prev.next = current.next;
            current.next.next = current;
            current.next = temp;
            
            // updating pointers
            prev = current;
            current = current.next;
        }
        
        // returing head
        return dummyNode.next;
    }
}