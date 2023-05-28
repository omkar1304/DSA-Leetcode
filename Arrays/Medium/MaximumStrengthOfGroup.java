// https://leetcode.com/problems/maximum-strength-of-a-group/

class Solution {
    public long maxStrength(int[] nums) {
        
        long sum = 1;
        int count = 0;
        int max = Integer.MIN_VALUE;
        
        // if only one element then return that element
        if(nums.length == 1)
            return nums[0];
        
        // now iterate over nums. if element is 0 then update count else store the strength
        for(int i=0; i<nums.length; i++){
            
            if(nums[i] == 0)
                count++;
            else
                sum = sum * nums[i];
        }
        
        // if sum is positive then return it
        if(sum > 1)
            return sum;
        
        // if only two elements then return max value
        if(nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        
        // if all zeroes then return 0
        if(count == nums.length-1)
            return 0;
        
        // else now sum is negative and we just need to remove one negative value from it. if we divide that then we can remove it easily so in negative large is nothing but from 0 that is -1 and -9 so max is -1 here. iterate over array and get the max negative value which is smaller abs value and remove it from strength
        else{
            
            for(int i=0; i<nums.length; i++)
                if(nums[i] < 0)
                    max = Math.max(max, nums[i]);
        }
        
        // removing max negative value (smallest abs value) from sum
        return sum / max;
    }
}