// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

class Solution {
    
    // two things we need find - 1. how many extra edges which can be removed 2. how many edge required to connect component
    // 1. how many extra edges which can be removed -> while dynamically adding edges in graph with use of DSU we can check if u and v having same parent means they are already connected so this current edge is extra edge so this is how we can calculate extra edge
    // 2. how many edge required to connect component -> first think how many compoents are there. we can get this using parent list and those nodes itself parent they are root of their graph/tree so we can get count of component. Now suppose to connect 4 component we will need 3 edges. so same way if we have nComponent then required edges will be nComponent - 1
    
    public int makeConnected(int n, int[][] edges) {
        
        // cretaing object of DSU to check edges dynamically
        DSU dsu = new DSU(n);
        
        // 1. calculating extra edges
        int extra = 0;
        for(int i=0; i<edges.length; i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            // if same parent then both belong to same compoent and still getting another edge means extra edge
            if(dsu.findUPar(u) == dsu.findUPar(v))
                extra++;
            // if parents are different then attach both graph using DSU
            else
                dsu.unionBySize(u, v);
        }
        
        // 2. calculate no of compoent to get no of required edges
        int nCompo = 0;
        for(int i=0; i<n; i++){
            
            // if node itself parent then its root of component
            if(i == dsu.parent.get(i))
                nCompo++;
        }
        
        // if extra edges is greater than or equal to required edges then return required edges else return -1(impossible)
        if(extra >= nCompo - 1)
            return nCompo - 1;
        else
            return -1;
        
    }
}

class DSU{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DSU(int n){
        
        for(int i=0; i<=n; i++){
            
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
            size.set(ulp_v, ulp_u + ulp_v);
        }
        
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}