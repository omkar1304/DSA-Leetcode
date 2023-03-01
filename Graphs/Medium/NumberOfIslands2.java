// https://practice.geeksforgeeks.org/problems/number-of-islands/1

class Solution {
    
    private boolean isValid(int adjr, int adjc, int m, int n) {
        return adjr >= 0 && adjr < m && adjc >= 0 && adjc < n;
    }
        
    
    public List<Integer> numOfIslands(int m, int n, int[][] operators) {
        
        // creating object of DSU
        DSU dsu = new DSU(m * n);
        
        // creating visited array to keep track of visited node
        int[][] visited = new int[m][n];
        // keeping count of island
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        // to traverse in 4 direction at each cell
        int dr[] = { -1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        int len = operators.length;
        
        for (int i = 0; i < len ; i++) {
            
            int row = operators[i][0];
            int col = operators[i][1];
            
            // if that cell is already visited then add count in ans list and return
            if (visited[row][col] == 1) {
                ans.add(count);
                continue;
            }
            
            // if not mark it as visited and add +1 in count as itself it will consider as spareate compone t
            visited[row][col] = 1;
            count++;
            
            // Traverse in 4 direction
            for (int ind = 0; ind < 4; ind++) {
                
                // get adjcent cell
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];
                
                // if that cell is valid ->
                if (isValid(adjr, adjc, m, n)) {
                    
                    // and also if that cell is 1 that means island then only we can consider both current node and adj node as component
                    if (visited[adjr][adjc] == 1) {
                        
                        // calculating cell number to work with DSU
                        int nodeNo = row * n + col;
                        int adjNodeNo = adjr * n + adjc;
                        
                        // if both are from same paren then its already connected if parents are different then we have to connect them in DSU 
                        // and reduce count value by 1 as current node grouped witb adj node
                        if (dsu.findUPar(nodeNo) != dsu.findUPar(adjNodeNo)) {
                            count--;
                            dsu.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            
            // once we check for 4 direction for current node then add updated count value in result
            ans.add(count);
        }
        
        return ans;
    }
    
}

class DSU {
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DSU(int n){
        
        for(int i=0; i<n; i++){
            
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        
        if(node == parent.get(node))
            return node;
            
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        
        return ulp;
    }
    
    public void unionBySize(int u, int v){
        
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if(ulp_u == ulp_v)
            return;
            
        else if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}