// https://leetcode.com/problems/binary-tree-preorder-traversal/

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
    public void preOrderRec(TreeNode root, List<Integer> ans){
         // base case
        
        // if root is null then no need to add anything just return from here
        if(root == null)
            return;
        
        // preorder -> root | left | right 
        ans.add(root.val);
        preOrderRec(root.left, ans);
        preOrderRec(root.right , ans);
    }
    
    public List<Integer> preOrderIter(TreeNode root){
        
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        // creating stack to store nodes 
        Stack<TreeNode> stack = new Stack<>();
        // pushing first root node in stack
        stack.push(root);
        while(!stack.empty()){
            // popout first node and add into list and push its left and right node if any
            root = stack.pop();
            list.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return list;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        // for recursion  ->
            // List<Integer> ans = new ArrayList<>();
            // preOrderRec(root, ans);
            // return ans;
        
        // for iterative
        return preOrderIter(root);
        
        
    }
}