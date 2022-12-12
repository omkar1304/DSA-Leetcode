// https://leetcode.com/problems/largest-divisible-subset/

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n = nums.length;
        // sorting array so we can check if prev element can divide current index or not.
        Arrays.sort(nums);
        // making dp array to maintain lognest divsible subsequence at each index and every single element can divide itself hence adding 1 in it.
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // to store index of each updated prev value so we can move back and print or store in list one by one
        int[] hash = new int[n];
        
        int max = 1; // to get max LDS(longest divisble subsequence);
        int lastIndex = 0; // to keep index of element who has longest divisible subseq.
        
        // same as LIS just small change where we needed increasing that why -> nums[index] > nums[prev]
        // here we need divisble -> nums[index] % nums[prev] == 0
        for(int index=0; index<n; index++){
            hash[index] = index;
            for(int prev=0; prev<index; prev++){
                if(nums[index] % nums[prev] == 0 && dp[prev] + 1 > dp[index]){
                    dp[index] = dp[prev] + 1;
                    hash[index] = prev;
                }
            }
            
            if(dp[index] > max){
                max = dp[index];
                lastIndex = index;
            }
        }
        
        // for example 
        //     nums -> [5, 4, 11, 1, 16, 8]
        // hence dp -> [1, 1,  2, 1,  3, 2]
        //     hash -> [0, 1,  0, 3,  2, 5]
        // now you got hash and lastIndex just follow and store each value in list until you get lastIndex = hash[lastIndex]
        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        while(lastIndex != hash[lastIndex]){
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
       // we are getting from LDS from lastIndex to first so reverse it and return
        Collections.reverse(list);
        return list;
        
    }
}
