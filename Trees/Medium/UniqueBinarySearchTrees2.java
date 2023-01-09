// https://leetcode.com/problems/unique-binary-search-trees-ii/

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
    
    public List<TreeNode> generateTrees(int n) {
        
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end){
        
        // Creating list to store BST
        List<TreeNode> list = new ArrayList<>();
        
        // if start > end then no element remaining hence add null in list and return
        if(start > end){
            list.add(null);
            return list;
        }
        
        // if start == end then only one element left hence create node and add node in list and return list
        if(start == end){
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        
        // else make every node as root and find list of left trees list and right right tress
        for(int i=start; i<=end; i++){
            
            // recuersively get list for left and right for current index 
            List<TreeNode> leftTree = helper(start, i-1);
            List<TreeNode> rightTree = helper(i+1, end);
            
            // run two for loop to to build tree for each node in list
            for(TreeNode left : leftTree){
                
                for(TreeNode right : rightTree){
                    // create root with current ith node and attach its left and right
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    // once root is build then we can add tree in list
                    list.add(root);
                    
                }
            }                
        }
        
        // at the end return list
        return list;
    }
}