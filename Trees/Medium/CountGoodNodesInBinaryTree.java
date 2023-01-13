// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

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
    public int goodNodes(TreeNode root) {
        
        return helper(root, Integer.MIN_VALUE);
    }
    
    public int helper(TreeNode root, int max){
        // if root is null then no node so return count 0
        if(root == null)
            return 0;
        
        // if root value is less than max then check in left and right side with max value as its maximum value currently from root to x node
        if(root.val < max)
            return helper(root.left, max) + helper(root.right, max);
        
        // else root value is maximum value so we got one good node and now check for its left and right with root value as max
        return 1 + helper(root.left, root.val) + helper(root.right, root.val);
    }
}