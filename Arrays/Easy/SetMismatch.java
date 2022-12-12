// https://leetcode.com/problems/set-mismatch/


import java.util.*;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
         int z;
         int i;
         HashMap<Integer, Integer> map = new HashMap<>();
         Arrays.sort(nums);
         
         for(i=1; i<nums.length; i++){
             if(nums[i-1] == nums[i])
                 break;
         }
         
         res[0] = nums[i];
         for(int j: nums){
             map.put(j,j);
         }
         
         for(z=1; z<=nums.length; z++){
             if(!(map.containsKey(z)))
                 break;
         }
         res[1] = z;
         
         return res;
         
     }
}
