// https://leetcode.com/problems/merge-two-sorted-lists/

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // creating two heads for respective LL
        ListNode head1 = list1;
        ListNode head2 = list2;
        
        // we need to return LL so creating dummyNode
        ListNode dummyHead = new ListNode();
        // creating temp to iterate
        ListNode temp = dummyHead;
        
        // we need to check if which value is smaller that node we have to add first in dummyhead
        while(head1 != null & head2 != null){
            if(head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }     
        }
        
        // if anyone LL ends then we have to attach other LL to dummyhead
        temp.next = head1 != null ? head1 : head2;
        
        // returning dummynext.next as its null value we need to pass LL from their next
        return dummyHead.next;
    }
}