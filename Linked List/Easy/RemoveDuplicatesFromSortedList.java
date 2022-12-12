// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

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
        // if head is null then just return it
        if(head == null)
            return head;
        
        // creating temp node to iterate
        ListNode temp = head;
        while(temp.next != null){
            // if current node value = next node value then skip that next node
            if(temp.val == temp.next.val)
                temp.next = temp.next.next;
            // if not same then we can keep that next node and move ahead
            else
                temp = temp.next;
        }
        
        // returning head as per request
        return head;
    }
}