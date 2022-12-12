// https://leetcode.com/problems/longest-turbulent-subarray/

public class LongestTurbulentSubarray {
    class Solution {
        public int maxTurbulenceSize(int[] nums) {
            int n = nums.length;
            
            // if 1 element in array then it is itself max hence return 1
            if(n == 1)
                return 1;
            // if 2 elements in array and they are like x > y or x < y then form 2 size of subarray
            if(n == 2 && nums[0] != nums[1])
                return 2;
            // else if they are equal x == y then only single element is max subarray hence return 1
            else if(n == 2 && nums[0] == nums[1])
                return 1;
            
            // to store previous value
            int[] dp = new int[n];
            // first elements itself subarray hence storing 1
            dp[0] = 1;
            
            int max = 0;
            for(int index=1; index<n-1; index++){
                
                // if we get x < y > z pattern then we can add prev + 1 value in current as its continuation from previous cells
                if(nums[index-1] < nums[index] && nums[index] > nums[index+1])
                    dp[index] = dp[index-1] + 1;
                
                // if we get x > y < z pattern then we can add prev + 1 value in current as its continuation from previous cells
                else if(nums[index-1] > nums[index] && nums[index] < nums[index+1])
                    dp[index] = dp[index-1] + 1;
                
                // if we get pattern like this x = y = z then no turbulent array found hence 0
                else if(nums[index-1] == nums[index] && nums[index] == nums[index+1])
                    dp[index] = 0;
                
                // if no pattern found then element itself turbulent hence 1
                else
                    dp[index] = 1;
                
                // storing max and why dp[index] + 1?
                // as we know we getting pattern not only because of prev but also using index+1 thats next 
                // suppose we get x > y < z then y value will be 2 but we have to return 3 as 3 points involved in this pattern(by adding next part)
                max = Math.max(max, dp[index] + 1);
            }
            
            // return max
            return max;
        }
    }
}
