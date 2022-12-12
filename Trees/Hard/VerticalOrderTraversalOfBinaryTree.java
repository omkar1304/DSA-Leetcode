// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple{
    TreeNode node;
    int row;
    int col;
    
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row; 
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // map = {row , {col , PriorityQueue[no of nodes present at (row, col)]}}
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // to store tuple where tuple contains -> (node, row level , col level)
        Queue<Tuple> queue = new LinkedList<>();
        
        // adding root node first as form of tuple in PQ
        queue.offer(new Tuple(root, 0, 0));
        
        while(!queue.isEmpty()){
            
            // poping out tuple from PQ and assigning tuple contains to separte variable
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            
            // if map not contains key(row) then make it like -> map = {x, {}}
            if(!map.containsKey(x))
                map.put(x, new TreeMap<>());
            
            // if map contains key(row) but not key(col) then make it like -> map = {x, {y, {}}}
            if(!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());
            
            // then put node value in PQ and store in map like this -> map = {x, {y, PQ[node values]}}
            map.get(x).get(y).offer(node.val);
            
            // adding its left and right child if not null as tuple
            if(node.left != null)
                queue.offer(new Tuple(node.left, x-1, y+1)); // if go to left then row value get dec and col will be same
            if(node.right != null)
                queue.offer(new Tuple(node.right, x+1, y+1)); // if go to right then row value get inc and col will be same
            
        }
        
        // poping out values and update result ->
        
        // creating reuslt list to store node values at vertical order
        List<List<Integer>> result = new ArrayList<>();
        
        // taking out outer map value that is x which represents vertical order line
        for(Map<Integer, PriorityQueue<Integer>> ys : map.values()){
            // at each vertical line we have nodes to store we are creating list
            result.add(new ArrayList<>());
            // taking out inner map value that is y ehich represnts level order
            for(PriorityQueue<Integer> pq : ys.values()){
                // adding all node values from pq which at x,y position
                while(!pq.isEmpty()){
                    // result.get(result.size() - 1) why this because to add values in last list of result
                    // for example result contains -> [[9]] so for next time when we create list it will become -> [[9], []]
                    // so to add nodes value at last first we need to get that list thats why we used
                    // and then add using poll -> [[9], [3,15]]
                    result.get(result.size() - 1).add(pq.poll());
                }
                
            }
        }
        
        return result;
        
    }
}