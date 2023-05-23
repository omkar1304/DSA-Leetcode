// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        // to store id -> value in map from nums1 and nums2
        Map<Integer, Integer> map = new HashMap<>();
        
        // putting all id and their value in map. if id is repeating then add its value
        for(int[] nums : nums1){
            
            int id = nums[0];
            int value = nums[1];
            
            map.put(id, value);
        }
        
        for(int[] nums : nums2){
            
            int id = nums[0];
            int value = nums[1];
            
            map.put(id, map.getOrDefault(id, 0) + value);
        }
        
        // now we just have to convert map into 2D array
        int[][] result = new int[map.size()][2];
        int index = 0;
        for(int key : map.keySet()){
            result[index] = new int[] {key, map.get(key)};
            index++;
        }
        
        // now sort the array based on ID and return array
        Arrays.sort(result, (a, b) -> a[0] - b[0]);
        return result;
    }
}