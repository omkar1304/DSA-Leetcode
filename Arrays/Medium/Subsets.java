// https://leetcode.com/problems/subsets/

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(nums, new ArrayList<>(), 0, res);
        return res;
    }
    
    public void helper(int[] nums, List<Integer> temp, int i, List<List<Integer>> res){
        
        if(i >= nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[i]);
        helper(nums, temp, i+1, res);
        
        temp.remove(temp.size() - 1);
        helper(nums, temp, i+1, res);
        
    }
}
