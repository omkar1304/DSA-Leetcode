// https://leetcode.com/problems/all-possible-full-binary-trees/

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
    // To store at n what type of tress we can make 
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int n) {
        
        // to store possible full BT
        List<TreeNode> list = new ArrayList<>();
        
        // if number of nodes is even then we know we cant make tree out of it. hence return empty list
        if(n % 2 == 0)
            return list;
        
        // if map contains list of trees at value n then return it
        if(map.containsKey(n))
            return map.get(n);
        
        // if only 1 node is there then we can form only one tree. form it and add it in list and return list
        if(n == 1){
            TreeNode root = new TreeNode(0);
            list.add(root);
            return list;
        }
        
        // else we have to build left and right list trees 
        // n - 1 ? because here we making every node as root. 
        // suppose n = 7, i = 5 then for left list we are passing 5 nodes for left tree list and 2 for right tree list
        // but also creating root which leads us 8 nodes which is n = 8. hence reducing root node prior before building left and right tree list
        n = n - 1;
        
        for(int i=1; i<n; i=i+2){
            
            // built left and right tree list 
            List<TreeNode> leftTree = allPossibleFBT(i);
            List<TreeNode> rightTree = allPossibleFBT(n-i);
            
            // run two for loop to to build tree for each node in list
            for(TreeNode left : leftTree){
                
                for(TreeNode right : rightTree){
                    
                    // create root with current ith node and attach its left and right
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    // once root is build then we can add tree in list
                    list.add(root);
                    
                }
            }
        }
        
        // put in map for future use
        map.put(n+1, list);
        
        // at the end return list
        return list;
    }
}