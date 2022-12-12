// https://leetcode.com/problems/sum-root-to-leaf-numbers/

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
    public int sumNumbers(TreeNode root) {
        
        return helper(root, 0);
    }
    
    public int helper(TreeNode root, int n){
        // base case 
        
        // if root is null then return 0
        if(root == null)
            return 0;
        
        // if root left and right part is null then add root value in n and return it
        if(root.left == null && root.right == null)
            return n * 10 + root.val;
        
        // else get sum from left part and right part and return it
        return helper(root.left, n*10 + root.val) + helper(root.right, n*10 + root.val);
    }
}