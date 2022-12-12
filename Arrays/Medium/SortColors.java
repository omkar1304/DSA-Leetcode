// https://leetcode.com/problems/sort-colors/

public class SortColors {
    
    // 1 pass
    public void sortColors(int[] nums) {
    
        int zeroidx = 0;
        int twoidx = nums.length - 1;
        int index = 0;
        
        while(index <= twoidx){
            
            if(nums[index] == 0){
                swap(nums, zeroidx, index);
                zeroidx++;
                index++;
            }
            else if(nums[index] == 2){
                swap(nums, twoidx, index);
                twoidx--; 
            }
            else
                index++;
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 2 pass

    public void sortColors2(int[] nums) {
        // 2-pass
        int count0 = 0, count1 = 0, count2 = 0;
        System.out.println(count2);  
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {count0++;}
            if (nums[i] == 1) {count1++;}
            if (nums[i] == 2) {count2++;}
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }
}
