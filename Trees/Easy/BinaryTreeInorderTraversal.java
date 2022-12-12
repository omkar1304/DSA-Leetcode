// https://leetcode.com/problems/binary-tree-inorder-traversal/

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
    public void inOrderRec(TreeNode root, List<Integer> ans){
        // base case
        
        // if root is null then no need to add anything just return from here
        if(root == null)
            return;
        
        // inorder -> left | root | right        
        inOrderRec(root.left, ans);
        ans.add(root.val);
        inOrderRec(root.right, ans);
    }
    
    public List<Integer> inOrderIter(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        
        // creating stack to store nodes as DFS
        Stack<TreeNode> stack = new Stack<>();
        // pointer to iterate over tree
        TreeNode temp = root;
        
        while(temp != null || !stack.empty()){
            // iterate and store node in stack untill we get leftmost null node
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            
            // once we get then pop out his parent node and add into list and check for right
            temp = stack.pop();
            ans.add(temp.val);
            temp = temp.right;
        }
        
        return ans;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        // for recursion  ->
            // List<Integer> ans = new ArrayList<>();
            // inOrderRec(root, ans);
            // return ans;
        
        // for iterative
        return inOrderIter(root);
        
    }
}

