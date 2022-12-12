// https://leetcode.com/problems/missing-number/



import java.util.HashMap;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){   
            map.put(nums[i], 1);
        }
        for(int i=0; i<nums.length; i++){
            
            if(!map.containsKey(i))
                ans = i;
        }
        return ans;
    }
}
