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

    // Morris Traversal | Preorder ->

    public List<Integer> inorderTraversal(TreeNode root) {
        
        // to store nodes in preorder manner
        List<Integer> result = new ArrayList<>();
        
        // starting from root node
        TreeNode current = root;
        
        while(current != null){
            
            // first we need to check if it has left ? if not then add root value in result and move to right
            if(current.left == null){
                result.add(current.val);
                current = current.right;
            }
            // if it has left then ->
            else{
                
                // first thing find its right most node in left subtree
                TreeNode tempNode = current.left;
                
                // keeping going down until we get rightmost node which either pointing to null OR
                // there is thread between rightmost node to current node
                while(tempNode.right != null && tempNode.right != current)
                    tempNode = tempNode.right;
                
                // if its pointing to null then make thread between rightmost node and current node
                // and again start iterating in left subtree and add in result
                if(tempNode.right == null){
                    tempNode.right = current;
                    current = current.left;
                }
                // if there is already thread means we added all nodes in result list then remove thread
                // add current node in result and move its right part as we already done with left part
                else{
                    tempNode.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        
        return result;
    }
}

