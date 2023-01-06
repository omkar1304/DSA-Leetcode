// https://leetcode.com/problems/trim-a-binary-search-tree/

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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // if root is null then return null
        if(root == null)
            return null;
        
        // if root value is less then low condition then its left never going to be part of result hence move to right
        if(root.val < low)
            return trimBST(root.right, low, high);
        
        // if root value is greater than high condition then its right never going to be part of result hence move to left
        if(root.val > high)
            return trimBST(root.left, low, high);
        
        // if root value is under condition then build its left and right recursively
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        // at the end return root
        return root;
    }
}