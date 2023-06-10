// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        // to store index value 
        long result = 0;
        
        // calculting how many length of array is there in left and right side from index element
        int emptyL = index;
        int emptyR = n - 1 - index;
        
        // we have to place value at index which has range of 1 to maxSum so we can apply linear search to it but it will take time so we can do binary search here. we find mid and take sum of right array and left array then check if its going greater than maxSum then we have to find index value before mid so shift high else if sum is less then we need to find in right side so shift low
        int low = 1;
        int high = maxSum;
        
        while(low <= high){
            
            int mid = (high + low) / 2;
            
            // at every mid choice we need find left and right sum
            long leftSum = 0;
            long rightSum = 0;
            long element = mid - 1;
            
            // to find sum we can use math formaula -> s = (n * (n + 1)) / 2 so here if element > emptyR means suppose we have element 8 but empty right is 5 then we have to discard sum of last three elements so we can calculate sum of element and then subtract remaining sum from it. If element > emptyR means suppose element is 3 but empty right 5 then we have duplicates of 1's in last element so we can calculate sum of elment + no of duplicate 1 (emptyR - element)
            // same thing we can do for leftsum
            
            // to calculate right sum ->
            if(emptyR <= element)
                rightSum = (element * (element + 1))/2 - ((element - emptyR) * (element - emptyR + 1))/2;
            else
                rightSum = (element * (element + 1))/2 + (emptyR - element);
            
            // to calculate left sum ->
            if(emptyL <= element)
                leftSum = (element * (element + 1))/2 - ((element - emptyL) * (element - emptyL + 1))/2;
            else
                leftSum = (element * (element + 1))/2 + (emptyL - element);
            
            // total sum
            long sum = leftSum + mid + rightSum;
            
            
            // BS logic -> if sum is less then store in result and move right side
            if(sum <= maxSum){
                low = mid + 1;
                result = mid;
            }
            // else move it to left side
            else{
                high = mid - 1;
            }
                
        }
        
        return (int)result;
    }
}