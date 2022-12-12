// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

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
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap){
        // base case
        
        // if no nodes value left in any list then return null (it means we are building leaf node)
        if(inStart > inEnd || postStart > postEnd)
            return null;
        
        // creating root node with postorder end value as we know postorder always contains root value at end
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        // getting index of created node value from inorder list using map
        int index = inMap.get(root.val);
        // calculating how many nodes we can split in left part for preOrder list
        int numsLeft = index - inStart;
        
        // postorder = [9,15,7,20,3] so we can split like this -> [9(lefttree), 15,7,20(righttree), 3(root)]
        // inorder = [9,3,15,20,7] so we can split like this -> [9(lefttree), 3(root), 15,20,7(righttree)]
        // now we have to solve recursively same untill we reach null node
        
        root.left = helper(inorder, inStart, index-1, postorder, postStart, postStart+numsLeft-1, inMap);
        root.right = helper(inorder, index+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inMap);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // creating inorder map & storing node value and its index in map
        Map<Integer, Integer> inMap = new HashMap<>();
        
        for(int index=0; index<inorder.length; index++)
            inMap.put(inorder[index], index);
        
        // this function will build tree from inorder and preorder list
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
        
    }
}