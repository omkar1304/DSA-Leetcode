// https://leetcode.com/problems/delete-nodes-and-return-forest/

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
    public List<TreeNode> delNodes(TreeNode root, int[] nums) {
        
        // to store disjoint tress
        List<TreeNode> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        // creating string based on nums
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        
        helper(root, set, result);
        
        // if root it self needs to be deleted then add entire tree in list
        if(!set.contains(root.val))
            result.add(root);
        
        return result;
    }
    
    public TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> result){
        
        // if root null then return null
        if(root == null)
            return null;
        
        // then go to its left and right most node as we are moving from bottom to up to delete nodes
        root.left = helper(root.left, set, result);
        root.right = helper(root.right, set, result);
        
        // and check if that needs to be deleted and if yes then add tree in result if not null and make it null as it needs to get deleted
        if(set.contains(root.val)){
            if(root.left != null)
                result.add(root.left);
            if(root.right != null)
                result.add(root.right);
            return null;
        }
        
        // else return root as it is
        return root;
    }
}