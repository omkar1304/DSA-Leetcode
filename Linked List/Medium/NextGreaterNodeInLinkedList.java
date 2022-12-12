// https://leetcode.com/problems/next-greater-node-in-linked-list/

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
    public int[] nextLargerNodes(ListNode head) {
        
        // Step 1 : find length 
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length = length + 1;
        }
        
        // step 2 : create nums array by using LL -> converting LL into array
        temp = head;
        int[] nums = new int[length];
        for(int i=0; temp != null && i<length; i++){
            nums[i] = temp.val;
            temp = temp.next;
        }
        
        // step 3 : solve this example by using monotonic stack 
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<length; i++){
            // if stack is not empty and current value is greater than stack top value then that value will get next greater element else just push it
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                res[stack.peek()] = nums[i];
                stack.pop();
            }
            
            stack.push(i);
        }
        
        return res;
    }
}