// https://leetcode.com/problems/shortest-path-with-alternating-colors/

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        // creating result array to store shortest dist from 0 to other nodes
        int[] res = new int[n];
        Arrays.fill(res,-1);
        
        // creating adjlist for red and blue edges
        Map<Integer,ArrayList<Integer>> redMap = new HashMap<>();
        Map<Integer,ArrayList<Integer>> blueMap = new HashMap<>();
        
        for(int[] e: redEdges) {
            int src = e[0];
            int dst = e[1]; 
            redMap.putIfAbsent(src, new ArrayList<>());
            redMap.get(src).add(dst);   
        }
        
        for(int[] e: blueEdges) {
            int src = e[0];
            int dst = e[1];
            blueMap.putIfAbsent(src, new ArrayList<>());
            blueMap.get(src).add(dst);
        }
        
        // creating visited set for both red and blue
        Set<Integer> redVisited = new HashSet<>();
        Set<Integer> blueVisited = new HashSet<>();
        
        // adding starting node 0 in queue with length = 0 and color = null
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0,"null"));
        
        while(queue.size() > 0) {
            
            // poping out node, length, color
            int node = queue.peek().node;
            int len = queue.peek().len;
            String color = queue.peek().color;
            
            queue.poll();
            
            // as length going to inc by 1 so if visit node fist time it will be shortest only so update it
            if(res[node] == -1)
                res[node] = len;
            
            // if color is not red and that node is present in red map then apply BFS in red
            if(!color.equals("red") && redMap.containsKey(node)){
                for(int nbr: redMap.get(node)) {
                    if(!redVisited.contains(nbr)) {
                        redVisited.add(nbr);
                        queue.add(new Pair(nbr,len+1,"red"));
                    }
                }
            }
            
            // if color is not blue and that node is present in blue map then apply BFS in blue
            if(!color.equals("blue") && blueMap.containsKey(node)){
                for(int nbr: blueMap.get(node)) {
                    if(!blueVisited.contains(nbr)) {
                        blueVisited.add(nbr);
                        queue.add(new Pair(nbr,len+1,"blue"));
                    }
                }
            }
        }
        
        // return updated result array
        return res;
    }
}

class Pair {
        
    int node;
    int len;
    String color;

    public Pair(int node,int len,String color) {
        this.node = node;
        this.len = len;
        this.color = color;
    }  
}