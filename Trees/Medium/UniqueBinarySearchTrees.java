// https://leetcode.com/problems/unique-binary-search-trees/

class Solution {
    public int numTrees(int n) {
        // creating dp with -1 values
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return helper(n, dp);
    }
    
    public int helper(int n, int[] dp){
        // base case
        
        // if n is less than 1 i.e. 0 or 1 then return 1
        if(n <= 1)
            return 1;
        
        // if value already calculated then return it
        if(dp[n] != -1)
            return dp[n];
        
        // else calculate it 
        // create total to store count of unique BST 
        int total = 0;
        
        // make every ith node as root and calculate its left and right part
        // example : ith -> 2 node then left side 1 node, rigth side 2 nodes (3,4)
        for(int i = 1; i <= n; i++){
            total = total + helper(i-1, dp) * helper(n-i, dp);
        }
        
        // store value in dp for future use
        return dp[n] = total;
    }
}