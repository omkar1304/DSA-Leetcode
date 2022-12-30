// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

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
    int index = 0;
    
    public TreeNode bstFromPreorder(int[] nums) {
        // exactly similar as validate BST problem
        return helper(nums, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode helper(int[] nums, int minVal, int maxVal){
        
        // if index is out bound and its not in range of minVal and maxVal then return null
        if(index >= nums.length || nums[index] <= minVal || nums[index] >= maxVal)
            return null;
        
        // else create root node 
        TreeNode root = new TreeNode(nums[index]);
        
        // move to next index of nums
        index = index + 1;
        
        // generate its left and right recursively 
        root.left = helper(nums, minVal, root.val);
        root.right = helper(nums, root.val, maxVal);
        
        // return root
        return root;
    }
}