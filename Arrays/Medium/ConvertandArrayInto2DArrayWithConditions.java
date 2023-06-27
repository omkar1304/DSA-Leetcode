// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/

import java.util.*;

/*
Idea : Count the frequency of elements.The rows in result list we need is equal to the maximum frequency.
*/

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        // creating frequency array
        int[] frequency = new int[nums.length+1];
        for(int num : nums)
            frequency[num]++;
        
        // getting max frequency out of it to make that no of list in result list
        int max = 0;
        for(int f : frequency)
            max = Math.max(max, f);
        
        // as per max frequency creating that no of list in result
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<max; i++)
            result.add(new ArrayList<>());
        
        // now add number in each list of result without repeating duplicates
        for(int num : nums){
            
            for(int i=0; i<max; i++){
                
                // if not contain then only add and then break so it will go for next number.
                // if present then go and check next list
                if(!result.get(i).contains(num)){
                    result.get(i).add(num);
                    break;
                }
            }
        }
        
        return result;
    }
}