// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

class Solution {
    public int removeStones(int[][] stones) {
        // here we dont have matrix dimensions so we can get maxRow and maxCol from stones so we can assume that martix would be that large
        int maxRow = 0;
        int maxCol = 0;
        
        for(int[] it : stones){         
            maxRow = Math.max(maxRow, it[0]);
            maxCol = Math.max(maxCol, it[1]);          
        }
        
        // creating DSU to connect componet dynamically
        //maxRow + maxCol + 2 ? why maxRow + maxCol as we new need to consder whole cell at 0 th row as one node
        // so row + col we need to consider instead of row*col for all cell nodes. and why 2 ? to avoid 0th and 1th based index
        DSU dsu = new DSU(maxRow + maxCol + 2);
        
        for(int i=0; i<stones.length; i++){     
            
            // get the row and col of stone
            int row = stones[i][0];
            // now here we have to combine all stones which at current row. so same way we have to consider col but row and col number will be same then hence we can add row lenth + 1 in col number so we can new col value to store in DSU
            int col = stones[i][1] + maxRow + 1;
            
            // make connection in dsu
            dsu.unionBySize(row, col);
        }
        
        // now we know that suppose 4 nodes are connected then we can remove 3 nodes as for last node we there will be no node in row or col. okay so suppose there are 6 stones and we have 2 components.so fist component contains 4 nodes then 3 can be removed and second component contains 2 nodes then 1 can be removed. so tital 4 can be removed and that will be our ans. So we can say that if no of stones - no of componets will also give ans.
        
        // creating getComponetCount() method in dsu so we can get componet. the node which is parent itself can be treated as node but also alone its not sufficient as we know to remove any stone we need atleast 2 nodes in compoent. so we have to consider the node which is parent itself as well size is greater than 2 then that is compoent 
        
        int stoneCount = stones.length;
        int componetCount = dsu.getComponetCount();
        
        // and return max removed stones using no of stones - no of componets
        return stoneCount - componetCount;
        
    }
}

class DSU {
    
    int n;
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DSU(int n){
        
        this.n = n ;
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
    
    public int getComponetCount(){
        
        int count = 0;
        
        for(int i=0; i<n; i++){
            
            if(parent.get(i) == i && size.get(i) > 1)
                count++;
        }
        
        return count;
    }
}