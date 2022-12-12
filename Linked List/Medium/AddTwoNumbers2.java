// https://leetcode.com/problems/add-two-numbers-ii/

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
    public ListNode reverseList(ListNode head){
        // this function will reverse LL
        ListNode prev = null;
        ListNode current = head;
        
        while(current != null){
            ListNode temp = current.next;
            
            current.next = prev;
            
            prev = current;
            current = temp;
        }
        
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reversing both LL
        ListNode rl1 = reverseList(l1);
        ListNode rl2 = reverseList(l2);
        
        // same as add two number problem ->
        
        // creating dummyNode so we can create new LL
        ListNode dummyNode = new ListNode();
        ListNode temp = dummyNode;
        
        int carry = 0;
        
        while(rl1 != null || rl2 != null || carry != 0){
            // fetching values if node is null then take 0 
            int v1 = rl1 != null ? rl1.val : 0;
            int v2 = rl2 != null ? rl2.val : 0;
            
            // creating sum and updating carry and sum in node
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.next = new ListNode(sum);
            
            // keep moving node if that points to null then assign null
            temp = temp.next;
            rl1 = rl1 != null ? rl1.next : null;
            rl2 = rl2 != null ? rl2.next : null;
        }
        
        // while returning we again have to reverse it as per question
        return reverseList(dummyNode.next);
    }
}