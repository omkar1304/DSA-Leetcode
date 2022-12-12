// https://leetcode.com/problems/subsets-ii/

package Medium;

import java.util.*;

public class Subsets2 {
    public void helper(int[] nums, int index, List<Integer> temp, List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        // include
        temp.add(nums[index]);
        helper(nums, index+1, temp, res);
        
        // exclude
        temp.remove(temp.size() - 1);
        
        // to avoid duplicates -> ignore and move to next 
        while(index+1 < nums.length && nums[index] == nums[index+1])
            index++;
        
        helper(nums, index+1, temp, res);
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
}
