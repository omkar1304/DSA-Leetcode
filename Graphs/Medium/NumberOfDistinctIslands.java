// https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

class Solution {

    int countDistinctIslands(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // creating visited matrix to keep track of visited cell
        int[][] visited = new int[m][n];
        // to store unique island in set
        Set<ArrayList<String>> set = new HashSet<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // if cell its island then apply DFS on it 
                if(matrix[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    DFS(i, j, matrix, list, i, j, visited);
                    // if list is empty then ignore else store in set
                    if(list.size() > 0){
                        set.add(list);
                    }
                }
            }
        }
    
        // return no of unique island using size of set
        return set.size();
    }
    

    // This funtion is used to store cell co-ordinates in string format    
    String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    
    
    void DFS(int row, int col, int[][] matrix, ArrayList<String> list, int startRow, int startCol, int[][] visited){
        
        // if cell its out of bound or its not island or its visited then return
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == 0 || visited[row][col] == 1){
            return;
        }
        
        // else add in list in string format and mark cell as visited
        
        // here (row - startRow, col - startCol) why ? as we need to count unqiue island so we need to check its shape.
        // if we store drectly row and col then all co-ordinate will be different but now if we subtract them with start co-ordinate from where we started DFS
        // then it will be diff between them and if shapes match then diff will also get matched so store their diff.
        list.add(toString(row - startRow, col - startCol));
        visited[row][col] = 1;
        
        // exlpore all 4 directions
        DFS(row-1, col, matrix, list, startRow, startCol, visited);
        DFS(row+1, col, matrix, list, startRow, startCol, visited);
        DFS(row, col-1, matrix, list, startRow, startCol, visited);
        DFS(row, col+1, matrix, list, startRow, startCol, visited);
    }
    
    
}
