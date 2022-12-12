// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/


class Solution {

    public int helper(int[] prices, int fee, int index, int buy, int[][] dp){

         // base case

        

        // if we day goes out of prices then we dont have any stock left hence max profit is 0

        if(index >= prices.length)

            return 0;

        

        // if present then return

        if(dp[index][buy] != -1)

            return dp[index][buy];

        

        // two choice we have -> make transaction and do not make transaction

        

        // No transaction today

        int op1 = helper(prices, fee, index+1, buy, dp);

        

        // transaction today 

        int op2 = 0;

        // if buy == 1 then we can have to buy stock 

        // of if buy == 0 then we can sell stock with loss of fee

        if(buy == 1)

            op2 = -prices[index] + helper(prices, fee, index+1, 0, dp);

        else

            op2 = prices[index] - fee + helper(prices, fee, index+1, 1, dp);

        

        // return max out of two option

        return dp[index][buy] = Math.max(op1, op2);

    }

    

    public int maxProfit(int[] prices, int fee) {

        // Memoization ->

        int[][] dp = new int[prices.length+1][2+1];

        for(int i=0; i<prices.length+1; i++){

            for(int j=0; j<2+1; j++){

                dp[i][j] = -1;

            }

        }

        

        return helper(prices, fee, 0, 1, dp);

    }

}