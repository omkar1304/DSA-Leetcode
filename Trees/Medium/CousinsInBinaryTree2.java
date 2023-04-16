// https://leetcode.com/problems/cousins-in-binary-tree-ii/

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
    public TreeNode replaceValueInTree(TreeNode root) {
        
        // To store sum of childeren of current and last level
        int currLvlChildSum = 0;
        int lastLvlChildSum = 0;
        
        // To store node and sum of its childeren -> {parent : child Sum}
        Map<TreeNode, Integer> map = new HashMap<>();
        
        // To apply BFS 
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, null));
        
        while(!queue.isEmpty()){
            
            // at start child sum of current level is 0
            currLvlChildSum = 0;
            
            // to go level wise in Tree
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                
                // pop out pair from queue
                TreeNode node = queue.peek().node;
                TreeNode parent = queue.peek().parent;
                
                queue.poll();
                
                // calculate child sum of current popped out node and add in queue if not nulll
                int childSum = 0;
                
                if(node.left != null){
                    childSum += node.left.val;
                    queue.offer(new Pair(node.left, node));
                }
                
                if(node.right != null){
                    childSum += node.right.val;
                    queue.offer(new Pair(node.right, node));
                }
                
                // now we calculated both left and right child so we can store it in map
                map.put(node, childSum);
                
                // adding calculated childsum in current Level child sum so we can get sum of all child in current level
                currLvlChildSum += childSum;
                
                // simplified -> if we want sum of cousins for current node then simply we can do subtraction of current level sum - sum of children of current node's parent 
                node.val = lastLvlChildSum - map.getOrDefault(parent, 0);
            }
            
            // once level is done store current level child sum to last level child sum for next level nodes
            lastLvlChildSum = currLvlChildSum;
        }
        
        return root;
    }
}

class Pair{
    
    TreeNode node;
    TreeNode parent;
    
    public Pair(TreeNode node, TreeNode parent){
        this.node = node;
        this.parent = parent;
    }
}