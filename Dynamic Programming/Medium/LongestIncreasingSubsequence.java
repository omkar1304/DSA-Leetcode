// https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        // every single number is increasing subsequenece hence filling 1 in array
        Arrays.fill(res, 1);
        
        // to check increasing subsequenece(IS) we need to start from second number in array
        // as we already filled array with 1 value for individual number
        for(int i=1; i<nums.length; i++){
            // now from 0 to i-1 we need to check if there is IS or not
            for(int j=0; j<i; j++){
                // nums[i] > nums[j] -> if this true then only will get res[i] <= res[j]
                // res[i] <= res[j] -> thats means we found IS and higher value in nums should contain less or equal value in res if yes then we can update with j value as we found IS
                // if not less value means we already have IS with different j then no need to update
                if(nums[i] > nums[j] && res[i] <= res[j])
                    res[i] = 1 + res[j];
            }
        }
        
        // return max out of res array.
        
        int max = 0;
        for(int i=0; i<nums.length; i++)
            max = Math.max(max, res[i]);

        
        return max;
        
        /*
        if question says to print any LIS then use res array
        for example -> nums = [5,8,7,1,9] then res = [1,2,2,1,3]
        now traverse through res array and get index of all increamneting values in res
        then respectively get all values from that index and return 
        for example -> [1,2,2,1,3] -> will get [1,2,3] -> respective values in nums -> [5,8,9] or [5,7,9]
        
        */
    }
}


// Optimal solution -> dp + binary search

class Solution {
    public int lowerBound(List<Integer> list, int target){
         // this method is used to get lowebound index from list
        int start = 0;
        int end = list.size() - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(list.get(mid) < target)
                start = mid + 1;
            else
                end = mid;
        }
        
        return start;
    }
    
    public int lengthOfLIS(int[] nums) {
         // creating list to store sequence and adding first element as it can consider as first sequence element
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        
        // starting from 1 to n as we already added 0th element in list
        for(int i=1; i<nums.length; i++){
            // suppose list -> [2,5] and now we have 7 then just simply add 7 at back side
            // -> [2,5,7] to form increasing subsequence
            if(nums[i] > list.get(list.size() - 1))
                list.add(nums[i]);
            else{
            // but if that element is smaller than last element then we have to replace
            // [2,7] and element is 5 -> replace 7 with 5 -> [2,5]
            // now why? because even if we get greater element in future we know that if its greater than 7 then it can be greater than 5 so sequence can maintain and what if we receive height 6 then we cant form using 7 right so if we have 5 it can be possible.
                int index = lowerBound(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        
        // return length of list 
        return list.size();
    }
}

// to print LIS ->

class HelloWorld {
    public static int helper(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int lastIndex = 0;
        int max = 1;
        for(int index=0; index<n; index++){
            hash[index] = index;
            for(int prev=0; prev<index; prev++){
                if(nums[index] > nums[prev] && dp[prev] + 1 > dp[index]){
                    dp[index] = dp[prev] + 1;
                    hash[index] = prev;
                }
            }
            if(dp[index] > max){
                max = dp[index];
                lastIndex = index;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        while(lastIndex != hash[lastIndex]){
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
            
        }
        
        for(int a : list){
            System.out.print(a + " ");
        }
        System.out.println("");
        return max;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {5, 4, 11, 1, 16, 8};
        
        // System.out.println(helper(nums));
        helper(nums);
    }
}