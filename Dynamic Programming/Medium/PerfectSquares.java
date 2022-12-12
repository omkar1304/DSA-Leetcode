// https://leetcode.com/problems/perfect-squares/

public class PerfectSquares {
    public int helper(int n, int[] dp){
        // base case
        
        // if n = 0 then we know number of ways to find sum of perfect square is 0
        if(n == 0)
            return 0;
        
        // if n is less then 0 then we can return max value as its not possible
        // why -1 ? as in math.min we are adding +1 hence it should fit under 2^32 bit.
        if(n < 0)
            return Integer.MAX_VALUE - 1;
        
        // if present then return
        if(dp[n] != -1)
            return dp[n];
        
        // to store min first need to store max value
        int min = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            // + 1 -> as we consider to add this number to get sum of perfect square
            // calculate for all the perfect square number which is <= n
            // and return min of it
            min = Math.min(min, 1 + helper(n-(i*i), dp));
        }
        
        // store for future use
        return dp[n] = min;
    }
    
    public int numSquares(int n) {
        // Memoization ->
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return helper(n, dp);
    }
}
