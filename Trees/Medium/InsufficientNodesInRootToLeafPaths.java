// https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/

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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        
        // if root is null then return null
        if(root == null)
            return null;
        
        // if root left and right tree null then root is leaf node so check if its greater or equal than root value then return root else null
        if(root.left == null && root.right == null)
            return root.val < limit ? null : root;
        
        // if not leaf node then go its left and right part and decrease limit with current root value
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        
        // if left and right are same means both null then return null else return root
        return root.left == root.right ? null : root;
    }
    
}