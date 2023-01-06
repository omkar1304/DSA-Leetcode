// https://leetcode.com/problems/convert-bst-to-greater-tree/

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
    // creating sum to hold sum of all nodes which are greater than current node
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        
        inorder(root);
        return root;
    }
    
    public void inorder(TreeNode root){
        // if root is null then return it from there
        if(root == null)
            return;
        
         // go to rightmost element 
        inorder(root.right);
        
        // add its value in sum and assign sum to itself
        sum = sum + root.val;
        root.val = sum;
        
        // then go for left
        inorder(root.left);
    }
}