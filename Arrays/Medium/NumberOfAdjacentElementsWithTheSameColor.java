// https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color/

class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        
        // creating nums to check colors 
        int[] nums = new int[n];
        // to count adjacent element
        int adjCount = 0;
        // creating answer array to return
        int[] answer = new int[queries.length];
        // to iterate as per query for answer
        int i = 0;
        
        for(int[] query : queries){
            
            // popping out index and color from query
            int index = query[0];
            int color = query[1];
            
            // before updating color check if both are same and adjacent color != 0 then decrement adjCount by 1
            
            // left side adjacent ->
            if(index > 0 && nums[index-1]!= 0 && nums[index-1] == nums[index] && adjCount > 0)
                adjCount--;
            // right side adjacent ->
            if(index < n-1 && nums[index+1]!= 0 && nums[index+1] == nums[index] && adjCount > 0)
                adjCount--;
            
            // update the color
            nums[index] = color;
            
            // after updating color check if both are same then increment adjCount by 1
            
            // left side adjacent ->
            if(index > 0 && nums[index-1] == nums[index])
                adjCount++;
            // right side adjacent ->
            if(index < n-1 && nums[index+1] == nums[index])
                adjCount++;
            
            // put adjCount value at ith in answer array
            answer[i] = adjCount;
            i++;
        }
        
        return answer;
    }
}