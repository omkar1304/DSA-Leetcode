// https://leetcode.com/problems/split-array-largest-sum/

public class SplitArrayLargestSum {
    public int helper(int[] nums, int partition, int index, int[][] dp){
        // base case
        
        // if only one partition is need to made then simply retrun sum of array from index to nums length
        if(partition == 1){
            int sum = 0;
            for(int i=index; i<nums.length; i++)
                sum = sum + nums[i];
            return sum;
        }
        
        // if present then return
        if(dp[partition][index] != -1)
            return dp[partition][index];
        
        // here we need to make parttion lets say partition = 2 so we can divide array into 2 parts 
        // assume its left and right part and we need to take max out of it(which has higher sum) and store in temp
        // and need to repeat this at every index we need try and split array into 2 and need to get max out of all temp ans
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        // nums.length - partition -> as we know  to make partition how many index we can actaully traverse
        for(int i=index; i<=nums.length-partition; i++){ 
            sum = sum + nums[i];
            // calculating left and right and take out max out of it
            int left = sum;
            int right = helper(nums, partition-1, i+1, dp);
            int temp = Math.max(left, right);
            // storing max out of all temp
            ans = Math.min(ans, temp);
        }
        
        // storing for future use
        return dp[partition][index] = ans;
    }
    
    
    public int splitArray(int[] nums, int k) {
        // Memoization ->
        int[][] dp = new int[k+1][nums.length+1];
        for(int i=0; i<k+1; i++){
            for(int j=0; j<nums.length+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(nums, k, 0, dp);
        
    }
}
