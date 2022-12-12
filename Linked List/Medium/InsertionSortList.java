// https://leetcode.com/problems/insertion-sort-list/

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
    public ListNode insertionSortList(ListNode head) {
        
        // creating dummyNode so its next can point to head
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        
        // Two pointer ->
        ListNode prev = head;
        ListNode current = head.next; // as first node is always sorted so we need to start sorting from second node till last node
        
        while(current != null){
            // if current value is greater than previous value then its already sorted we can move ahead our pointers
            if(current.val >= prev.val){
                prev = prev.next;
                current = current.next;
            }
            else{
                // else we have to traverse from start node of LL and check if next node value is greater than current value or not if yes then we have to insert that node in between (after temp in this case)
                ListNode temp = dummyNode;
                while(current.val > temp.next.val)
                    temp = temp.next;
                
                // once we get temp pointer where its next should point to current
                prev.next = current.next; // making prev to next to next as we need to skip current node
                
                // connections -> 
                current.next = temp.next; 
                temp.next = current;        
                // after connection it will look like this : temp -> current -> temp.next(before adding current)
                
                // updating current pointer to prev.next as its pointing to current.next
                current = prev.next;
                // no need to update prev as we still need to check if next current pointer value is less or greater than prev pointer value

            }
        }
        
        // returning head
        return dummyNode.next;
    }
}