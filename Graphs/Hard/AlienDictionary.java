// https://practice.geeksforgeeks.org/problems/alien-dictionary/1

class Solution
{
    public String findOrder(String [] dict, int n, int letters){
        
        // creating adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<letters; i++){
            adj.add(new ArrayList<>());
        }
        
        // converting letters of strings into adj integer pattern to apply toposort
        for(int i=0; i<n-1; i++){
            
            String s1 = dict[i];
            String s2 = dict[i+1];
            // to avoid out of index error
            int len = Math.min(s1.length(), s2.length());
            
            for(int ptr=0; ptr<len; ptr++){
                
                // if both char not matching then there is edge between them
                // e.g. -> b != a then b -> a so b has to come before a
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    // store in int format -> a : 0. b : 1, c : 2 ......
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }   
        
        // once we get adj list from strings then simply apply topo sort using DFS or BFS
        ArrayList<Integer> result = new ArrayList<>();
        topoSortBFS(adj, result);
        
        // now in result containg numbers in topo sort order so convert into char and pass it to string and return it
        String output = "";
        for(int number : result){
            output = output + (char)(number + (int)('a'));
        }
        
        return output;
    }
        
    public void topoSortBFS(List<List<Integer>> adj, ArrayList<Integer> result){
        
        // Creating inDegree array to store no of incoming edges to node// Creating inDegree array to store no of incoming edges to node
        int n = adj.size();
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
        
        while(!queue.isEmpty()){
            // pop out node from queue and add it in result as it has 0 incoming edges 
            int node = queue.peek();
            queue.poll();
            result.add(node);
            
            for(int neighbour : adj.get(node)){
                
                // reduce count of inDegree of neighbour by 1 (remove one edge)
                inDegree[neighbour] = inDegree[neighbour] - 1;
                
                // if it becomes 0 then add in queue else continue
                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }
        
    }

        
}