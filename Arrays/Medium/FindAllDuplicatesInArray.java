// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.*;

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            int value = Math.abs(nums[i]);
            
            if(nums[value - 1]  > 0)
                nums[value - 1] *= -1;
            else
                ans.add(value);
        }
        
        return ans;
    }
}
