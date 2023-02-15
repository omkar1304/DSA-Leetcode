// https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

class Solution
{
// Floyd Warshall -> Dijkstra and bellman ford algos are for single shortest path but to find shortest path from every node to every node i.e. multi source we can use flyod warshall algo
// FW can be use to work with negative weights and also it helps to find negative cycle

// supose there is edge between i to j and we are currently counting shortest for k then we need to find path via k so i to j will be i to k + k to j
// same as DJ and BF algo we need to store min value in dist array -> matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
// so we need to apply as k for every node so TC -> O(n^3)

// to detect neg cycle we need to observe one thing that we know from i to i dist will always be 0. after applying FW then if i to i distance gets changed to neg then there is neg cycle
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        
        // to replace -1 with Integer.MAX_VALUE
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // Applying FW algo ->
        for(int k=0; k<n; k++){ // via node
            for(int i=0; i<n; i++){ // u node
                for(int j=0; j<n; j++){ // v node
                    // if there is no path then leave it
                    if(matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    
                    // else put min out of it
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        // To detect neg cycle ->
        // for(int i=0; i<n; i++){
        //     if(matrix[i][i] < 0){
        //         System.out.println("There is neg cycle")
        //     }
        // }
        
        // to put original value -1 in place of Integer.MAX_VALUE
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == Integer.MAX_VALUE){
                    matrix[i][j] = -1;
                }
            }
        }
        
    }
}