// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

class Pair{
    int hd;
    Node node;
    
    public Pair(int hd, Node node){
        this.hd = hd;
        this.node = node;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // creating map to store -> level , value at corresponding level
        Map<Integer, Integer> map = new TreeMap<>();
        // creating queue to store pair of (level, node)
        Queue<Pair> queue = new LinkedList<>();
        
        // adding root node first
        queue.offer(new Pair(0, root));
        
        while(!queue.isEmpty()){
            
            // taking out pair from queue
            Pair temp = queue.poll();
            
            // for bottom view -> keep updating value as at last whichever node at bottom will be present in map
            // that means top node will get override by bottom node at particular level
            
            // add or update value in map at particular level
            map.put(temp.hd, temp.node.data);
            
            // if left child is not null then add left node with level+1 order in queue
            if(temp.node.left != null){
                queue.offer(new Pair(temp.hd-1, temp.node.left));
            }
            // if right child is not null then add right node with level+1 order in queue
            if(temp.node.right != null){
                queue.offer(new Pair(temp.hd+1, temp.node.right));
            }
        }
        
        // converting map values into ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
              result.add(e.getValue());
        }
          
        return result;
        
    }
}