// https://leetcode.com/problems/3sum/


import java.util.*;

public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3)
            return ans;
        int sum;
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++){
            // to remove same element for i 
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // to remove same element for j
                    while(j<nums.length-1 && nums[j] == nums[j+1])
                        j = j + 1;
                    // to remove same element for k
                    while(k<0 && nums[k] == nums[k-1])
                        k = k - 1;
                    
                    j = j + 1;
                    k = k - 1;
                }

                else if(sum < 0)
                    j = j + 1;
                else
                    k = k - 1;
            }  
        }
        return ans;
    }
}
