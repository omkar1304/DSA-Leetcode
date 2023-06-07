// https://leetcode.com/problems/semi-ordered-permutation/

class Solution {
    public int semiOrderedPermutation(int[] nums) {
        /*
        Find the ith index of min val 1 => we need to do i operation to move 1 to first position
Find the ith index of the max val n => we need to do (n - i - 1) operation to take it to last position
Take the sum of above two as the answer. Only corner case is when the ith index of 1 is larger than ith index of n - in this case we need to reduce the ans by 1 as the 1 & n cna be swapped at the same time so that we count it as 1 operation in place of 2.
        */
        
        int minIndex = -1;
        int maxIndex = -1;
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            
            if(nums[i] == 1)
                minIndex = i;
            if(nums[i] == n)
                maxIndex = i;
        }
        
        // if minIndex < maxIndex then both are in seprate postion(not going to colide) example 1 so for 1 it will require minIndex swap and for n it will require n - 1(0th index) - maxIndex
        // if minIndex > maxIndex then both are coliding example 2. when we move 1 from that position to get at start so while moving n to last we need to do -1 as 1 already moved.
        
        return minIndex < maxIndex ? (minIndex + (n - 1 - maxIndex)) : (minIndex + (n - 1 - maxIndex) - 1);
    }
}