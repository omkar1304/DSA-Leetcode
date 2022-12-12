// https://leetcode.com/problems/maximum-subarray/



public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i=0; i<nums.length; i++){
            
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}
