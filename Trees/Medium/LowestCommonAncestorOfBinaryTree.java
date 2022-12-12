// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case ->
        
        // if root is null then return null
        if(root == null)
            return null;
        
        // if any node is p or q node then LCA is that root node
        if(root == p || root == q)
            return root;
        
        // else start searching from left subtree and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // after this will get 4 permutation ->
        
        // idea -> if we get any p or q from left or right path then return that left or right node respectively else retrun null
        
        // 1. if both found p and q then that root node is answer
        if(left != null && right != null)
            return root;
        
        // 2. if only left found p or q then return left
        else if(left != null && right == null)
            return left;
        
        // 3. if only right found p or q then return right
        else if(left == null && right != null)
            return right;
        
        // 4. if both didnt find any p or q then return null
        else
            return null;
        
    }
}