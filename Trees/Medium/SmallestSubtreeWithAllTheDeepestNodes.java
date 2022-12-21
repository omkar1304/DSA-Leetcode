// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // base case
        
        // if root is null then return null
        if(root == null)
            return null;
        
        // as we observe we will get deepest subtree only if current node has left subtree height = right subtree height 
        // if not then if left height > right height then deepest will be in left side else right side
        
        // calculating height for left and right tree
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        
        // if both are equal then current root is ans 
        if(leftHeight == rightHeight)
            return root;
        
        // else check in left side if left height > right height
        else if(leftHeight > rightHeight)
            return subtreeWithAllDeepest(root.left);
        
        // else check in right side if left height < right height
        else
            return subtreeWithAllDeepest(root.right);
    }
    
    public int helper(TreeNode root){
        // its same as get max depth function
        
        // if root null then height will be 0
        if(root == null)
            return 0;
        
        // calculate for left and right
        int left = helper(root.left);
        int right = helper(root.right);
        
        // add root node + max(left, right) and retrun it
        return 1 + Math.max(left, right);
    }
}