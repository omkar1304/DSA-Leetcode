// https://leetcode.com/problems/longest-mountain-in-array/

public class LongestMountainInArray {
    public int longestMountain(int[] nums) {
        int n = nums.length;
        int ans = 0;
        // i will go from 1 to n-2 only as to find peak element we need left and right neighbour
        int i = 1;
        while(i < n-1){
            // if peak found then do ->
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                int count = 1; // as we found peak element so count = 1 and now we have to expand it and return its count from left and right side
                int j=i;
                // left side
                while(j>0 && nums[j] > nums[j-1]){
                    j--;
                    count++;
                }
                // right side
                
                // why i ? as we know this i will never be peak element as its already part of other peak element length.
                while(i<n-1 && nums[i] > nums[i+1]){
                    i++;
                    count++;
                }
                
                // store max count and return
                ans = Math.max(ans, count);
            }
            // if peak not found then just check for next element
            else{
                i++;
            }
        }
        
        return ans;
    }
}
