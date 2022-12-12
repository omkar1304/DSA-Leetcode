// https://leetcode.com/problems/delete-node-in-a-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // keep this given node and change its value to next node value and delete next node by pointing given node to next-next node.
        node.val = node.next.val;
        node.next = node.next.next;
    }
}