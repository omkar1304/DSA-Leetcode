// https://leetcode.com/problems/distribute-coins-in-binary-tree/

class Solution {
    // this will return no of steps required for nodes to have 1 coin each
    int steps = 0;
    
    public int distributeCoins(TreeNode root) {
        
        helper(root);
        return steps;
    }
    
    public int helper(TreeNode root){
        // base case
        
        // if root is null then no requirement hence return 0
        if(root == null)
            return 0;
        
        // get requirements from left part and right part
        int left = helper(root.left);
        int right = helper(root.right);
        
        // here why abs value ? as we know even if its returns neg or pos value we have to apply steps to either give or take resepectively.
        // for example left returns -2 then we will be needing 2 steps to give 2 coins to left part
        // for example left returns +2 then we will be needing 2 steps to take 2 conins from left part
        steps = steps + Math.abs(left) + Math.abs(right);
        
        // here we are retruning requirements of coins and root-1 ? because root also needs 1 coin to hold hence whatever value it is we need to keep 1 and return rest everything with requirement of left and right(in short requirement of whole tree from that current root node)
        return right + left + (root.val - 1);
    }
}