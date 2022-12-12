// https://leetcode.com/problems/partition-equal-subset-sum/

public class PartitionEqualSubsetSum {
    public boolean subsetSum(int[] nums, int sum, int n){
        boolean[][] dp = new boolean[n+1][sum+1];
        
        //intializatioin ->
        
        // if array -> i is zero then we cant get required sum hence false(except zero      
        for(int j=0; j<sum+1; j++)
            dp[0][j] = false;
         // if sum is zero then we can get subset by not ioncluding any values hence true   
        for(int i=0; i<n+1; i++)
            dp[i][0] = true;
        
         // fill remaining ->
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                
                if(nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][sum];
    }
    
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++)
            sum = sum + nums[i];
        
        if(sum % 2 !=0)
            return false;
        else
            return subsetSum(nums, sum/2, n);
    }
}
