// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        // base case
        
        // if no nodes value left in any list then return null (it means we are building leaf node)
        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        // creating root node with preorder start value as we know preorder always contains root value at start
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // getting index of created node value from inorder list using map
        int index = inMap.get(root.val);
        // calculating how many nodes we can split in left part for preOrder list
        int numsLeft = index - inStart;
        
        // preorder = [3,9,20,15,7] so we can split like this -> [3(root), 9(lefttree), 20,15,7(righttree)]
        // inorder = [9,3,15,20,7] so we can split like this -> [9(lefttree), 3(root), 15,20,7(righttree)]
        // now we have to solve recursively same untill we reach null node
        
        root.left = helper(preorder, preStart+1, preStart+numsLeft, inorder, inStart, index-1, inMap);
        root.right = helper(preorder, preStart+numsLeft+1, preEnd, inorder, index+1, inEnd, inMap);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // creating inorder map & storing node value and its index in map
        Map<Integer, Integer> inMap = new HashMap<>();
        
        for(int index=0; index<inorder.length; index++)
            inMap.put(inorder[index], index);
        
        // this function will build tree from inorder and preorder list
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
        
    }
}