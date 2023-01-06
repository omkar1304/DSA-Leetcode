//  https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public ListNode tempListNode;
    
    public TreeNode sortedListToBST(ListNode head) {
        
        // creating tempNode to iterate while buidling BST
        tempListNode = head;
        // creating ptr to interate over LL to get size
        ListNode ptr = head;
        int size = 0;
        
        while(ptr != null){
            ptr = ptr.next;
            size = size + 1;
        }
        
        // once we get size then apply same merge method
        return helper(0, size-1);
    }
    
    public TreeNode helper(int low, int high){
        
        // if low is greater than high then return null
        if(low > high)
            return null;
        
        // get the mid so we can divide tree in left and right part
        int mid = (low + high) / 2;
        
        // in this case instead of array we have linked list so we can only traverse in one way that is
        // left to right -> so as per BST it would be like -> left, root, right (inorder)
        
        // so fist build left part
        TreeNode left = helper(low, mid-1);
        
        // then create root node based on tempListNode pointing value 
        TreeNode root = new TreeNode(tempListNode.val);
        // after creating node attach left part to its left side
        root.left = left;
        
        // after creating node we have to update tempListNode for next value
        tempListNode = tempListNode.next;
        
        // build right part and attach it to root's right side
        TreeNode right = helper(mid+1, high);
        root.right = right;
        
        // at the end return root
        return root;
    }
}