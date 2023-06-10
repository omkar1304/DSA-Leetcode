// https://leetcode.com/problems/sum-of-square-numbers/

class Solution {
    public boolean judgeSquareSum(int c) {
        
        // we know that if c = 5 then we only have to go from 0 to 2 as sqrt(5) ~= 2. (even if consider more than 2 then suppose 3*3 = 9 false and so on ...)
        // two edge cases -> 1. 0 can be the part of it and 2. both no can be the same
        long left = 0;
        long right = (long)Math.sqrt(c);
        
        // left <= right as both number can be the same
        while(left <= right){
            
            // calculate the value 
            long value = (left * left) + (right * right);
            
            // if value exact same then return true
            if(value == c)
                return true;
            
            // if smaller then update left by 1 
            else if(value < c)
                left++;
            
            // else its greater then decrease right by 1
            else
                right--;
        }
        
        // if we come out of loop then its impossible so return false
        return false;
    }
}