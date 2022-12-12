// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

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
    public ListNode deleteMiddle(ListNode head) {
        // if head is null or next is null then return null
        if(head == null || head.next == null)
            return null;
        
        // creating dummyNode and point to head
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        
        // pointing prev node before slow node -> [dummyNode - 1 - 2 - 3 - null]
        ListNode prev = dummyNode;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // now we have to point prev.next to mid.next to omit mid node
        // but some case like 2->1 then 2 must point to null hence check condition
        if(slow.next == null)
            prev.next = null;
        else
            prev.next = slow.next;
        
        return head;
    }
}