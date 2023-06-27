// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

import java.util.*;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] nums, int difference) {
        // every element is itself longest AP hence min is 1
        int longest = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            // nums[i] - nums[i-1] = diff
            // nums[i] - diff = nums[i-1]
            // if nums[i-1] is already there in map then its already part of AP and add this current nums[i] in that to extent else form new one
            map.put(nums[i], map.getOrDefault(nums[i] - difference, 0) + 1);
            // storing longest
            longest = Math.max(longest, map.get(nums[i]));
        }
        
        return longest;
    }
}
