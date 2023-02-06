// https://leetcode.com/problems/course-schedule-ii/

class Solution {
    // here we can apply topological sort as we can consider 1, 0 as u -> v 
    // As we know topoligcal sort only applicable when graph is CAG if not then in topo array all nodes will not cover
    // hence if count == no of nodes then there is no cycle else there is cycle
    // so if true then return topo array else return empty array
    
    public int[] findOrder(int n, int[][] matrix){
        
        // convert prerequisites into adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        int m = matrix.length;
        for(int i=0; i<m; i++)
            adj.get(matrix[i][1]).add(matrix[i][0]);
        
        // Creating inDegree array to store no of incoming edges to node
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            for(int neighbour : adj.get(i)){
                inDegree[neighbour] = inDegree[neighbour] + 1;
            }
        }
        
        // queue to store node which having inDegree value 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        // here we will keep topo array as well as counter
        int[] result = new int[n];
        int index = 0;
        int count = 0;
        
        while(!queue.isEmpty()){
            
            int node = queue.peek();
            queue.poll();
            // add in topo array and also inc counter by 1
            result[index] = node;
            index++;
            count++;
            
            for(int neighbour : adj.get(node)){
                
                // reduce count of inDegree of neighbour by 1 (remove one edge)
                inDegree[neighbour] = inDegree[neighbour] - 1;
                
                // if it becomes 0 then add in queue else continue
                if(inDegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }
        
        // so if true then return topo array else return empty array
        return count == n ? result : new int[0];
    }
}