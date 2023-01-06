// https://leetcode.com/problems/balance-a-binary-search-tree/

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
    
    List<TreeNode> result = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        // convert BST into sorted list 
        inorder(root);
        // convert sorted list into BST
        return listToBST(result, 0, result.size()-1);
    }
    
    // apply inorder traversal
    public void inorder(TreeNode root){
        
        if(root == null)
            return;
        
        inorder(root.left);
        result.add(root);
        inorder(root.right);
    }
    
    // same as problem -> convert sorted list into BST
    public TreeNode listToBST(List<TreeNode> result, int low, int high){
        
        if(low > high)
            return null;
        
        int mid = (low + high) / 2;
        
        TreeNode root = result.get(mid);
        root.left = listToBST(result, low, mid-1);
        root.right = listToBST(result, mid+1, high);
        
        return root;
    }
}