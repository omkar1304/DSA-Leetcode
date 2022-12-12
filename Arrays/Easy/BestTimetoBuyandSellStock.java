
//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimetoBuyandSellStock {
    
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sell = 1;
        
        while (sell < prices.length){
            if(prices[buy] > prices[sell]){
                buy = sell;
                sell = sell + 1;
            }
            else{
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
                sell = sell + 1;
            }
        }      
        return maxProfit; 
    }
}
