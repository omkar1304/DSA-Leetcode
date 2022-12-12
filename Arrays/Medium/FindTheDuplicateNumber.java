// https://leetcode.com/problems/find-the-duplicate-number/

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int slow2 = 0;
        
        // to find intersect element between fast and slow
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);
        
        // to find intersect element between slow and slow2
        do{
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        while(slow != slow2);
        
        return slow;
    }
}

