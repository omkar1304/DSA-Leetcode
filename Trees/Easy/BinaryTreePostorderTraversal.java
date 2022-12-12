// https://leetcode.com/problems/binary-tree-postorder-traversal/

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
    public void postOrderRec(TreeNode root, List<Integer> ans){
         // base case
        
        // if root is null then no need to add anything just return from here
        if(root == null)
            return;
        
        // postorder -> left | right | root
        postOrderRec(root.left, ans);
        postOrderRec(root.right, ans);
        ans.add(root.val);
    }
    
    public List<Integer> postOrderIter(TreeNode root){
        
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        // creating stack to store nodes 
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while(!stack.empty()){
             // popout node and add into list and push its left and right node if any
            root = stack.pop();
            list.add(0, root.val); // here why sepecifying 0 index ? because it will keep pushing back old nodes if lets say in tree 10 is root node so at the end of this function 10 should be at last position
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }
        return list;
        
    }
    
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
        // for recursion  ->
            // List<Integer> ans = new ArrayList<>();
            // postOrderRec(root, ans);
            // return ans;
        
        // for iterative
        return postOrderIter(root);
    }
}