// https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

class Solution {
    
    // Bellman-Ford Algorithm -> it uses to find shortest path from src to any node.
    // same as Dijkstra algo but here we can also play with neg wt which is not possible in dijkstra.
    // here we are doing same as Dijkstra, we have to perform relaxation if dist[u] + wt < dist[v] but here instead of getting nodes from queue or PQ we need to run loop for n-1 times
    
    // why n-1 times ? we have n nodes so except start node we need to find dist for other node. and if in worst case suppose there is path as below
    // 1 -> 2 -> 3 -> 4 and adj list given in reverse order like (3, 4, -1), (2, 3, 2), (1, 2, -2) => (u, v, wt)
    // so here at first loop will get dist of 2 then next loop will get dist of 3 and in next loop will get dist 4 so in 3 loop we got dist of all 4 nodes 
    // henece for n node we required n-1 loops.
    
    // bellman ford algo also used to detect neg cycle -> if even after n-1 iteration dist[v] is getting updated by dist[u] + wt then there is neg cycle
    
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> adj, int src) {
        
        // creating dist array to store minimum cost at every node from src node
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)(1e8); // given max value
        }
        dist[src] = 0; // initially distance from src to src is 0
        
        // as per bellman ford algo we need run loop n-1 times to update dist for every node
        for(int i=0; i<n-1; i++){
            for(ArrayList<Integer> it : adj){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt; // relaxation
                }
                
            }
        }
        
        // to detect cycle we need run loop one more time after n-1 if dist[v] get updated then return -1
        for(ArrayList<Integer> it : adj){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
                
            }
        }
        
        // else return dist 
        return dist;
    }
}
