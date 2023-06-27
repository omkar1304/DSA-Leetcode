// https://leetcode.com/problems/find-smallest-letter-greater-than-target/


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int n = letters.length;
        
        // array is sorted in ascending order so if last element is equal or less than traget then its not possible to find next greater element so return start element of array
        if(letters[n-1] - 'a' <= target - 'a')
            return letters[0];
        
        // else apply BS to char array
        int low = 0;
        int high = n-1;
        
        while(low <= high && high >= 0 && low <= n-1){
            
            int mid = (low + high) / 2;
            
            // if mid element is greater then target then its maybe or maybe not next greater element in letters so try to search it in left side
            if(letters[mid] - 'a' > target - 'a')
                high = mid - 1;
            // if its lower than target then search in right side
            else
                low = mid + 1;
        }
        
        // at the end low will give next greater element so return it
        return letters[low];
    }
}