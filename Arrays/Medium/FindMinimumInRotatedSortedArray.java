// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high){
            int mid = (low + high) / 2;
            
            if(mid > 0 && mid < nums.length && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid+1])
                return nums[mid];
            else if(nums[mid] <= nums[high])
                high = mid - 1;
            else 
                low = mid + 1;
        }
        
        return nums[low];
    }
}
