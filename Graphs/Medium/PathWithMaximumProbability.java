// https://leetcode.com/problems/path-with-maximum-probability/

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        // create adj list with pair -> (node, prob)
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());        
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        
        // creating dist array to store max prob at every node and marking start node with 1 and start to start prob is always 1
        double[] dist = new double[n];
        for(int i=0; i<n; i++)
            dist[i] = -1;
        dist[start] = 1;
        
        // creating PQ to apply Dijkstra algo but here we need to get max so reverse the condition -> max heap to get max prob first
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder((a, b) -> Double.compare(a.prob, b.prob)));
        // add start node with 1 prob as pair
        pq.offer(new Pair(start, 1));
        
        while(!pq.isEmpty()){
            
            // pop out node with prob from PQ
            int u = pq.peek().node;
            double prob = pq.peek().prob;
            
            pq.poll();
            
            // if that node is end then simply return its prob as we know we are storing max at every node so using dijkstra will reach to end witg max prob. in future path which leads to dest node will return prob either same or less than
            if(u == end)
                return prob;
            
            // else start looking for its neighbours from adj list
            for(Pair pair : adj.get(u)){
                
                int v = pair.node;
                double vprob = pair.prob;
                
                // if dist[u] * vprob is greater than update in dist[v] and add in queue
                if(dist[u] * vprob > dist[v]){
                    
                    dist[v] = dist[u] * vprob;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        
        // if not possible return 0
        return 0;
    }
}

class Pair{
    
    int node;
    double prob;
    
    public Pair(int node, double prob){
        
        this.node = node;
        this.prob = prob;
    }
}

