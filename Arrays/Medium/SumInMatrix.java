// https://leetcode.com/problems/sum-in-a-matrix/

import java.util.*;

class Solution {
    public int matrixSum(int[][] nums) {
        
        // to store result
        int result = 0;
        
        // sort row in nums (sort in ascending or desceding order doesnt matter. even if you sort in ascending order you will get same number of pairs from each row)
        for(int[] row : nums)
            Arrays.sort(row);
        
        for(int j=0; j<nums[0].length; j++){
            
            // to store max value at each row
            int innerMax = 0;
            
            for(int i=0; i<nums.length; i++){
                
                innerMax = Math.max(innerMax, nums[i][j]);
            }
            
            // add maximum value from each row in result
            result += innerMax;
        }
        
        return result;
    }
}