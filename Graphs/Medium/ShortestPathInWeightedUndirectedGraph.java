// https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        // creating adj list from edges but here weight is also there so we need to store in form of pair
	    // suppose there is edge between u and v and their cost is wt then it will store like this -> u -> {v, wt}
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        // creating distance array to store shorted distance from src node to every ith node
        int[] dist = new int[n+1];
        for(int i=0; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        // distance from src node to src node is 0
        dist[1] = 0;
        
        // creating parent array to store parent of ith node so we can get that node is coming from which node(parent)
        int[] parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i; // initially we didnt traverse so keeping every node itself as parent
        }
        
        // why PQ not queue? if we use queue then we wil traverse uneccessary path
        // suppose there is path from 1 to 2 which cost 6 and another path from 1 to 3 which cost 5. then that both 2 and 3 pointing to same node 4 with cost 2
        // now we will add (node 2, distance 6) and then we will add (node 3, distance 5) 
        // so for node 1 to go till 4 from node 2 -> total cost will be 1->2->4 = 8 and from node 3 -> 1->3->4 = 7
        // hence if we add node which is costing more then it will end up traversing unncessary path
        // so using PQ we can ensure that which pair having shorted distance will pop out first from PQ so we can follow minimum path
        
        // creating PQ to store pair of (node, distance)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        // adding src node with distance 0 as pair in queue
        pq.offer(new Pair(1, 0));
        
        while(!pq.isEmpty()){
            
            // pop out pair which having shorted distance
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            
            pq.poll();
            
            for(Pair pair : adj.get(node)){
                
                // from adj list take out v and wt to reach v
                int adjNode = pair.node;
                int adjDist = pair.distance;
                
                // in Dijkstra algo instead of checking like -> dist[u] + wt < dist[v] we check with distance which we got from queue along with u
                // distance + adjDist < dist[adjNode] -> same as dist[u] + wt < dist[v]
                
                // if current cost is less then update and add in pq with pair(v, updatedcost)
                // and also update parent value for that v so we can keep track v from which u its coming from
                if(distance + adjDist < dist[adjNode]){
                    
                    dist[adjNode] = distance + adjDist;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                    parent[adjNode] = node;
                }
            }
        }
        
        // create list to store path
        List<Integer> result = new ArrayList<>();
        // if target node is unreachable return list with -1
        if(dist[n] == Integer.MAX_VALUE){
            result.add(-1);
            return result;
        }
        
        // else keep moving from target node to src node using untill we get value where parent[node] = node 
        // which is nothing but src node as its dosent have any parent
        int node = n;
        while(parent[node] != node){
            
            result.add(0, node);
            node = parent[node];
        }
        result.add(0, node);
        return result;
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