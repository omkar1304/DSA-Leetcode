// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

/*
This problem can be solved with a binary search.

For every row do the binary search to find exact position of the fist negative element, after that all elements are negative. Optimization here - for every next row the right limit for the binary search can be the index of the first negative from the previous row. This is due to fact that cols are also sorted so for the same column for every negative element the element below can be only negative. Thus we can explude it from the binary search on the next step.

Also taking care of the edge cases helps - if first element is < 0 then all elements in a row are negative, if last one is non-negative then all elements are non-negative.

O(rows x lg(cols)) time - need to do lg(cols) binary search for each of rows row, O(1) space - no extrace space other than few variables.
*/

class Solution {
    public int countNegatives(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int result = 0;
        int lastNeg = n - 1;
        
        for(int row=0; row<m; row++){
            
            //check edge cases - if first element is < 0 - all elements in row are negative
            if(grid[row][0] < 0){
                result += n;
                continue;
            }
            
            //if last element is positive - it means there are no negative numbers in a row
            if(grid[row][n-1] > 0){
                continue;
            }
            
            //there is a mix of negative and positive ones, need to find the border. so binary search to row
            int low = 0;
            int high = lastNeg;
            
            while(low <= high){
                
                int mid = (low + high) / 2;
                
                if(grid[row][mid] < 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            
            // now the low will give the starting negative index of neg no. so using this index we can get no of neg in row.
            // Also if that index is neg then its entire col will be neg in down side. so update lastNeg so we can avoid previous and decrese row size for BS
            result += (n - low);
            lastNeg = low;
            
            
        }
        
        return result;
    }
}