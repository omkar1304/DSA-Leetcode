// https://leetcode.com/problems/minimum-distance-between-bst-nodes/

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
    
    // to hold min diff between any two nodes
    int minDiff = Integer.MAX_VALUE;
    // to hold each node's inorder predecessor.
    TreeNode prev = null;
    
    public int minDiffInBST(TreeNode root) {
        
        inorder(root);
        return minDiff;
    }
    
    public void inorder(TreeNode root){
        // if root is null then return it
        if(root == null)
            return;
        
        // go to its left
        inorder(root.left);
        
        // if prev not null then it has predecessor. so get the diff and store in minDiff if its < minDiff
        if(prev != null)
            minDiff = Math.min(minDiff, (root.val - prev.val));
        // before go to right we need to update prev as predecessor
        prev = root; 
        
        // go to its right
        inorder(root.right);
    }
}