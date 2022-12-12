// https://leetcode.com/problems/partition-list/

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
    public ListNode partition(ListNode head, int x) {
        // creating two pointers which will form two new LL where left contains -> less than x value nodes and right contains -> equal or greater than nodes
        ListNode left = new ListNode(); // dummyNode for left LL
        ListNode right = new ListNode(); // dummyNofde for right LL
        
        // pointers for each LL to keep moving next
        ListNode tailLeft = left;
        ListNode tailRight = right;
        
        // we need iterate through entrie LL and make two LL out of it
        while(head != null){
            if(head.val < x){
                tailLeft.next = head;
                tailLeft = tailLeft.next;
            }
            else{
                tailRight.next = head;
                tailRight = tailRight.next;
            }
            head = head.next;
        }
        
        // once we do that just make some connections 
        // point left LL to right(why right.next ? as right is dummyNode so passing next node)
        // and make right tail pointer to null as its ending part
        tailLeft.next = right.next;
        tailRight.next = null;
        
        // return start node(why left.next as left is dummyNode so passing next node)
        return left.next;
        
    }
}