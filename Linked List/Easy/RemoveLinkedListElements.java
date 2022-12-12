// https://leetcode.com/problems/remove-linked-list-elements/

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
    public ListNode removeElements(ListNode head, int val) {
        // creating dummyNode which points to head of LL
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        
        // creating prev and current pointers
        ListNode prev = dummyNode;
        ListNode current = head;
        
        while(current != null){
            // if current.val == val then we need to skip that node by connecting prev.next to current.next so current will get skipped 
            if(current.val == val){
                prev.next = current.next;
                current = current.next;
            }
            // else we just need to move one by one in LL
            else{
                prev = prev.next;
                current = current.next;
            }
        }
        
        // return head of LL
        return dummyNode.next;
        
    }
}