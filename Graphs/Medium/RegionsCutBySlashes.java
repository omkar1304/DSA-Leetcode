// https://leetcode.com/problems/regions-cut-by-slashes/

// yt soln - https://youtu.be/Wafu5vOxPRE

class Solution {
    public int regionsBySlashes(String[] grid) {
        
        // here we have string which consist of '/', '\', ' ' so we consider matrix with dots
        // so if we have grid of 3x3 then dots matrix will be 4x4 to connect two dots
        int n = grid.length;
        int dots = n + 1;
        
        // now we have to consider each dot and form DSU
        DSU dsu = new DSU(dots * dots);
        
        for(int i=0; i<dots; i++){
            
            for(int j=0; j<dots; j++){
                
                // check if any one dot is lie on boundary then connect to 0 as boundary dots are already connected to each other
                if(i==0 || j==0 || i==dots-1 || j==dots-1){
                    
                    // calculating cell no based on i and j value of matrix 
                    int cellNo = i * dots + j;
                    
                    // to avoid connecting dot 0 to dot 0 itself
                    if(cellNo != 0)
                        
                        // connecting all boundary dots to 0
                        dsu.unionBySize(0, cellNo);
                }
            }
        }
        
        // at the start give region already itself a region only hence we already have 1 square. hence start with 1
        int count = 1;
        
        for(int i=0; i<grid.length; i++){
            
            char[] ch = grid[i].toCharArray();
            
            for(int j=0; j<ch.length; j++){
                
                // if we see '/' then it will connect dot (i,j+1) and dot(i+1, j) (dry run in matrix)
                if(ch[j] == '/'){
                    
                    // calculating cell no based on i and j value 
                    int u = i*dots + j+1;
                    int v = (i+1)*dots + j;
                    
                    // if both u and v belongs to same parent then there is cycle and if cycle is formed then we have created new region hence inc count by 1
                    if(dsu.findUPar(u) == dsu.findUPar(v))
                        count++;
                    // if not same parent then just make connection. here we have not created any cycle hence no need to update count
                    else
                        dsu.unionBySize(u, v);
                }
                
                // same for '\'
                // if we see '\' then it will connect dot (i,j) and dot(i+1, j+1) (dry run in matrix)
                else if(ch[j] == '\\'){
                    
                    // calculating cell no based on i and j value 
                    int u = i*dots + j;
                    int v = (i+1)*dots + (j+1);
                    
                    // if both u and v belongs to same parent then there is cycle and if cycle is formed then we have created new region hence inc count by 1
                    if(dsu.findUPar(u) == dsu.findUPar(v))
                        count++;
                    // if not same parent then just make connection. here we have not created any cycle hence no need to update count
                    else
                        dsu.unionBySize(u, v);
                }
                
                else 
                    continue;
            }
        }
        
        // at the end return updated count
        return count;
    }
}

class DSU {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DSU(int n) {
        for (int i = 0; i <= n; i++) {
            
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        
        if (node == parent.get(node)) {
            return node;
        }
        
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if (ulp_u == ulp_v)
            return;
        
        else if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } 
        
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}