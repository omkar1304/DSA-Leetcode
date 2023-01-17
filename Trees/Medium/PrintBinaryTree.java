// https://leetcode.com/problems/print-binary-tree/

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
    // basically at every row we need to put root value at mid of low and high
    public List<List<String>> printTree(TreeNode root) {
        
        // result list
        List<List<String>> res = new ArrayList<>();
        
        // get the height from BT
        int height = maxDepth(root);
        
        // calculate row and col using below formaula
        // row = height , col = 2^height - 1
        int row = height;
        int col = (int)Math.pow(2, height) - 1;
        
        // creating list with empty string and adding thoese list in res(intialization)
        for(int r=0; r<row; r++){
            
            List<String> tempList = new ArrayList<>();
            
            for(int c=0; c<col; c++){
                tempList.add("");
            }
            
            res.add(tempList);
        }
        
        // update res with node values and return it
        helper(root, 0, row-1, 0, col-1, res);
        return res;
    }
    
    public void helper(TreeNode root, int rowStart, int rowEnd, int colStart, int colEnd, List<List<String>> res){
        
        // if root is null then no need to do anything return it
        if(root == null)
            return;
        
        // it we reached to all rows then return it
        if(rowStart > rowEnd)
            return;
        
        // else find mid of col
        int colMid = (colStart + colEnd) / 2;
        
        // once we ge the mid of col then add root.val in current row at mid of col index
        res.get(rowStart).set(colMid, String.valueOf(root.val));
        
        // do same for its left and right part recursively
        helper(root.left, rowStart+1, rowEnd, colStart, colMid-1, res);
        helper(root.right, rowStart+1, rowEnd, colMid+1, colEnd, res);
    }
    
    public int maxDepth(TreeNode root){
        // this funtion will return height of tree
        if(root == null)
            return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}