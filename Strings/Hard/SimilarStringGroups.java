// https://leetcode.com/problems/similar-string-groups/

class Solution {
    public int numSimilarGroups(String[] strs) {
        
        // Same as problem -> find no of components in graph
        
        int n = strs.length;
        boolean[] visited = new boolean[n];
        int group = 0;
        
        // check for all nodes(strings here)
        for(int index=0; index<n; index++){
            
            // if already visited then leave it
            if(visited[index] == true)
                continue;
            
            // else we have another group so inc group count by 1 and apply DFS to it
            group++;
            DFS(index, strs, visited);
            
        }
        
        return group;
    }
    
    public void DFS(int index, String[] strs, boolean[] visited){
        
        // mark that string (node) visited
        visited[index] = true;
        
        // check for its neighbours -> here neighbours means if they both string similar as per condition ->
        for(int i=0; i<strs.length; i++){
            
            // if that string is visited then leave it
            if(visited[i] == true)
                continue;
            
            // else check if they are adjcent means similar if yes apply DFS to it
            if(isSimilar(strs[index], strs[i]))
                DFS(i, strs, visited);
        }
    }
    
    
    public boolean isSimilar(String x, String y){
        // both string similar if they have char diff 0 or 2 
        
        int n = x.length();
        int count =  0;
        
        for(int i=0; i<n; i++){
            
            if(x.charAt(i) != y.charAt(i))
                count++;
        }
        
        return (count == 2 || count == 0);
    }
}