// https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals/

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        
        // getting dimensions and creating ans array
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] ans = new int[m][n];
        
        // iterate over every cell in grid
        for(int i=0; i<m; i++){
            
            for(int j=0; j<n; j++){
                
                // to store distinct elements from topLeft and bottomRight
                Set<Integer> topLeft = new HashSet<>();
                Set<Integer> bottomRight = new HashSet<>();
                
                // to travel top-left diagonal -> 
                int row = i - 1;
                int col = j - 1;
                while(row >= 0 && col >= 0){
                    topLeft.add(grid[row][col]);
                    row--;
                    col--;
                }
                
                // to travel bottom-right diagonal ->
                row = i+1;
                col = j+1;
                while(row < m && col < n){
                    bottomRight.add(grid[row][col]);
                    row++;
                    col++;
                }
                
                // based on size of topLeft and bottomRight we can get no of distinct elements in respective diagonals and store it in ans cell
                ans[i][j] = Math.abs(topLeft.size() - bottomRight.size());
            }
        }
        
        return ans;
    }
}