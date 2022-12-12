// https://leetcode.com/problems/single-number/



public class SingleNumber {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            sum = sum ^ nums[i]; // XOR 
        }
        return sum;
    }
}
