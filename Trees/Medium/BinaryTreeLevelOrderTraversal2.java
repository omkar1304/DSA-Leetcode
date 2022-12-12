// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        // creating result to store lists of integers
        List<List<Integer>> result = new ArrayList<>();
        // if root is null then return empty result
        if(root == null)
            return result;
        
        // creating queue to add node at back and also adding root node in queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
             
            // creating temp to store level wise nodes in list
            List<Integer> temp = new ArrayList<>();
            
            // getting size so we can iterate size times in loop as its define how many nodes present in current level
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                
                // poping out that from front and adding its value in temp list
                TreeNode tempNode = queue.poll();
                temp.add(tempNode.val);
                
                // storing its left and right child to get next level nodes only if its not null 
                if(tempNode.left != null)
                    queue.offer(tempNode.left);
                if(tempNode.right != null)
                    queue.offer(tempNode.right);
            }
            
            // adding temp at index 0 so new temp will be added at front
            result.add(0, temp);
        }
        
        return result;
    }
}