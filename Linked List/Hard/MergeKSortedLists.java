// https://leetcode.com/problems/merge-k-sorted-lists/

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
    public ListNode mergeKLists(ListNode[] lists) {     
        // here we just have to perform merge sort operations
        return mergeSort(lists, 0, lists.length-1);   
    }
    
    public static ListNode mergeSort(ListNode[] lists, int start, int end){
        // base case
        
        // if only one list remaining then return it
        if(start == end)
            return lists[start];
        
        // else start applying divide conquere method
        if(start < end){
            int mid = (start + end) / 2;
            
            // to this till we get one LL
            ListNode l1 = mergeSort(lists, start, mid);
            ListNode l2 = mergeSort(lists, mid+1, end);
            
            // pass it merge sorted LL function
            return merge(l1, l2);
        }
        
        return null;
    }
    
    public static ListNode merge(ListNode l1, ListNode l2){
        // this code is same as merge sorted LL problem
        
        // we need to return LL so creating dummyNode
        ListNode dummyNode = new ListNode();
        // creating temp to iterate
        ListNode temp = dummyNode;
        
        // we need to check if which value is smaller that node we have to add first in dummyhead
        while(l1 != null && l2 != null){
            
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }            
        }
        
        // if anyone LL ends then we have to attach other LL to dummyhead
        temp.next = l1 != null ? l1 : l2;
        
        // returning dummynext.next as its null value we need to pass LL from their next
        return dummyNode.next;
    }
}