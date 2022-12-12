// https://leetcode.com/problems/partition-array-for-maximum-sum/

public class PartitionArrayForMaximumSum {
    public int helper(int[] arr, int k, int i, int j, int[] dp){
        // base case
        
        // if i crosses j then we dont have any array so max we can return is 0
        if(i > j)
            return 0;
        
        // if present then return
        if(dp[i] != -1)
            return dp[i];
        
        
        int maxAns = 0;
        // to run partition in k size window 
        for(int p=i; p<=Math.min(j, i+k-1); p++){
            // getting max value from partition array
            int currMax = Integer.MIN_VALUE;
            for(int q=i; q<=p; q++)
                currMax = Math.max(currMax, arr[q]);
            // now we know we have to update every value in partition window with max value
            // hence if we have 3 size window and max value is 15 then partition window sum is 
            // 15+15+15 i.e. 15 * 3 this is how we calculate left and right will takw care by recursive call
            int left = currMax * (p - i + 1);
            int right = helper(arr, k, p+1, j, dp);
            // and store max ans between already stored maxans and addition of left and right
            maxAns = Math.max(maxAns, left + right);
        }
        
        // storing for future use
        return dp[i] = maxAns;
    }
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Memoization ->
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -1);
        
        return helper(arr, k, 0, arr.length-1, dp);
        
    }
}
