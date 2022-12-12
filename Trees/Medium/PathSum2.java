// https://leetcode.com/problems/path-sum-ii/

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

    public void helper(TreeNode root, int target, List<Integer> temp, List<List<Integer>> result){
        // base case
        
        // if root is null then return 
        if(root == null)
            return;
        
        // add root val in temp list to store path
        temp.add(root.val);
        
        // if root left and right childeren are null and root val is equal to target then we found path which sum == equal so store that temp in result
        if(root.left == null && root.right == null && root.val == target){
            result.add(new ArrayList<>(temp));
        } 
        // else explore its left and right nodes
        else{
            helper(root.left, target-root.val, temp, result);
            helper(root.right, target-root.val, temp, result);
        }
        
        // backtrack ->
        temp.remove(temp.size() - 1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // storing all paths in result
        List<List<Integer>> result = new ArrayList<>();
        
        helper(root, target, new ArrayList<>(), result);
        return result;
    }
}