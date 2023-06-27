// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/

import java.util.*;
class Solution {
    /*
    So basically we have to move from 0 to n-1 piles and at every step we have two choices 
    1. skip current pile and move to next pile that is i+1
    2. in this step we can take 1 coin or 2 coin or 3 coin .... upto k coins from current pile so we will iterate through for loop for this. store coin sum whenever we pick from current pile and move to next pile
    
    at the end return max out of both choice. at every coin picking time take max 
    */
    
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int n = piles.size();
        // Memoization ->
        int[][] dp = new int[n+1][k+1];
        return helper(0, k, piles, dp);
        
    }
    
    public int helper(int i, int k, List<List<Integer>> piles, int[][] dp){
        
        // base case ->
        
        // if we exhausted piles or coins then return 0
        if(i == piles.size() || k == 0)
            return 0;
        
        // if present then return
        if(dp[i][k] > 0)
            return dp[i][k];
        
        // 1. skip current pile and move to next 
        int res = helper(i+1, k, piles, dp);
        
        // 2. take 1 or 2 or 3...coins upto k from current piles and move to next
        int currCoinSum = 0;
        for(int j=0; j<piles.get(i).size() && j < k; j++){
            
            // storing picked coin sum 
            currCoinSum += piles.get(i).get(j);
            
            // take max out of two choices
            // k-j-1 -> indicates how many coins left to pick if j = 1 and k=3 then only we have picked up 2 coins from current pile and only 1 coin left to pick
            res = Math.max(res, currCoinSum + helper(i+1, k-j-1, piles, dp));
            
        }
        
        // store for future and return
        return dp[i][k] = res;
    }
}