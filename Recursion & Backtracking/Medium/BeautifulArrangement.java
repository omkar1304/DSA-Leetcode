// https://leetcode.com/problems/beautiful-arrangement/

package Medium;

public class BeautifulArrangement {
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
    private int helper(int[] nums, int index){
        if(index == nums.length)
            return 1;
        
        int count = 0;
        for(int j=index; j<nums.length; j++){
            
            swap(nums, index, j);
            if(nums[index] % (index+1) == 0 || (index+1) % nums[index] == 0)
                count = count + helper(nums, index+1);
            swap(nums, index, j);
        }  
        return count;
    }
    
    public int countArrangement(int n) {
        
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = i + 1;
        int index = 0;
        return helper(nums, index);
        
    }
}
