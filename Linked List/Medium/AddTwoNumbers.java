// https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // creating dummyNode so we can create new LL
        ListNode dummyNode = new ListNode();
        ListNode temp = dummyNode;
        
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            // fetching values if node is null then take 0 
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            
            // creating sum and updating carry and sum in node
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum);
            
            // keep moving node if that points to null then assign null
            temp = temp.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        
        // return new LL
        return dummyNode.next;
    }
}