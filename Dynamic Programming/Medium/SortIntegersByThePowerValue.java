// https://leetcode.com/problems/sort-integers-by-the-power-value/

public class SortIntegersByThePowerValue {
    public int helper(int x, int[] dp){
        
        // base case
        
        // if x == 1 then no need do any action hence return 0
        if(x == 1)
            return 0;
        
        // if present then return 
        if(dp[x] != -1)
            return dp[x];
        
        // if x != -1 then based on even or odd calculate recursively and store for future use.
        return dp[x] = 1 + (x%2==0 ? helper(x/2, dp) : helper(3*x+1, dp));
    }
    
    
    public int getKth(int lo, int hi, int k) {
        // Memoization ->
        int[] dp = new int[1000000];
        Arrays.fill(dp, -1);
        
        // creating 2d array which defines relation -> [number, powervalue]
        int[][] powerList = new int[hi-lo+1][2];
        // Calculating and building powerList array with number and powervalue
        for(int i=lo; i<=hi; i++){
            powerList[i-lo][0] = i;
            powerList[i-lo][1] = helper(i, dp);
        }
        
        // sorting based on powervalue 
        Arrays.sort(powerList, (a,b) -> a[1] - b[1]);
        
        // returning kth value as given in question
        return powerList[k-1][0];
        
    }
}
