// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

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
    public ListNode deleteDuplicates(ListNode head) {
        // if head contains 0 or 1 node then simply return head
        if(head == null || head.next == null)
            return head;
        
        // creating dummy node which next will point to head to keep track of head
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        // creating three pointers : pp -> prev -> current
        ListNode pp = dummy; // pp will always hold distinct node
        ListNode prev = head;
        ListNode current = head.next;
        
        while(current != null){
            // if value matches then we have to skip all node with that value
            // and at the end connect pp.next to current(as pp holding distinct node)
            if(prev.val == current.val){
                while(current != null && prev.val == current.val){
                    prev = current;
                    current = current.next;
                }
                // making connection and updating pointers
                pp.next = current;
                prev = current;
                current = current != null ? current.next : null; // checking null conditions 
            }
            else{
                // if value not matching then simply update every pointers by one node
                pp = prev;
                prev = current;
                current = current.next;
            }
            
        }
        
        // returning head
        return dummy.next;
    }
}