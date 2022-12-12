// https://leetcode.com/problems/binary-tree-maximum-path-sum/

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
public class Solution {
    // storing min value as need to return max
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root) {
        // base case ->
        
        // if root is null then return 0
        if (root == null) 
            return 0;
        
        // get the max sum from left part and right part
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        
        // now we to get max path sum which is -> root val + left + right
        // take max out of previous max and (root val + left + right)
        max = Math.max(max, root.val + left + right);
        
        // and here we have to return any one max sum path either root + left or root + right 
        return root.val + Math.max(left, right);
    }
}