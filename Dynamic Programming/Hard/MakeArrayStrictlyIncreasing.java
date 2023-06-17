// https://leetcode.com/problems/make-array-strictly-increasing/

class Solution { 
    
    // Memoization ->
    Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
        
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        // first sort the array2 so we can apply BS to get next immediate value after preVal from array1
        Arrays.sort(arr2);
        
        // apply helper function and get the total cost. if cost is 2001 then its not possible then retrun -1 else return result
        int result = dfs(0, -1, arr1, arr2);
        
        return result < 2_001 ? result : -1;
    }
    
    
    private int dfs(int index, int prev, int[] arr1, int[] arr2) {
        
        // if index is out of bound then return 0 as no need to swap anything
        if (index == arr1.length)
            return 0;
        
        // if present then return
        if (dp.containsKey(new Pair<>(index, prev)))
            return dp.get(new Pair<>(index, prev));

        // at the start assuming total cost is 2001 as per constraints
        int cost = 2_001;

        // If arr1[i] is already greater than prev, we can leave it be.
        if (arr1[index] > prev)
            cost = dfs(index + 1, arr1[index], arr1, arr2);

        // Find a replacement with the smallest value in arr2 using BS
        int swapIndex = bisectRight(arr2, prev);

        // if swapindex is under arr2 then we need to replace that element and it will cost 1. so take min out of it.
        if (swapIndex < arr2.length)
            cost = Math.min(cost, 1 + dfs(index + 1, arr2[swapIndex], arr1, arr2));

        // store for future calculations
        dp.put(new Pair<>(index, prev), cost);
        return cost;
    }
    
    // BS to get next element after target value
    private static int bisectRight(int[] arr, int value) {
        
        int left = 0, right = arr.length;
        
        while (left < right) {
            
            int mid = (left + right) / 2;
            
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    } 
}