// https://leetcode.com/problems/permutations/

package Medium;

import java.util.*;

public class Permutations {
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
    private void helper(int[] nums, List<List<Integer>> ans, int index){
        // base case
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int a : nums)
                temp.add(a);
            ans.add(temp);
            return;
        }
        
        for(int j=index; j<nums.length; j++){
            swap(nums, index, j);
            // reursive call
            helper(nums, ans, index+1);
            // backtrack
            swap(nums, index, j);
        }
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        helper(nums, ans, index);
        return ans;
        
    }
}
