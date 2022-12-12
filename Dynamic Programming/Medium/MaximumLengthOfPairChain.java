// https://leetcode.com/problems/maximum-length-of-pair-chain/

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] nums) {
        // sorting array based on jth value so we can form chain by chcecking prev jth value and current ith value
        Arrays.sort(nums, (a,b) -> (a[1] - b[1]));
        // count = 1 as every single cell itself part of chain
        int count = 1;
        // storing max as first cell jth index
        
        /*
        for example nums = [[1,2],[7,8],[4,5]]
        after sorting = [[1,2], [4,5], [7,8]]
        now our goal is to make chain by considering jth of prev cell < ith of currrent cell
        max = 2, now we need check if next cell ith is greater or not if yes then update max and increasing count -> 1,2 -> 4,5 and now max is 5(as we need to store jth as max to check ith of next)
        at the end 1,2 -> 4,5 -> 7,8 hence count 3
        */
        int max = nums[0][1];
        for(int index=1; index<nums.length; index++){
            if(max < nums[index][0]){
                max = nums[index][1];
                count = count + 1;
            }
        }
        
        return count;
    }
}
