// https://leetcode.com/problems/binary-search-tree-iterator/

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
class BSTIterator {
    
    // creating stack to add all left side nodes
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        // calling helper to get add all left side nodes at first time untill reaches null
        helper(root);
    }
    
    public int next() {
        // in stack top element will be next inorder node
        // hence we can pop that element and return its value
        // but before that if it has right then we need add in stack using helper funtion
        TreeNode node = stack.pop();
        helper(node.right);
        
        return node.val;
        
    }
    
    public boolean hasNext() {
        // if stack is empty then it has not next else it has 
        return !stack.isEmpty();
    }
    
    public void helper(TreeNode root){
        // here we are just storing left side nodes of tree 
        // i.e. storing path from root to leat which O(H) -> height of tree
        TreeNode tempNode = root;
        
        while(tempNode != null){
            stack.push(tempNode);
            tempNode = tempNode.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */