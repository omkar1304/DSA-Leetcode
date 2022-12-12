// https://leetcode.com/problems/find-peak-element/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] < nums[mid+1]) low = mid+1;
            else high = mid;
        }
        
        return low;
    }
}
