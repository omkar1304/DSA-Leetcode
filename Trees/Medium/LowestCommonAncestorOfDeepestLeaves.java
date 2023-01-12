// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // base case
        
        // if root is null then return null
        if(root == null)
            return null;
        
        // as we observe we will get deepest subtree only if current node has left subtree height = right subtree height 
        // if not then if left height > right height then deepest will be in left side else right side
        
        // calculating height for left and right tree
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        // if both are equal then current root is ans 
        if(leftHeight == rightHeight)
            return root;
        
        // else check in left side if left height > right height
        else if(leftHeight > rightHeight)
            return lcaDeepestLeaves(root.left);

        // else check in right side if left height < right height
        else
            return lcaDeepestLeaves(root.right);
    }
    
    public int maxDepth(TreeNode root){
        // its same as get max depth function
        
        // if root null then height will be 0
        if(root == null)
            return 0;
        
        // calculate for left and right
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        // add root node + max(left, right) and retrun it
        return 1 + Math.max(left, right);
    }
}