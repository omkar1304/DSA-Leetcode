// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/

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
    // To iterate over nums array
    int index = 0;
    // To store swap child's parent node value
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] nums) {
        
        // if it returns true then return result else return list with -1 
        return helper(root, nums) ? result : Arrays.asList(-1);
        
    }
    
    public boolean helper(TreeNode root, int[] nums){
        
        // if root is null then return true
        if(root == null) 
            return true;
        
        // if root value doesnt match with current value from nums then return false immediately
        if(root.val != nums[index++])
            return false;
        
        // root value matching then go for its left and check if its matching with current value from nums
        // if it doesnt match then we have to reverse dfs and add root node value in result as we are doing swap
        if(root.left != null && root.left.val != nums[index]){
            result.add(root.val);
            return helper(root.right, nums) && helper(root.left, nums);
        }
        
        // if it matches then check for normal DFS -> left and right
        return helper(root.left, nums) && helper(root.right, nums);
        
    }
}