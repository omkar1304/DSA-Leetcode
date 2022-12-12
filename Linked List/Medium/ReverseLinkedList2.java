// https://leetcode.com/problems/reverse-linked-list-ii/

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        // creating dummynode and its next pointing to head
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        
        // pass 1 ->  get leftprev and current(left index) pointer 
        ListNode leftPrev = dummyNode;
        ListNode current = head;
        
        for(int i=0; i<left-1; i++){
            leftPrev = current;
            current = current.next;
        }
        // so now leftprev is pointing to previous pointer of left and current pointing to left index node
        
        // pass 2 -> reverse linked list(same as reverse linked list problem)
        ListNode prev = null;
        ListNode post = current.next;
        for(int i=0; i<(right - left + 1); i++){
            current.next = prev;
            
            prev = current;
            current = post;
            if(post != null)
                post = post.next;
        }
        
        // pass 3 -> connect remaining next connections(draw LL for better understanding)
        leftPrev.next.next = current;
        leftPrev.next = prev;
        
        // returning dummy.next as head starts from there
        return dummyNode.next;
        
    }
  
}