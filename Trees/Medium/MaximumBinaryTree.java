// https://leetcode.com/problems/maximum-binary-tree/

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int start, int end){
        // base case ->
        
        // if nums doesnt have any element then return null
        if(start > end)
            return null;
        
        // if nums contains only one element then create node and return it
        if(start == end){
            TreeNode root = new TreeNode(nums[start]);
            return root;
        }
        
        // else get max index from nums and create node with its value using index
        int index = getMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[index]);
        
        // same way construct left and right part by passing left nums part from root value in left call and right nums part from root value in right call
        root.left = helper(nums, start, index-1);
        root.right = helper(nums, index+1, end);
        
        // return root at the end
        return root;
        
    }
    
    public int getMaxIndex(int[] nums, int start, int end){
        // this function will return max value index from nums array
        
        int maxIndex = start;
        for(int i=start; i<=end; i++){
            
            if(nums[i] > nums[maxIndex])
               maxIndex = i;
        }
        
        return maxIndex;
    }
}