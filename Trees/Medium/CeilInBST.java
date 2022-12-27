// https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1


class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        
        // putting dummy value
        int ceil = -1;
        
        while(root != null){
            
            // if both are matching then return it 
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            
            // if root has low value then move to right part of tree
            else if(root.data < key){
                root = root.right;
            }
            
            // else store in ceil and again check for closer value
            else{
                ceil = root.data;
                root  = root.left;
            }
        }
        
        // return ceil
        return ceil;
    }
}
