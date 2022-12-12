// https://leetcode.com/problems/maximum-binary-tree-ii/

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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        
        // If root.val > val, recusion on the right.recursion on the right when root.val > val, because new element will be inserted at the end of the list.
        if(root != null && root.val > val){
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        
        // Else, put right subtree on the left of new node TreeNode(val)
        TreeNode node = new TreeNode(val);
        node.left = root;
        return node;
    }
}