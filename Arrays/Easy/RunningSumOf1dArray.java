// https://leetcode.com/problems/running-sum-of-1d-array/



public class RunningSumOf1dArray {
    
    public int[] runningSum(int[] nums) {
        
        int i = 1;
        while(i<nums.length){
            nums[i] = nums[i] + nums[i-1];
            i++;
        }
        
        return nums;
        
    }
}
