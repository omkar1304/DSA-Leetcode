// https://leetcode.com/problems/binary-tree-paths/

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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList<>();
        // if root is null then return empty result
        if(root == null)
            return result;
        
        helper(root, "", result);      
        return result;
        
    }
    
    public void helper(TreeNode root, String temp, List<String> result){
        // base case ->
        
        // if root is null then add whatever path we got in result list and return
        if(root == null){
            result.add(temp);
            return;
        }
        
        // if both left and right are null then this last node of path so store just value in path and that path in list
        if(root.left == null && root.right == null){
            temp = temp + root.val;
            result.add(temp);
            return;
        }
        
        // if left not null then go to left part and add root.val + -> in path
        if(root.left != null)
            helper(root.left, temp+root.val+"->", result);
        
        // if right not null then go to right part and add root.val + -> in path
        if(root.right != null)
            helper(root.right, temp+root.val+"->", result);
        
        
    }
}