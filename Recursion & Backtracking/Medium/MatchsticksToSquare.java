// https://leetcode.com/problems/matchsticks-to-square/

package Medium;

import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean helper(int[] nums, int[] sides, int len, int index){
        if(index == nums.length)
            return true;
        
        
        for(int j=0; j<4; j++){
            if(sides[j] + nums[index] <= len){  // to check if it is exceeding len or not
                sides[j] = sides[j] + nums[index]; // if not then add and check for next matchstick
                if(helper(nums, sides, len, index+1)) // if it returns true then fine
                    return true;
                sides[j] = sides[j] - nums[index]; // if false then remove it. (backtrack)
            }
        }
        
        return false; // if everything is done then return false.
    }
    
    
    public boolean makesquare(int[] nums) {
        // sort array in descending order ->
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1, tmp; i < j; i++, j--) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        
        int[] sides = new int[4];
        int len = 0;
        int sum = 0;
        // to calculate sum
        for(int a : nums) sum = sum + a;
        
        // if it is not divisible then can't go further.
        if(sum % 4!=0) return false;
        
        len = sum / 4;
        int index = 0;
        
        return helper(nums, sides, len, index);
    }
    
}
