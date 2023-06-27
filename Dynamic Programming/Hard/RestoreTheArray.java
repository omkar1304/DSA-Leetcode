// https://leetcode.com/problems/restore-the-array/

import java.util.*;

class Solution {
    
    int mod = (int)(1e9 + 7);
    
    public int numberOfArrays(String s, int k) {
        
        // Memoization ->
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return helper(0, s, k, dp);
    }
    
    public int helper(int index, String s, int k, int[] dp) {
        
        // if we recahed to end of string means we have formed one way so return 1
        if (index == s.length()) 
            return 1;
        
        // if current char is 0 then we cant form number with it so return 0
        if (s.charAt(index) == '0') 
            return 0; 
        
        // if present then return
        if(dp[index] != -1)
            return dp[index];
        
        // ans -> to calculate no of ways and num -> to form number from string
        int ans = 0;
        long num = 0;
        
        for (int j = index; j < s.length(); j++) {
            
            // forming number from index to j
            num = num * 10 + s.charAt(j) - '0'; 
            
            // if number is not in range of [1, k] then not possible further hence break from here
            if (num > k) break; 
            
            // else check for next char and store no of ways in ans
            ans = ans + helper(j+1, s, k, dp);
            ans = ans % mod;
        }
        
        // storing for future use
        return dp[index] = ans;
    }
}