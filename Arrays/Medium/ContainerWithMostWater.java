// https://leetcode.com/problems/container-with-most-water/



class Solution {
    public int maxArea(int[] nums) {
        
        int l = 0;
        int r = nums.length - 1;
        int currArea = 0;
        int maxArea = 0;
        
        while(l < r){
            currArea = (r - l) * Math.min(nums[l], nums[r]);
            maxArea = Math.max(maxArea, currArea);
            
            if(nums[l] < nums[r])
                l = l + 1;
            else
                r = r - 1;
        }
        
        return maxArea;
    }
}