// https://leetcode.com/problems/sliding-subarray-beauty/

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        
        int n = nums.length;
        
        // as per constraints -50 <= nums[i] <= 50 so we can create frequency of negative number at every window
        int[] freq = new int[50];
        
        // to store beauty at each window 
        int[] result = new int[n - k + 1];

        // storing frquency count of negatives numbers of starting window with length of k
        for(int i=0; i<k; i++){  
            if(nums[i] < 0){
                freq[nums[i] + 50]++;
            }     
        }
        
        // traverse from 0 to n-k
        for(int i=0; i<n-k+1; i++){
            
            // get the beauty of current window using frequency array of negavtive number
            for(int j=0, count=0; j<50; j++){
                
                // storing frequency count in count variable
                count = count + freq[j];
                
                // if count is greater than or equal to x then we got xth smallest negative number as we are moving from left to right. for example -50, -49, -48, .....
                if(count >= x){
                    // store beauty value in result and break the loop
                    result[i] = j - 50;
                    break;
                }
            }
            
            // now we have to slide the window so count of current nums[i] has to remove from frequency if its negative
            if(nums[i] < 0)
                freq[nums[i] + 50]--;
            
            // once we do slide to next window we have to add nums[i+k] count in frequency if its < n and its negative
            if(i+k < n && nums[i + k] < 0)
                freq[nums[i+k] + 50]++;
        
        }
        
        return result;
    }
}