// https://leetcode.com/problems/n-th-tribonacci-number/

public class NthTribonacciNumber {
    public int helper(int n, int[] dp){
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = helper(n-1, dp) + helper(n-2, dp) + helper(n-3, dp);
        
    }
    
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            if(i ==0) dp[i] = 0;
            else if(i == 1) dp[i] = 1;
            else if(i == 2) dp[i] = 1;
            else dp[i] = -1;
        }
        
        return helper(n, dp);
    }
}
