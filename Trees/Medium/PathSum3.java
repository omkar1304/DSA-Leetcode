// https://leetcode.com/problems/path-sum-iii/

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
    // global variable 
    int res = 0;
    
    private void helper(TreeNode root, long currSum, int target, HashMap<Long, Integer> map){
        // base case
        
        // if root is null then return it from here
        if(root == null) 
            return;
        
        // updating currSum as we found another node
        currSum = currSum + root.val;
        
        // if we have currSum - target -> currSum is nothing but sum from root to current node
        // currSum - target = remaining. here remaining means sum from root node to remaining node 
        // hence it defines that if map contains that remaining value inside it that means from that node we can get sum which equals to target hence if its present 1 time then we can get target 1 times. if 2 times then 2 times hence update in result with occurance
        if(map.containsKey(currSum - target))
            res = res + map.get(currSum - target);
        
        // putting every currSum occurance in map and update if already present
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        // then check for its left and right part
        helper(root.left, currSum, target, map);
        helper(root.right, currSum, target, map);
        
        // backtarck -> remove occurance as we backtrack to previous node
        map.put(currSum, map.get(currSum) - 1);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        
        // creating map to store prefixSum and its frequency
        HashMap<Long, Integer> map = new HashMap();
        // at start we have 0 prefixSum and its occurance only 1 time
        map.put(0l, 1);
        
        helper(root, 0, targetSum, map);
        return res;
    }
}