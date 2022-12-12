// https://leetcode.com/problems/sum-of-left-leaves/

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
    public int sumOfLeftLeaves(TreeNode root) {
        
        return helper(root, false);
        
    }
    
    public int helper(TreeNode root, boolean isLeft){
        // base case
        
        // if root is null then return 0
        if(root == null)
            return 0;
        
        // if root is only node and its left one then return value
        if(root.left == null && root.right == null && isLeft)
            return root.val;
        
        // else solve recursively in left and right by passing true and false respectively
        return helper(root.left, true) + helper(root.right, false);
    }
}