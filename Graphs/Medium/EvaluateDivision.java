// https://leetcode.com/problems/evaluate-division/

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        // build graph using map which will store -> key u : {key v, value wt}
        Map<String, Map<String, Double>> graph = makeGraph(equations, values);
        
        // to store values of queries
        double []ans = new double[queries.size()];
        
        // apply DFS to each query and store result in ans array
        for(int i = 0; i < queries.size(); i++)
            ans[i] = dfs(queries.get(i).get(0) , queries.get(i).get(1) , new HashSet<>(), graph);

        return ans;
        
    }
    
    private  Map<String, Map<String, Double>> makeGraph(List<List<String>> e, double[] values){
        
         // build a graph a -> b = values[i] and b -> a  = 1.0 / values[i];
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for(int i = 0; i < e.size(); i++){
            
            String u = e.get(i).get(0);
            String v = e.get(i).get(1);
            
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1/values[i]);
            
        }
        
        return graph;
    }
    
    public double dfs(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph){
        
        // if string is not present in graph return -1.0;
        if(graph.containsKey(src ) == false)
            return -1.0;
    
        // if dest is prent inside src map then return its weight
        if(graph.get(src).containsKey(dest)){
            return graph.get(src).get(dest);
        }
        
        // else ->
        
        // mark src string as visited
        visited.add(src);
        
        // take out every neighbour of src through map
        for(Map.Entry<String, Double> nbr : graph.get(src).entrySet()){
            
            // if neighbour not visited then only apply DFS 
            if(visited.contains(nbr.getKey()) == false){
                
                // and get result from them
                double weight = dfs(nbr.getKey(), dest, visited, graph);
                
                // if result is -1.0 means string not present then no need to add any value in it simply return -1.0 else multiply with current src string value
                if(weight != -1.0)
                    return nbr.getValue() * weight;
            }
        }
        
        return -1.0;
    }
}