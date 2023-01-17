// https://leetcode.com/problems/longest-univalue-path/

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
    
    int max = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        // if root is null then no path present hence return 0
        if(root == null)
            return 0;
        
        helper(root, root.val);
        // here we are calculating no of univalue nodes so path = no of nodes - 1;
        return max - 1; 
    }
    
    public int helper(TreeNode root, int preVal){
        // if root is null then no path present hence return 0
        if(root == null)
            return 0;
        
        // perform postorder -> start building from botto to up
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        
        // take max out of max and (root value node + left side node + right side node)
        max = Math.max(max, (left+right+1));
        
        // if root value matching with previous value then return max from left and right + 1 else return 0 as no univalue node found
        return root.val == preVal ? Math.max(left, right) + 1 : 0;
    }
}