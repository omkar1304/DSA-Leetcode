// https://leetcode.com/problems/house-robber-iii/

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
    // Memoization ->
    Map<TreeNode, Integer> map = new HashMap<>();
    
    public int rob(TreeNode root) {
        
        return helper(root);
    }
    
    public int helper(TreeNode root){
        
        // if root is null then amount will be 0
        if(root == null)
            return 0;
        
        // if result already stored for this node then return it
        if(map.containsKey(root))
            return map.get(root);
        
        // we have two choice include root(go for its grandchildern) or exclude root(go for its left and right)
        
        // 1. include root and go for its grandchildern if they exist 
        int root_include = root.val;
        
        if(root.left != null)
            root_include = root_include + helper(root.left.left) + helper(root.left.right);
        
        if(root.right != null)
            root_include = root_include + helper(root.right.left) + helper(root.right.right);
        
        
        // 2. exclude root and go for its left and right
        int root_exclude = helper(root.left) + helper(root.right);
        
        // get max from both choice and store in map for future use and return it
        int ans = Math.max(root_include, root_exclude);
        map.put(root, ans);        
        return ans;
        
    }
}