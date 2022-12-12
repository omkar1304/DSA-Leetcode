// https://leetcode.com/problems/binary-tree-right-side-view/

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
    public void helper(TreeNode root, Map<Integer, Integer> map, int level){
        // base case
        
        // if root is null then return it from here
        if(root == null)
            return;
        
        // for right view -> keep updating value as first we are calling left recursively then right so at last it will right value at each level
        
        // add or update value in map at particular level
        map.put(level, root.val);
        
        // traverse left and right child
        helper(root.left, map, level+1);
        helper(root.right, map, level+1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        
        Map<Integer, Integer> map = new TreeMap<>();
        // starting from root and empty map and at 0 level
        helper(root, map, 0);
        
        // converting map values into ArrayList
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet())
            result.add(e.getValue());
        
        return result;
        
    }
}