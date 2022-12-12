package Medium;

// https://leetcode.com/problems/combination-sum/

import java.util.*;

public class CombinationSum {
    private void helper(int[] nums, int target, List<List<Integer>> ans, List<Integer> temp, int index){
        
        if(index == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(temp));
            }
             return;
        }
        
        if(nums[index] <= target){
            temp.add(nums[index]);
            helper(nums, target-nums[index], ans, temp, index);
            // backtarck
            temp.remove(temp.size() - 1);
        }
        
        helper(nums, target, ans, temp, index+1);
        
    }
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        helper(nums, target, ans, new ArrayList<>(), index);
        return ans;
        
    }
}
