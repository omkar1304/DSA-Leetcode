// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // finding length of LL
        ListNode temp = head;
        int length = 1;
        while(temp != null){
            length = length + 1;
            temp = temp.next;
        }
        
        // creating prev and current node to perform delete operation
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;
        
        // skipping nodes till current points to that node which needs to get deleted
        int skip = length - n - 1;
        for(int i=0; i<skip; i++){
            prev = prev.next;
            current = current.next;
        }
        
        // just point prev.next to current.next so we can skip current
        prev.next = current.next;
        
        // returning LL 
        return dummyNode.next;
    }
}