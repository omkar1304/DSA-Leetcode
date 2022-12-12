// https://leetcode.com/problems/combination-sum-ii/

package Medium;

import java.util.*;

public class CombinationSum2 {
    private void helper(int[] nums, int target, List<List<Integer>> ans, List<Integer> temp, int index){
        // base case
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        if(target<=0) return;
        
        
        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            
            temp.add(nums[i]);
            //recursive call
            helper(nums, target-nums[i], ans, temp, i+1);
            //backtrack
            temp.remove(temp.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, target, ans, new ArrayList<>(), 0);
        return ans;
        
    }
}
