// https://leetcode.com/problems/accounts-merge/

class Solution {
    
    // in this problem consider name as node value suppose for john - node1 based on their index
    // part 1 : map all mail to node(index) if same mail already mapped with other node then both are belongs to same component hence make changes in DSU to get this done.
    // part 2 : Now we have all mails mapped to node. take mail and node one by one and check ultimate parent of node. so if in part 1 when we encountered same mail mapped to different node will get cover here. suppose j@mail belongs to 1 and 3 node then when we get 3 node with mail j@mail. will get ultimate parent as 1 for node 3. so after this we will have same set of array like accounts with mergeed mail
    
    // part 3 : now we just have to add names add the start and sort mail and add in ans list
    
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        
        // creating object of DSU to dynamially add nodes(names in this case)
        DSU dsu = new DSU(n);
        
        Map<String, Integer> mapMailToNode = new HashMap<>();
        
        // part 1 ->
        
        for(int i=0; i<n; i++){
            
            // why 1 ? because at index 0 there always be name
            for(int j=1; j<accounts.get(i).size(); j++){
                
                String mail = accounts.get(i).get(j);
                
                // mapping of -> mail -> node
                
                // if mail not mapped already then map it 
                if(mapMailToNode.containsKey(mail) == false)
                    mapMailToNode.put(mail, i);
                
                // if already mapped then just make changes in DSU so we will get ultimate parent in part 2
                else
                    dsu.unionBySize(i, mapMailToNode.get(mail));
            }
        }
        
        // part 2 ->
        
        // creating array which holds list of strings
        List<String>[] mergedMail = new ArrayList[n];
        
        // creating dummy list which store strings
        for (int i = 0; i < n; i++) 
            mergedMail[i] = new ArrayList<String>();
        
        // unmapped all mails and store at index based on their ultimate parent
        for(Map.Entry<String, Integer> it : mapMailToNode.entrySet()){
            
            String mail = it.getKey();
            int node = it.getValue();
            node = dsu.findUPar(node);
            
            mergedMail[node].add(mail);
        }
        
        // part 3 ->
        
        // now we just have to add names add the start and sort mail and add in ans list
        List<List<String>> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            
            // if list is empty then leave it
            if(mergedMail[i].size() == 0)
                continue;
            
            // sort mails
            Collections.sort(mergedMail[i]);
            
            // create temp list of strings and add name at index of i of 0 and add all strings belongs to index i
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            
            for(String it : mergedMail[i])
                temp.add(it);
            
            ans.add(temp);
        }
        
        // at the end return ans
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
        
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}