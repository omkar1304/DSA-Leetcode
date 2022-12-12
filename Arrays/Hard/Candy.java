// https://leetcode.com/problems/candy/

import java.util.Arrays;

public class Candy {
    public int candy(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        for(int i=1; i<n; i++)
            left[i] = nums[i] > nums[i-1] ? left[i-1] + 1 : left[i];
        
        for(int i=n-2; i>=0; i--)
            right[i] = nums[i] > nums[i+1] ? right[i+1] + 1 : right[i];
        
        for(int i=0; i<n; i++)
            sum = sum + Math.max(left[i], right[i]);
            
        return sum;
    }
}
