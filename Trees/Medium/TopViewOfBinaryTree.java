// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
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
    static ArrayList<Integer> topView(Node root)
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
            
            // for top view -> once value is update then do not change it
            
            // if map contains that key already do not update it 
            // if not present then add it
            if(!map.containsKey(temp.hd)){
                map.put(temp.hd, temp.node.data);
            }
            
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