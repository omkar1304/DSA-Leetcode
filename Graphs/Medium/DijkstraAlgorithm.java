// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

// Djkstra algo only works with positive distance 

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {   
        // creating distance array to store shorted distance from src node to every ith node
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        // distance from src node to src node is 0
        dist[src] = 0;
        
        // why PQ not queue? if we use queue then we wil traverse uneccessary path
        // suppose there is path from 1 to 2 which cost 6 and another path from 1 to 3 which cost 5. then that both 2 and 3 pointing to same node 4 with cost 2
        // now we will add (node 2, distance 6) and then we will add (node 3, distance 5) 
        // so for node 1 to go till 4 from node 2 -> total cost will be 1->2->4 = 8 and from node 3 -> 1->3->4 = 7
        // hence if we add node which is costing more then it will end up traversing unncessary path
        // so using PQ we can ensure that which pair having shorted distance will pop out first from PQ so we can follow minimum path
        
        // creating PQ to store pair of (node, distance)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        // adding src node with distance 0 as pair in queue
        pq.offer(new Pair(src, 0));
        
        while(!pq.isEmpty()){
            
            // pop out pair which having shorted distance
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            
            pq.poll();
            
            for(int i=0; i<adj.get(node).size(); i++){
                
                // from adj list take out v and wt to reach v
                int adjNode = adj.get(node).get(i).get(0);
                int adjDist = adj.get(node).get(i).get(1);
                
                // in Dijkstra algo instead of checking like -> dist[u] + wt < dist[v] we check with distance which we got from queue along with u
                // distance + adjDist < dist[adjNode] -> same as dist[u] + wt < dist[v]
                
                // if current cost is less then update and add in pq with pair(v, updatedcost)
                if(distance + adjDist < dist[adjNode]){
                    
                    dist[adjNode] = distance + adjDist;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        
        // TC -> O(E x logV)
        return dist;
        
    }
}


class Pair{
    
    int node;
    int distance;
    
    public Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
