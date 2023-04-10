// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        // form color length we can get no of nodes are there
        int n = colors.length();
        
        // creating adj list and indegree for every node
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            inDegree[v]++;
        }
        
        // creating to pefrom BFS + topological sort
        Queue<Integer> queue = new LinkedList<>();
        
        // adding node in queue which having indegree value 0
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        
        // creating count 2D array to store count of each single color at node
        int[][] count = new int[n][26];
        
        // adding initial color value to node which given in question
        for(int i=0; i<n; i++){
            int colorIndex = colors.charAt(i) - 'a';
            count[i][colorIndex]++;
        }
        
        // to check if all nodes are visited if not then there is cycle so we can return -1
        int visitedNodeCount = 0;
        // to store most frequent color value
        int maxColorValue = 0;
        
        /*
        Here what we doing is first consider this as tree where we passing all color information from root to leaf(parent to child node). Here root node is nothing but node which having indegree value 0.So we will start apply BFS to those node and calculate most frequent color value at that node and store it in maxColorValue. Now node is ready pass this information to its child. while passing node we have to take maximum color count between parent and child node. Once edge case is if color of child is same as color which we are passing then we have to add +1 in it as every child has it own color.once we finish that check if indegree of child is 0 if it is then this child is taken color information from all its parent so we can add it in queue else check next node. Keep repeating this untill queue becomes empty and return maxColorValue at the end which store most frequent color at every node.
        */
        
        while(!queue.isEmpty()){
            
            // poping out element from queue and mark it as visited by inc count
            int u = queue.peek();
            queue.poll();
            visitedNodeCount++;
            
            // store most frequent color in maxColorValue at current node
            for(int i=0; i<26; i++)
                maxColorValue = Math.max(maxColorValue, count[u][i]);
            
            // pass information to its childeren 
            for(Integer v : adj.get(u)){
                
                // for every color which is max 26(a-z)
                for(int colorIdx=0; colorIdx<26; colorIdx++){
                    
                    // get the max between paren and child and also check if current color is same child color then add 1 else 0
                    int vcolorIdx = colors.charAt(v) - 'a';
                    count[v][colorIdx] = Math.max(count[v][colorIdx], count[u][colorIdx] + (colorIdx == vcolorIdx ? 1 : 0));
                    
                }
                 
                // remove indegree by 1 as we complete one edge by passing info from parent to child
			    inDegree[v]--;
                // if all parents are done for this child then add in queue
                if(inDegree[v] == 0)
                   queue.offer(v);   
            }
        }
        
        // if all visited then return maxColorValue else its cycle return -1
        return visitedNodeCount == n ? maxColorValue : -1;
    }
}