// https://leetcode.com/problems/longest-arithmetic-subsequence/

import java.util.*;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        //minimum sequence is 2 because any two numbers can be a sequence for ex: 1,2 or 1,10 or 2,7 it is a sequence
        int n = nums.length;
        int max = 2;
        
         //define an array of hashmaps for a difference with previous numbers - hashmap key as difference, value as a counter -> {diff, occurance count of that diff}
        // dp = [{}, {}, {}, {}, {} ....]
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        //                   int [] dp = new int[n] -> same as this 
        
        //outer loop - interate through numbers
        for(int i=0; i<n; i++){
            // creating hashmap at each index -> dp = [ {}, ...]
            dp[i] = new HashMap<>();
             //iterate from beginning to find a difference with all previous numbers
            for(int j=0; j<i; j++){
               // get the diff
                int diff = nums[i] - nums[j];
                 //for the difference, look in the "i"th hashmap if that difference exist, if it does, increment the counter
                //dp: [{},{1:2},{2:2,3:2},{3:3,5:2,6:2},{1:2,4:2,6:2,7:2}] check 3:3 for 4, 7, 10
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                //take max 
                max = Math.max(max, dp[i].get(diff));
                
            }
        }
        
        return max;
    }
}
