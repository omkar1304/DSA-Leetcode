// https://leetcode.com/problems/cycle-length-queries-in-a-tree/

class Solution {
    public int[] cycleLengthQueries(int n, int[][] nums) {
        
        // creating result to store distance of each query
        int[] res = new int[nums.length];
        
        for(int index=0; index<nums.length; index++){
            
            // fetching out two query values a,b
            int num1 = nums[index][0];
            int num2 = nums[index][1];
            
            // creating totolPath to keep total of no of path
            int totolPath = 0;
            
            // now here we need to find LCA of num1 and num2 as we know here node values are arranged in such way that parent = child / 2 so we will keep dividing both node until they become same so thats LCA. while dividing check which num is greather and divide that so we moving upword in any case so inc count of totolPath by 1
            while(num1 != num2){
                
                if(num1 > num2)
                    num1 = num1 / 2;
                else
                    num2 = num2 / 2;
                
                totolPath = totolPath + 1;
            }
            
            // now we got totolPath and add 1 in it as we need to add edge between num1 and num2 so that edge we need to count and store in result
            res[index] = totolPath + 1;
        }
        
        // at the end return result
        return res;
    }
}