// https://leetcode.com/problems/longest-continuous-increasing-subsequence/



public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1)
            return 1;
        
        int maxCount = 0;
        int c = 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] < nums[i+1])
                c++;
            else
                c = 1;
            
            maxCount = Math.max(maxCount, c);
        }

        return maxCount;
        
    }
}
