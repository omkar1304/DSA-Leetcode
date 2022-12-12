// https://leetcode.com/problems/russian-doll-envelopes/

public class RussianDollEnvelopes {
    public int lowerBound(List<Integer> tempList, int target){
        // this method is used to get lowebound index from list
        int start = 0;
        int end = tempList.size() - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(tempList.get(mid) < target)
                start = mid + 1;
            else
                end = mid;      
        }
        
        return start;
    }
    
    public int maxEnvelopes(int[][] nums) {
        // sort the array based on width in increasing order 
        // but if width are same then ? we need to sort height in descending order. why?
        // if cells like these -> [3,4], [3,5], [3,7] then we need to first take 7 height as it can store max envelopes.
        Arrays.sort(nums, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        // now we just have to make consider on height -> so now problem reduced to 1D array
        
        // creating list to store sequence and adding first element as it can consider as first sequence
        List<Integer> tempList = new ArrayList<>();
        tempList.add(nums[0][1]);
        
        // starting from 1 to n as we already added 0th element in list
        for(int i=1; i<nums.length; i++){
            // suppose list -> [2,5] and now we have 7 then just simply add 7 at back side
            // -> [2,5,7] to form increasing subsequence
            if(nums[i][1] > tempList.get(tempList.size() - 1))
                tempList.add(nums[i][1]);
            // but if that element is smaller than last element then we have to replace
            // [2,7] and element is 5 -> replace 7 with 5 -> [2,5]
            // now why? because even if we get greater element in future we know that if its greater than 7 then it can be greater than 5 so sequence can maintain and what if we receive height 6 then we cant form using 7 right so if we have 5 it can be possible.
            else{
                int index = lowerBound(tempList, nums[i][1]);
                tempList.set(index, nums[i][1]);
            }
        }
        
        // return length of list 
        return tempList.size();
    }
}
