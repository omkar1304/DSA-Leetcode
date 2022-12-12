// https://leetcode.com/problems/happy-number/

class Solution {
    public int helper(int number){
        // here we just finding sum of squares of digits of number
        int ans = 0;
        while(number > 0){
            int rem = number % 10;
            ans = ans + (rem * rem);
            number = number / 10;
        }
        
        return ans;
    }
    
    public boolean isHappy(int n) {
        // Two pointers ->
        int slow = n;
        int fast = n;
        
        // if slow and fast meets at same ans then if that ans is 1 then this happy 
        // else its not
        // hence will keep this loop until they meet
        do{
            slow = helper(slow); // moving slow by 1 function 
            fast = helper(helper(fast)); // moving fast by 2 function
        }while(slow != fast);
        
        return slow == 1 ? true : false;
        
    }
}