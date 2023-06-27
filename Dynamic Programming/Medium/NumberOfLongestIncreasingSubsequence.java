// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

import java.util.*;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        // making dp array to maintain lognest Increasing subsequence at each index and every single element can divide itself hence adding 1 in it.
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // making count array as we need to track at each index how many LIS present 
        // and every element is itself LIS and count is 1 
        // for example 7 -> LIS : 1 and how many we can form LIS using 7 -> only 1
        // hence fill count array with 1
        int[] count = new int[n];
        Arrays.fill(count, 1);
         
        int max = 1;
        for(int index=0; index<n; index++){
            for(int prev=0; prev<index; prev++){
                // if we get new LIS then at start count will be 1.
                // hence updating same as prev count
                if(nums[index] > nums[prev] && dp[prev] + 1 > dp[index]){
                    dp[index] = dp[prev] + 1;
                    count[index] = count[prev];
                }
                // if we are getting same LIS then add count of both current + prev
                else if(nums[index] > nums[prev] && dp[prev] + 1 == dp[index]){
                    count[index] = count[index] + count[prev];
                }
            }
            max = Math.max(max, dp[index]);
        }
        /*
        after this ->
        nums = [1, 3, 5, 4, 7]
        dp   = [1, 2, 3, 3, 4]
       count = [1, 1, 1, 1, 2]
       
       now here LIS is 4
       so now we just need total from count array at each index which dp[index] = 4
        */
        int res = 0;
        for(int i=0; i<n; i++){
            if(dp[i] == max)
                res = res + count[i];
        }
        
        // return total
        return res;
    }
}
