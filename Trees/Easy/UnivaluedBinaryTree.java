// https://leetcode.com/problems/univalued-binary-tree/

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
    public boolean isUnivalTree(TreeNode root) {
        
        // if root null then its unival hence return true
        if(root == null) 
            return true;
        
        return helper(root, root.val);       
    }
    
    public boolean helper(TreeNode root, int value){
        
        // if root null then its unival hence return true
        if(root == null)
            return true;
        
        // if values are not macthing then return false
        if(root.val != value)
            return false;
        
        // if values are matching and its leaf node then return false
        if(root.val == value && root.left == null && root.right == null)
            return true;
        
        // else check in left and right side if both true then its unival tree else not
        return (helper(root.left, value) && helper(root.right, value));
    }
}