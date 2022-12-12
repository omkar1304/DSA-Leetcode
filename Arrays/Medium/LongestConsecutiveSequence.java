// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
                                               
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        for(int i=0; i<nums.length; i++){
            if(!(set.contains(nums[i]-1))){
                int len = 0;
                while(set.contains(nums[i]+len))
                    len++;
                longest = Math.max(longest, len);
            }
        }
        
        return longest;
    }
}
