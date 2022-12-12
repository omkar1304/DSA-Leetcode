// https://leetcode.com/problems/jump-game-ii/

public class JumpGame2 {
    public int helper(int[] nums, int index, int[] dp){
        
        // if index reacehed to last position then no need to jump. return 0
        if(index >= nums.length - 1)
            return 0;
        
        // if present then return
        if(dp[index] != -1)
            return dp[index];
        
        // storing length of nums as we know max jump will be upto length
        int min = nums.length - 1;
        // j will start from 1 jump to value i.e. nums[index]
        for(int j=1; j<=nums[index]; j++){
            // adding 1 as we use 1 jump and need to go next index position which is index + j 
            int ans = 1 + helper(nums, index+j, dp);
            // storing min out of it
            min = Math.min(min, ans);
        }
        
        // return min
        return dp[index] = min;
    }
    
    public int jump(int[] nums) {
        // Memoization ->
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        
        return helper(nums, 0, dp);
    }
}
