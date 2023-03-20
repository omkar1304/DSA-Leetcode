// https://leetcode.com/problems/maximal-network-rank/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        // creating degree array to store degree of each node
        int[] degree = new int[n];
        
        // creating array of connected to check if i node is connected to j node or not
        boolean[][] connected = new boolean[n][n];
        
        //budiling degree and connected array based on roads array
        for(int[] road : roads){
            
            degree[road[0]]++;
            degree[road[1]]++;
            
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        
        // to store max network rank
        int result = 0;
        
        // itrate through every node and compare thier pair and add both degree value and check if its connected then subtract 1 from result as it will create duplicate road if both are connected else return as it is. 
        for(int i=0; i<n; i++){
            
            for(int j=i+1; j<n; j++){
                
                result = Math.max(result, degree[i] + degree[j] - (connected[i][j] == true ? 1 : 0));
            }
        }
        
        return result;
    }
}