// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

// class Node
// {
//     int data;
//     Node left, right;

//     Node(int item)
//     {
//         data = item;
//         left = right = null;
//     }
// }
class Tree
{   
    void helper(Node root, Map<Integer, Integer> map, int level){
        // base case
        
        // if root is null then return it from here
        if(root == null){
            return;
        }
        
        // for left view -> once value is update then do not change it
        
        // if map contains that key already do not update it 
        // if not present then add it
        if(!map.containsKey(level)){
            map.put(level, root.data);
        }
        
        // traverse left and right child
        helper(root.left, map, level+1);
        helper(root.right, map, level+1);
        
    }
    
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      Map<Integer, Integer> map = new TreeMap<>();
      // starting from root and empty map and at 0 level
      helper(root, map, 0);
      
      // converting map values into ArrayList
      ArrayList<Integer> result = new ArrayList<>();
      for(Map.Entry<Integer, Integer> e : map.entrySet()){
          result.add(e.getValue());
      }
      
      return result;
    }
}