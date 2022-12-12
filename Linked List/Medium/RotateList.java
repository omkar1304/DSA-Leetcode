// https://leetcode.com/problems/rotate-list/

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
    public ListNode rotateRight(ListNode head, int k) {
        // base case
        if(k<=0 || head == null || head.next == null)
            return head;
        
        // step 1: calculate length of LL and connect last node to head as if rotation happens then last node will surely connect to head node
        ListNode tail = head;
        int length = 1;
        
        while(tail.next != null){
            tail = tail.next;
            length = length + 1;
        }
        tail.next = head;
        
        // step 2: make sure that k < length
        // for example if k=8 and length = 6 then rotation required is 2 only.
        k = k % length;
        
        // step 3 : now we have to make skip some nodes and make last node is null which length - k -1 node
        // for example : 1->2->3->4->5->null and k=2 then we have to skip node 1 to 3 which is length - k - 1
        // 1->2->3(temp)->4->5->1->2 ...(cycle)
        // and now temp will point 3 and make temp.next node as head because after rotation LL will start from that node and after that make temp.next = null so it will break cycle 
        //4(head)->5->1->2->3->null
        ListNode temp = head;
        for(int i=0; i<length-k-1; i++)
            temp = temp.next;

        head = temp.next;
        temp.next = null;
        
        return head;
    }
}