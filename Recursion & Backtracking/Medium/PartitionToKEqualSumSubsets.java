// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

package Medium;

// it will give TLE ->
public class PartitionToKEqualSumSubsets {
    public boolean helper(int[] nums, int k, int[] selected, int reqSum, int nbucket,int bucketSum, int index){
        
        // base cases 
        if(nbucket == k) 
            return true;
        if(bucketSum == reqSum)
            return helper(nums, k, selected, reqSum, nbucket+1, 0, 0);
        if(bucketSum > reqSum)
            return false;
        if(index == nums.length) 
            return false;
        
        
        if(selected[index] == 1){
            return helper(nums, k, selected, reqSum, nbucket, bucketSum, index+1);
        }
        else{
            //pick 
            selected[index] = 1;
            bucketSum = bucketSum + nums[index];
            boolean op1 = helper(nums, k, selected, reqSum, nbucket, bucketSum, index+1);
            
            //skip
            selected[index] = 0;
            bucketSum = bucketSum - nums[index];
            boolean op2 = helper(nums, k, selected, reqSum, nbucket, bucketSum, index+1);
            
            return op1 || op2;
        }
    }
    
    
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int[] selected = new int[nums.length];
        int sum = 0;
        for(int a : nums) sum = sum + a;
        if(sum % k != 0) return false;
        int reqSum = sum / k;
        int nbucket = 0;
        int index = 0;
        int bucketSum = 0;
        return helper(nums, k, selected, reqSum, nbucket, bucketSum, index);
        
        
    }
}

// optimal solution ->
class Solution {
    public boolean helper(int a[], int target, int index, int bucket[]){
        
        //we have taken all the elements
        if(index == -1)
            return true;
        
        //start filling the buckets
        for(int j=0; j<bucket.length; j++){
            
            //can we take this ith element
            if(bucket[j]+a[index] <= target){
            
                //if we take this element
                bucket[j] = bucket[j] + a[index];
                
                //go to next element (in our case go to smallest ele bcz we sorted)
                //if we can fill all buckets then return true
                if(helper(a, target, index-1, bucket))
                    return true;
                
                //means we can't fill other buckets if we take ith element so leave this element
                bucket[j] = bucket[j] - a[index];;
            
            }
            
            //if our bucket is empty means we have not taken any elements in the buckets
            if(bucket[j]==0)
                break;
        
        }
        
        //all buckets are full but i is pointing to some element (elements still left)
        //or our bucket is empty means we haven't take any element (not valid)
        return false;
    
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum=0;
        for(int i:nums){
            sum = sum + i;
        }
        
        //sum%k must equal to 0 if not just return false
        //if we have to to divide the array greater than array size retun false(we can't)
        if(sum%k!=0 || nums.length<k) return false;
        
        //sort so we can take last element and start filling our bucket
        Arrays.sort(nums);
        
        //our target is sum/k and we have to find this in nums, k times then it is valid
        int bucket[] = new int[k];
        int target = sum / k;
        return helper(nums, target, nums.length-1, bucket);
    
    }
    
}