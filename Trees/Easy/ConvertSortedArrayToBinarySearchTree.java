// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return helper(nums, 0, nums.length-1);
        
    }
    
    public TreeNode helper(int[] nums, int low, int high){
        
        // if low > high then no element. hence return null
        if(low > high)
            return null;
        
        // if both are equal then only one element. hence create node and return it
        if(low == high)
            return new TreeNode(nums[low]);
        
        // else find mid of nums 
        int mid = (low + high) / 2;
        
        // create node for mid index value
        TreeNode root = new TreeNode(nums[mid]);
        
        // generate its left and right recuersively
        root.left = helper(nums, low, mid-1);
        root.right = helper(nums, mid+1, high);
        
        // at the end return root
        return root;
    }
}