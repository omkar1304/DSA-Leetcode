// https://practice.geeksforgeeks.org/problems/rod-cutting0840/1

public class RodCutting {
    public int cutRod(int price[], int n) {
        //code here
        
        // building wt array same s knapsack problem
        int[] wt = new int[n];
        for(int i=0; i<n; i++)
            wt[i] = i + 1;
            
        // now we have same input as knapsack problem
        /*
            knapsack -> rod cuttting
            
            wt[]      -> wt[]
            value[]   -> price[]
            c (capacity) -> N (capacity)
            
            and we know we can cut same size of road hence its unbounded knapsack problem
        */
        
        // here size of capacity and array length is same if array length diff then instead of n+1 mention array.length+1
        int[][] dp = new int[n+1][n+1];
        
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(wt[i-1] <= j)
                    dp[i][j] = Math.max(price[i-1] + dp[i][j - wt[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][n];
    }
}
