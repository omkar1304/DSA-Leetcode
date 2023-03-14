// https://leetcode.com/problems/redundant-connection/

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        // as we know to form valid tree the graph should be undirected with n-1 edges for n nodes.
        // here we have one extra redundant edge so total edges will be n which is equals to no of nodes
        int n = edges.length;
        
        // by using DSU we can check if any extra redundant edge
        DSU dsu = new DSU(n);
        
        for(int[] edge : edges){
            
            int u = edge[0];
            int v = edge[1];
            
            // if both parents are same for u and v node then its already connected hence that extra edge
            if(dsu.findUPar(u) == dsu.findUPar(v))
                return edge;
            // if parents are different then u and v not connected and this edge is required one so update in DSU
            else
                dsu.unionBySize(u, v);
        }
        
        return new int[2];
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