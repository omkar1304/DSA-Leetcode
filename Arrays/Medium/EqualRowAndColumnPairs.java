// https://leetcode.com/problems/equal-row-and-column-pairs/

class Solution {
    public int equalPairs(int[][] grid) {
        
        
        int n = grid.length;
        
        // part 1 : Store every row as string in row in map to create frequence table
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<n; j++){
                
                sb.append(grid[i][j]);
                sb.append("+");
            }
            
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

        }
        
        // part 2 : now check if any column as string is present in map if yes then we got pair so we get the value from map and add in result;
        int result = 0;
        
        for(int j=0; j<n; j++){
            
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<n; i++){
                
                sb.append(grid[i][j]);
                sb.append("+");
        
            }
            
            result = result + map.getOrDefault(sb.toString(), 0);
        }
        
        return result;
    }
}