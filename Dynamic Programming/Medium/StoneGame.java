// https://leetcode.com/problems/stone-game/

public class StoneGame {
    public int helper(int[] nums, int start, int end, char turn, int[][] dp){
        // base case
        
        // if start goes beyond end then no element in array so totalScore is 0 hence return 0
        if(start > end)
            return 0;
        
        // if both are pointing to same element means only 1 element is left in array so return that
        if(start == end)
            return nums[start];
        
        // if present then return
        if(dp[start][end] != -1)
            return dp[start][end];
        
        int totalScore = 0;
        // if adding then take max as value its plus
        // if subtracting then take min as value its negative
        // here we are adding score of A and substracting score of B so and the end if we get +val then A wins or -neg value then B wins
        // if its A's turn then two choice we have -> get score from start or end and take max of it and solve next
        if(turn == 'A')
            totalScore = Math.max(nums[start] + helper(nums, start+1, end, 'B', dp), nums[end] + helper(nums, start, end-1, 'B', dp));
        // if its B's turn then two choice we have -> get score from start or end and take min of it and solve next
        else
            totalScore = Math.min(-nums[start] + helper(nums, start+1, end, 'A', dp), -nums[end] + helper(nums, start, end-1, 'A', dp));
        
        // storing for future use
        return dp[start][end] = totalScore;
    }
    
    public boolean stoneGame(int[] nums) {
        // Memoization ->
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i=0; i<nums.length+1; i++){
            for(int j=0; j<nums.length+1; j++){
                dp[i][j] = -1;
            }
        }
        
        int res = helper(nums, 0, nums.length-1, 'A', dp);
        // if res +ve then A wins else B wins
        return res > 0 ? true : false;
    }
}
