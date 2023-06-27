// https://leetcode.com/problems/maximum-alternating-subsequence-sum/

// TC - O(N) SC - O(N)

class Solution {
    public long helper(int[] nums, int index, int state, long[][] dp){
        // base case
        
        // if index goes out of bound then return 0
        if(index >= nums.length)
            return 0;
        
        // if present then return
        if(dp[index][state] != -1)
            return dp[index][state];
        
        // we have to choice 
        // either pick with condition if even position then add value if odd then subtract and change state value 
        // or just skip with as it is state value
        
        // pick 
        long total = state == 0 ? nums[index] : -1 * nums[index];
        long pick = total + helper(nums, index+1, state^1, dp);
        
        // skip 
        long skip = helper(nums, index+1, state, dp);
        
        // return max out of it
        return dp[index][state] = Math.max(pick, skip);
    }
    
    
    public long maxAlternatingSum(int[] nums) {
        // Memoization ->
        int n = nums.length;
        
        long[][] dp = new long[n+1][2];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }
        
        // at start position always be even only hence passing state as 0
        return helper(nums, 0, 0, dp);
    }
}

// TC - O(N) SC - O(1)

class Solution1 {
    public long maxAlternatingSum(int[] nums) {
        /*
        It's dp-like problem,
        we need to iterate the input A,
        and keep two variable odd and even.
        even means the maximum alternating sum ending with a even index
        odd means the maximum alternating sum ending with a odd index

        For each element a in A,
        we can update even from odd + a
        even = max(even, odd + a),
        and the same we can update odd from even - a.

        Note that even ends with a positive,
        odd end with a negative,
        so we always have even >= odd
        */
        long even = 0;
        long odd = 0;
        
        for(int i=0; i<nums.length; i++){
            even = Math.max(even, odd + nums[i]);
            odd = even - nums[i];
        }
        
        return even;
    }
}