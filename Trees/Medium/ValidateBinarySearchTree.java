// https://leetcode.com/problems/validate-binary-search-tree/

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
    public boolean isValidBST(TreeNode root) {
        // here we are passing limit to every node and every node should be in that range
        // minVal < node value < maxVal
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, Long minVal, Long maxVal){
        
        // if root is null then its already BST then return true
        if(root == null)
            return true;
        
        // if root value not in range then return false
        if(root.val >= maxVal || root.val <= minVal)
            return false;
        
        // else check for left and right. if both retrun true then its BST else not 
        // if we go left then change maxVal to its root value
        // if we go right then change minVal to its root value
        return (helper(root.left, minVal, (long)root.val) && helper(root.right, (long)root.val, maxVal));
    }
}