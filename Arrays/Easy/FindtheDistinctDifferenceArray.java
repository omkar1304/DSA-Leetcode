// https://leetcode.com/problems/find-the-distinct-difference-array/

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        
        // creating result array 
        int n = nums.length;
        int[] result = new int[n];
        
        // creating frequency table for prefix and suffix numbers in nums
        Map<Integer, Integer> prefix = new HashMap<>();
        Map<Integer, Integer> suffix = new HashMap<>();
        
        // Initially, prefix is empty, and suffix contains frequency of complete array.
        for(int number: nums)
            suffix.put(number, suffix.getOrDefault(number, 0) + 1);
        
        // iterating over every element in nums
        for(int i=0; i<n; i++){
            
            int number = nums[i];
            
            // Now, for each index i, remove nums[i] from suffix and add to prefix
            prefix.put(number, prefix.getOrDefault(number, 0) + 1);
            suffix.put(number, suffix.get(number) - 1);
            
            // if count of number is 0 in suffix then remove that key from suffix
            if(suffix.get(number) == 0)
                suffix.remove(number);
            
            // at every step get diff of size of prefix and suffix map
            result[i] = prefix.size() - suffix.size();
        }
        
        return result;
    }
}