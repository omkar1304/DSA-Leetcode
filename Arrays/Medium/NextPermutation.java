// https://leetcode.com/problems/next-permutation/

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length <= 1)
            return;
        
        int i = nums.length - 2;
       // to find index of having less value than its next value
        while(i>=0 && nums[i] >= nums[i+1])
            i--;

       // if i == -1 -> array in descending order
       // if not then find firt largets value than nums[i]
        if(i>=0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i])
                j--;
          swap(nums, i, j);  
        }
        
        reverse(nums, i+1, nums.length-1);
    }
    
   private void swap(int[] arr, int i, int j) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
   }
   
   private void reverse(int arr[], int left, int right) {
       while(left < right) {
           swap(arr, left++, right--);
       }
   }
}
