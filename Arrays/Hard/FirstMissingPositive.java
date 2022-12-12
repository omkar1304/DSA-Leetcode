// https://leetcode.com/problems/first-missing-positive/

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // to take care of numbers between 1 to n
        for(int i=0; i<n; i++){
            if(nums[i] <= 0 || nums[i] > n)
                nums[i] = n + 1;
        }
        
        // to mark number as negative which are present
        for(int i=0; i<n; i++){
            int id = Math.abs(nums[i]);
            if(id > n)
                continue;
            id = id - 1;
            if(nums[id] > 0)
                nums[id] = -nums[id];
        }
        
        
        // to check which number is positive and return as its not present 
        for(int i=0; i<n; i++){
            if(nums[i] > 0)
                return i+1;
        }
        return n+1;
    }
}
