// https://leetcode.com/problems/missing-number/



import java.util.HashMap;

// TC -> O(n) | SC -> O(n) 
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

// TC -> O(n) | SC -> O(1) 
class Solution {
    public int missingNumber(int[] nums) {
        
        int sum=0;
        int n = nums.length;
        
        for(int i=0; i<nums.length; i++)
            sum += nums[i];
        
        return n*(n+1)/2 - sum ; //sum of n natural numbers = n*(n+1)/2
    }
}