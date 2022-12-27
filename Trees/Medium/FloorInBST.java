// https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos

class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        
        // putting dummy value
        int floor = -1;
        
        while(root != null){
            
            // if both are matching then return it 
            if(root.data == key){
                floor = root.data;
                return floor;
            }
            
            // if root has low value then move to right part of tree
            else if(root.data > key){
                root = root.left;
            }
            
            // else store in ceil and again check for closer value
            else{
                floor = root.data;
                root  = root.right;
            }
        }
        
        // return ceil
        return floor;
    }
}
