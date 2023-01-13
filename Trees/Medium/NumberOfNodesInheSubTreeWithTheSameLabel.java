// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        // creating result array 
        int[] res = new int[n];
        // creating count array for lowercase alphabates to store count of chars in labels
        int[] count = new int[26];
        
        // creating map to store graph values 
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int[] edge : edges){
            
            // if array not present at particular node then create it
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            
            // if present then add its adjecent node
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        helper(graph, res, count, labels, 0, -1);
        return res;
        
    }
    
    public void helper(Map<Integer, List<Integer>> graph, int[] res, int[] count, String labels, int currNode, int prevNode){
        
        // Stroing previous count value which was calculate before for another node but for same char value
        int prevCount = count[labels.charAt(currNode) - 'a'];
        
        // adding + 1 as current node also part of subtree so its char needs to be get added in count array
        count[labels.charAt(currNode) - 'a'] = count[labels.charAt(currNode) - 'a'] + 1;
        
        // once currentnode is done we need to go for its nextnode to build count for char which present at currentnode using labels
        for(int nextNode : graph.get(currNode)){
            
            // if previous node is same as nextnode then there is cycle or already visisted so skip and go for next nextnode
            if(nextNode == prevNode)
                continue;
            
            // update current and prev and go for nextnode
            helper(graph, res, count, labels, nextNode, currNode);
        }
        
        // once we calculate count for subtree for current node char then subtract prev from it as we need to only store count for current node char in res array (i.e. from current node to leaf node count we need to store not its parent node)
        res[currNode] = count[labels.charAt(currNode) - 'a'] - prevCount;
    }
} 