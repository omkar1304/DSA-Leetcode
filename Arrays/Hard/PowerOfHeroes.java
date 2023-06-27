// https://leetcode.com/problems/power-of-heroes/

// refer this video -> https://www.youtube.com/watch?v=e_z5_nr5KdA

import java.util.*;
class Solution {
    
    int mod = 1000000007;
    
    public int sumOfPower(int[] nums) {
        
        long ans = 0;
        long previosContri = 0;
        
        Arrays.sort(nums);
        
        for(long num: nums){
            //            (max * max) * min                 // (max * max) * prevContris (prev min contribution in all subsequence)
            ans = (ans + ((num * num) % mod * num) % mod + ((num * num) % mod * previosContri) % mod) % mod;
            previosContri = (previosContri * 2 + num) % mod;
        }
        return (int)ans;
    }
}