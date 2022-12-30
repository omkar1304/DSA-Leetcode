// https://leetcode.com/problems/range-sum-of-bst/

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
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        // if root is null then return 0
        if(root == null)
            return 0;
        
        // if root value is not in range and also its greater than high value then right tree wont be part of this problem hence go to left
        if(root.val > high)
            return rangeSumBST(root.left, low, high);
        
        // if root value is not in range and also its smaller than low value then left tree wont be part of this problem hence go to right
        if(root.val < low)
            return rangeSumBST(root.right, low, high);
        
        // if root in range then return root value + left tree value + right tree value
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}

