// https://leetcode.com/problems/sum-of-all-subset-xor-totals/

public class SumOfAllSubsetXORTotals {
    public int helper(int[] nums, int index, int currXOR){
        // return currentXor when all elements in nums are already considered
        if(index == nums.length)
            return currXOR;
        
        // calculate sum of xor with current element
        int pick = helper(nums, index+1, currXOR ^ nums[index]);
        // calculate sum of xor without current element
        int skip = helper(nums, index+1, currXOR);
        
         // return sum of xors from recursion
        return pick + skip;
    }
    
    public int subsetXORSum(int[] nums) {
        
        return helper(nums, 0, 0);
    }
}
