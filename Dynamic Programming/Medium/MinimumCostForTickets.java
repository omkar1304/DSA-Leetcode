// https://leetcode.com/problems/minimum-cost-for-tickets/

import java.util.Arrays;

public class MinimumCostForTickets {
    public int helper(int[] days, int[] costs, int index, int[] dp){
        // base case
        
        // if index goes out of days then no days left hence cost is zero
        if(index >= days.length)
            return 0;
        
        // if present then return
        if(dp[index] != -1)
            return dp[index];
        
        // Calculate all three days cost for every days and return min of it(Three choice)
        
        // oneday cost -> add cost and increment index by 1 as need to check next day in days 
        int onetDay = costs[0] + helper(days, costs, index+1, dp);
        
        // here we have 7 days so after buying 7days pass we can cover days[k] + 7 days hence covering all days and adding cost of 7days and check further
        int k = index;
        while(k < days.length && days[k] < days[index] + 7)
            k++;
        int sevenDay = costs[1] + helper(days, costs, k, dp); 
        
        // here we have 30 days so after buying 30days pass we can cover days[k] + 30 days hence covering all days and adding cost of 30days and check further  
        k = index;
        while(k < days.length && days[k] < days[index] + 30)
            k++;
        int thrityDay = costs[2] + helper(days, costs, k, dp);
        
        // finally return  min of all three costs
        return dp[index] = Math.min(thrityDay, Math.min(onetDay, sevenDay));
    }
    
    public int mincostTickets(int[] days, int[] costs) {
        // Memoization ->
        int[] dp = new int[days.length+1];
        Arrays.fill(dp, -1);
        
        return helper(days, costs, 0, dp);
        
    }
}
