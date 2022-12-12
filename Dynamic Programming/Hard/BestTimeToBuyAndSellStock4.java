// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

public class BestTimeToBuyAndSellStock4 {
    public int helper(int[] prices, int day, int transactionsLeft, int[][] dp){
        // base case 
        
        // if day goes out of bound then 0 profit hence return 0
        if(day >= prices.length)
            return 0;
        
        // if no transactions left to do then return 0
        if(transactionsLeft == 0)
            return 0;
        
        // if present then return
        if(dp[day][transactionsLeft] != -1)
            return dp[day][transactionsLeft];
        
        // No transaction today
        int op1 = helper(prices, day+1, transactionsLeft, dp);
        
        // transaction today 
        int op2 = 0;
        // if transactionsLeft is even then we can buy if odd then we can sell
        boolean buy = transactionsLeft % 2 == 0 ? true : false;
        if(buy)
            op2 = -prices[day] + helper(prices, day+1, transactionsLeft-1, dp);
        else
            op2 = prices[day] + helper(prices, day+1, transactionsLeft-1, dp);
        
        // return max out of both option and store for future use
        return dp[day][transactionsLeft] = Math.max(op1, op2);
    }
    public int maxProfit(int k, int[] prices) {
        
        int[][] dp = new int[prices.length+1][2*k+1];
        for(int i=0; i<prices.length+1; i++){
            for(int j=0; j<2*k+1; j++){
                dp[i][j] = -1;
            }
        }
        // why 2*k ? to make 1 transaction we need to buy and sell hence to passking 2*k so it will complete transcation till buy to sell.
        return helper(prices, 0, 2*k, dp);
        
    }
}
