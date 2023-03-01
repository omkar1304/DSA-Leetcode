// https://leetcode.com/problems/making-a-large-island/

class Solution {
    
    public boolean isValid(int nRow, int nCol, int n){
        return (nRow >= 0 && nRow < n && nCol >=0 && nCol < n);
    }
        
    
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        
        // creating DSU for all cell 
        DSU dsu = new DSU(n*n);
        
        // To traverse in 4 directions
        int drow[] = { -1, 0, 1, 0};
        int dcol[] = {0, -1, 0, 1};
        
        // step 1 -> check all cell which having value 1 and then check for its neighbours in 4 directions and connect them with help of DSU
        
        
        for(int r=0; r<n; r++){  
            for(int c=0; c<n; c++){
                
                // if cell is 0 leave it
                if(grid[r][c] == 0)
                    continue;
                
                // check of its adj cells in 4 directions
                for(int i=0; i<4; i++){
                    int nRow = r + drow[i];
                    int nCol = c + dcol[i];
                    
                    // if its valid and its island that means its value is 1 then calculate cell no using row and col of current node and adj node and update DSU
                    if(isValid(nRow, nCol, n)){ 
                        if(grid[nRow][nCol] == 1){
                            
                            int nodeNo = r * n + c;
                            int adjNo = nRow * n + nCol;
                            
                            dsu.unionBySize(nodeNo, adjNo);
                                     
                        }
                    }
                    
                }
            }
        }
        
        // step 2 -> Now as per question we can change any 0 to 1 at most onse and need to calculate size of max islan. so check in grid if cell is 0 then check for its neighbours and get the size of its neighbours from DSU if that cell is island means 1 and store in max variable and at the end return max 
        
        int max = 0;
        
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                
                // we only need to convert 0 to 1
                if(grid[r][c] == 1)
                    continue;
                
                // to store distinct ulp of cell to avoid duplicates 
                Set<Integer> set = new HashSet<>();
                
                for(int i=0; i<4; i++){
                    
                    int nRow = r + drow[i];
                    int nCol = c + dcol[i];
                    
                    // if its valid and its island then add its parent cell in set
                    if(isValid(nRow, nCol, n)){
                        if(grid[nRow][nCol] == 1){
                            
                            set.add(dsu.findUPar(nRow * n + nCol));
                        }
                    }
                }
                
                // now calculate size of island using set and add +1 for current cell
                int sizeTotal = 0;
                for(Integer it : set)
                    sizeTotal = sizeTotal + dsu.size.get(it);
                
                // store max size in max variable
                max = Math.max(max, sizeTotal+1);
            }
        }
        
        // at the end suppose all cells are 1 then above step 2 will wont run then we will get max as 0 
        // to avoid that case check in size list of dsu and traveral every cell and take its size of its parent and store in max
        for(int cellNo=0; cellNo < n*n; cellNo++)
            max = Math.max(max, dsu.size.get(dsu.parent.get(cellNo)));
        
        // at then end return max
        return max;
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