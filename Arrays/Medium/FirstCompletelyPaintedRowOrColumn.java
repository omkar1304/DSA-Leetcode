// https://leetcode.com/problems/first-completely-painted-row-or-column/

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        // create map that stores position of element cell wise
        Map<Integer, int[]> map = new HashMap<>();
        
        for(int i=0; i<m; i++){
            
            for(int j=0; j<n; j++){
                
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        
        // creating row and col array to deteremine whether entire row/col is painted or not.
        int[] row = new int[m];
        int[] col = new int[n];
        
        for(int i=0; i<arr.length; i++){
            
            // getting its row and col from map
            int[] cell = map.get(arr[i]);
            int rowNumber = cell[0];
            int colNumber = cell[1];
            
            // updating as painted with inc by 1
            row[rowNumber]++;
            col[colNumber]++;
            
            // if row or col is completed at index i then return that index
            // Note: row will get painted horizontally hence row == n not m. same for col
            if(row[rowNumber] == n || col[colNumber] == m)
                return i;
        }
        
        // else return -1 if not possible
        return -1;
    }
}