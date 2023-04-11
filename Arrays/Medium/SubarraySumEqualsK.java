// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;

// Same as 2 sum problem -> here also we check if sum - k is present in map if yes then get the count of it else put num in map 
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        
        map.put(0,1);
        
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            if(map.containsKey(sum - k))
                count = count + map.get(sum - k);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
