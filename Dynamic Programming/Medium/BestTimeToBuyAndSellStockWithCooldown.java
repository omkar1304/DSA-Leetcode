// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

public class BestTimeToBuyAndSellStockWithCooldown {
    public int helper(int[] prices, int day, int buy, int[][] dp){
        // base case
        
        // if we day goes out of prices then we dont have any stock left hence max profit is 0
        if(day >= prices.length)
            return 0;
        
        // if present then return
        if(dp[day][buy] != -1)
            return dp[day][buy
                           
        // we can buy - 1 , we can sell - 0
        // now we have two choice if we can buy or sell
                           
        // if we can buy then we again have two option buy(then subtract prices as its debited ) or skip it to next day
        if(buy == 1)
            return dp[day][1] = Math.max(-prices[day] + helper(prices, day+1, 0, dp), helper(prices, day+1, 1, dp));
        // if we can sell then we again we have two oprion sell(add prices as its credited) and move to next to next day as we cant immediately buy or dont sell and skip to next day
        else
            return dp[day][0] = Math.max(prices[day] + helper(prices, day+2, 1, dp), helper(prices, day+1, 0, dp));
        // return max as we need max profit.
    }
    
    public int maxProfit(int[] prices) {
        //Memoization ->
        int[][] dp = new int[prices.length+1][2];
        for(int i=0; i<prices.length+1; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(prices, 0, 1, dp);
    }
}
