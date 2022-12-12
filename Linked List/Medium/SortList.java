// https://leetcode.com/problems/sort-list/

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
    public ListNode sortList(ListNode head) {
        // base case
        
        // if head is null or head.next null means only 1 node there then return that head node
        if(head == null || head.next == null)
            return head;
        
        // get the mid node from linkedlist
        ListNode mid = getMid(head);
        
        // sort first half and secondhalf same as merge sort
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(mid);
        
        // then apply merge sort same as we sloved merge two LL problem
        return mergeSort(firstHalf, secondHalf);
    }
    
    public ListNode mergeSort(ListNode list1 , ListNode list2){
        // it is same problem as merge two sorted LL
        
        // creating two heads for respective LL
        ListNode head1 = list1;
        ListNode head2 = list2;
        
        // we need to return LL so creating dummyNode
        ListNode dummyNode = new ListNode();
        // creating temp to iterate
        ListNode temp = dummyNode;
        
        // we need to check if which value is smaller that node we have to add first in dummyhead
        while(head1 != null && head2 != null){
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
        temp.next = (head1 != null) ? head1 : head2;
        
        // returning dummynext.next as its null value we need to pass LL from their next
        return dummyNode.next;
    }
    
    public ListNode getMid(ListNode head){
        // here it is same finding middle element in LL but here we only need to retrun node not entire LL from middle
        
        // create midPrev to keep track of previous of mid node
        ListNode midPrev = null;
        while(head != null && head.next != null){
            // as we see here midPrev(slow) is one step back from fast pointer(head)
            // hence at the end will get node which is previous node of mid
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        
        // hence we are storing mid from midprev by using new node and making its next to null so it can only return node
        ListNode mid = midPrev.next;
        midPrev.next = null;
        
        // returning mid as per request
        return mid;
    }
}