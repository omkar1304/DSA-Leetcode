// https://leetcode.com/problems/permutations-ii/

package Medium;

import java.util.*;

public class Permutations2 {
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, Map<Integer, Integer> map){
        
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int num : map.keySet()){
            int count = map.get(num);
            
            if(count > 0){
                
                temp.add(num);
                map.put(num, count - 1);
                
                // recursive call
                helper(nums, res, temp, map);
                
                //backtrack
                temp.remove(temp.size() - 1);
                map.put(num, count);
            }
            
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : nums){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        helper(nums, res, new ArrayList<>(), map);
        return res;
        
    }
}
