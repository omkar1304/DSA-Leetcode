// https://leetcode.com/problems/maximum-total-importance-of-roads/

class Solution {
    /*
    As total importance == sum(degree * value), the degree of each node is already decided by graph.

    However, we can assign value of [1, n] to each node, to maximum the total importance.

    We should assign larger value to larger degree node.

    For example:


    node        0 1 2 3 4
    degree      2 3 4 2 1
    value       2 4 5 3 1

    (2+4) + (2+5) + (4+3) + (4+5) + (5+3) + (5+1)
    = (5+5+5+5) + (4+4+4) + (3+3) + (2+2) + (1)
    = 5 * 4 + 4 * 3 + 3 * 2 +  2 * 2 + 1 * 1  -> (value * degree)
    = 43
    
    */
    
    
    public long maximumImportance(int n, int[][] roads) {
        
        // we know that if we assign maximum value which is n to the node which has more degree or edges that will give us max result. hence calculate degree of each node and then sort it and assign value to it from 1 to n
        
        // find degree of each node
        int[] degree = new int[n];
        
        for(int[] road : roads){
            
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        // sort them in dec order
        Arrays.sort(degree);
        
        long result = 0;
        long value = 1;
        
        // assigh value to node from 1 to n and store in result as per above result
        for(int i=0; i<n; i++){
            
            result = result + (long) (degree[i] * value);
            value++;
        }
        
        return result;
    }
}