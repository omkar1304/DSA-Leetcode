// https://leetcode.com/problems/minimize-maximum-of-array/

class Solution {
    public int minimizeArrayValue(int[] nums) {
        /*
        Suppose we have array -> [3, 7, 1] so here if we have to decrese max value in array 
        so will pick 7 and reduce it to 6 but then 3 will get inc by 1 so it will become array -> [4, 6, 1]. now if we again we have max 6 so we repeat same process then it will become array -> [5, 5, 1]. Lets observe here that even we are decresing value of max and inc value of prev element total sum is remains same here which is 10 if we consider (3, 7) and at the end also its is 10 with(5,5). so we are just transfering value from max elemet to its previous element so it becoms equal. if we go further then array will become this -> [6,4, 1] so it will keep on loop we have to stop where both element will be equal so we can take avg of it. so at every index will take avg of sum array and that will return our result and we have to return max avg as its will show that we have reduced max value to avg value.
        */
        
        long total = 0;
        long result = 0;
        
        for(int i=0; i<nums.length; i++){
            total += nums[i];
            result = Math.max(result, (total+i)/(i+1));
        }
        
        return (int)result;
    }
}