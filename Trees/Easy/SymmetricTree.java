// https://leetcode.com/problems/symmetric-tree/

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
    public boolean isSymmetric(TreeNode root) {
        // base case
        
        // if root node is null then no need to check return as it is
        if(root == null)
            return true;
        
        // if its both childern is null then also no need to check return as it is
        if(root.left == null && root.right == null)
            return true;
        
        // first invert left subtree and then try to match with right subtree and return result
        TreeNode invertLeft = invert(root.left);
        boolean res = isSame(invertLeft, root.right);
        
        return res;
        
    }
    
    public TreeNode invert(TreeNode root){
        // Same function as we need to solve invert tree problem ->
        
        // base case
        
        // if root is null then return as it is
        if(root == null)
            return root;
        
        // then go till left and right node and put pointers on left and right node respectively
        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);
        
        // just swap it 
        root.left = right;
        root.right = left;
        
        // return root node after inverting tree
        return root;
    }
    
    public boolean isSame(TreeNode root1, TreeNode root2){
        // its same problem as we need to solve isSame tree problem ->
        
        // base case
        
        // if both roots are null then return true 
        if(root1 == null && root2 == null)
            return true;
        
        // if root1 is null and root2 is not then return false
        if(root1 == null && root2 != null)
            return false;
        
        // if root2 is null and root1 is not then return false
        if(root1 != null && root2 == null)
            return false;
        
        // else we have to check three conditions ->
        // 1. check both node value same or not
        // 2. both leftsubtree is same or not
        // 3. both rightsubtree is same or not
        boolean isNode = root1.val == root2.val;
        boolean left = isSame(root1.left, root2.left);
        boolean right = isSame(root1.right, root2.right);
        
        // return their value 
        return (isNode && left && right);
    }
}