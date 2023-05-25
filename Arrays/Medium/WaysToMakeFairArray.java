// https://leetcode.com/problems/ways-to-make-a-fair-array/

class Solution {
    public int waysToMakeFair(int[] nums) {
        
        // to count fair array 
        int count = 0;
        
        // We will split the array into two parts, left and right for even and odd 
        int[] left = new int[2];
        int[] right = new int[2];
        
        // Firstly we count the sum to an array right, where right[0] = A[0] + A[2] +...and right[1] = A[1] + A[3] +.. Baiscally storing even sum at 0th index and odd sum at 1th index
        for(int i=0; i<nums.length; i++){
            
            if(i%2 == 0)
                right[0] = right[0] + nums[i];
            else
                right[1] = right[1] + nums[i];
        }
        
        // now we will traverse through each num in nums to remove and check fair
        for(int i=0; i<nums.length; i++){
            
            // as its needs to remove so we are removing that num from sum of even/odd based on index value
            right[i % 2] = right[i % 2] - nums[i];
            
            // if both same then its fair. then update the count by 1
            if(left[0] + right[1] == left[1] + right[0])
                count++;
            
            // now adding that removed element in left array of sum of even/odd for future calculation 
            left[i % 2] = left[i % 2] + nums[i];
        }
        
        return count;
    }
}