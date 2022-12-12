// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/


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
    public int getDecimalValue(ListNode head) {
        // creating pointer to iterate 
        ListNode temp = head;
        // which holds decimal value of binary number
        int res = 0;
        
        while(temp != null){
            // by doing this we can convert decimal number from binary
            res = res * 2 + temp.val;
            temp = temp.next;
        }
        
        // return 
        return res;
    }
}