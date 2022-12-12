// https://leetcode.com/problems/reverse-nodes-in-k-group/

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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // edge case if head or head.next is null then return head
        if(head.next == null)
            return head;
        
        // counting size so if length is 7 and k=2 then size/k -> 7/2 => 3
        // that means we have to reverse group of knumber of nodes 3 times else remains same
        int size = 0;
        ListNode temp = head;
        
        while(temp != null){
            temp = temp.next;
            size = size + 1;
        }
        
        // creating dummyNode to keep track of start node which needs to return at the end
	    ListNode dummy = new ListNode();
        dummy.next = head;
        
        // now same thing we need to do as we do for reverse LL 
        // store prev and current as per -> prev = dummy, current = head
        // here putting grpprev as prev element of grp
        ListNode current = head;
        ListNode groupPrev = dummy;
        ListNode prev = dummy;
        
        for(int j = 0; j < size / k; j++){  // as above it will run size/k times 
            ListNode groupStart = current;
            
            // this is same as reverse LL
            // here storing groupstart node as current node
            for(int i = 0; i < k; i++){
                ListNode post = current.next;
                current.next = prev;
                prev = current;
                current = post;
            }
            
            // now suppose LL is dummy-> 1 -> 2 -> 3 -> 4..... and k = 2 hence we will reverse grp 1 to 2
            // after revsering LL  dummy(groupPrev)    2(prev) -> 1(groupStart)   3(current) -> 4 .....
            // now we have to connect nodes as per above
            groupPrev.next = prev;
            groupStart.next = current;
            
            // once this is done we need to update groupPrev and prev as groupStart (refer above LL)
            groupPrev = groupStart;
            prev = groupStart;

        }
        
        // return dummy.next as its pointing to head
        return dummy.next;
    }
}