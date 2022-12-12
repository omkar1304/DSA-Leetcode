// https://leetcode.com/problems/subtree-of-another-tree/

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        // converting s tree into string strS
        StringBuilder sbs = new StringBuilder();
        preOrder(s, sbs);
        String strS = sbs.toString();
        
        // converting t tree into string strT
        StringBuilder sbt = new StringBuilder();
        preOrder(t, sbt);
        String strT = sbt.toString();
        
        // if strT is present in strS then it will return starting index of strT in strS
        // else it will return -1 if not found
        return strS.indexOf(strT) >= 0 ;
        
    }
    
    public void preOrder(TreeNode root, StringBuilder sb){
        // base case
        
        // if we reached to leaff node then store null in string 
        if(root == null){
            sb.append("null");
            return;
        }
        
        // else append its value with # so it will not get attach 
        // for example 1,2 nodes will be store as 12 but what if node is 12 then it will generate wrong result
        // and then go to its left and right part
        sb.append("#" + root.val);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
            
    }
}