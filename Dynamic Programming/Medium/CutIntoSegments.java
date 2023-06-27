// https://www.codingninjas.com/codestudio/problems/cut-into-segments_1214651?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

import java.util.*;

public class CutIntoSegments {
    public static int helper(int n, int x, int y, int z, int[] dp){
        // base case
        
        // if rod length 0 then no segment is needed hence return 0
        if(n == 0)
            return 0; 
        
        // if rod length is less than zero then return min of int as we need to calculate max
        if(n < 0)
            return Integer.MIN_VALUE;
        
        // if present then return
        if(dp[n] != -1)
            return dp[n];
        
        // we have three choices go with x, or y, or z
        // adding 1 as we pick one of three segment 
        // return max out of it.
        int pick1 = 1 + helper(n-x, x, y, z, dp);
        int pick2 = 1 + helper(n-y, x, y, z, dp);
        int pick3 = 1 + helper(n-z, x, y, z, dp);
        
        // storing for future use
        return dp[n] = Math.max(pick3 , Math.max(pick1, pick2));
    
    }

    public static int cutSegments(int n, int x, int y, int z) {
        // Memoization ->
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        int ans = helper(n, x, y, z, dp);
        return ans < 0 ? 0 : ans;
    }
}
