// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

/ class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    // this function will traverse left nodes excluding leaf nodes
    void traversalLeft(Node root, ArrayList <Integer> result){
        // base cases
        
        // if root null then return it from here
        if(root == null){
            return;
        }
        
        // if both children is null then its leaf node so skip it as we need to exclude it
        if(root.left == null && root.right == null){
            return;
        }
        
        // if its not a null or leaf node then add its value as we found left node
        result.add(root.data);
        // and traverse its left side if not null else travese right side
        if(root.left != null){
            traversalLeft(root.left, result);
        }
        else{
            traversalLeft(root.right, result);
        }
    }
    
    // this function will traverse leaf node
    void traversalLeaf(Node root, ArrayList <Integer> result){
        // base cases
        
        // if root null then return it from here
        if(root == null){
            return;
        }
        
        // if both children is null then its leaf node hence add in result
        if(root.left == null && root.right == null){
            result.add(root.data);
        }
        
        // else traverse left and right side to get all leaf nodes
        traversalLeaf(root.left, result);
        traversalLeaf(root.right, result);
    }
    
    // this function will traverse right nodes excluding leaf nodes(reverse order)
    void traversalRight(Node root, ArrayList <Integer> result){
        // base cases
        
        // if root null then return it from here
        if(root == null){
            return;
        }
        
        // if both children is null then its leaf node so skip it as we need to exclude it
        if(root.left == null && root.right == null){
            return;
        }
        
        // here we need to traverse right side in reverse order 
        //so first make calls till we reach end then start storing node's data 
        
        // traverse its right side if not null else travese left side
        if(root.right != null){
            traversalRight(root.right, result);
        }
        else{
            traversalRight(root.left, result);
        }
        
        // if its not a null or leaf node then add its value as we found right node
        result.add(root.data);
        
    }
    
	ArrayList <Integer> boundary(Node root)
	{
	   // creating result list to store node's data
	   ArrayList<Integer> result = new ArrayList<>();
	   // if root is null then return empty result
	    if(root == null){
	        return result;
	    }
	    
	    // if root not none then add root data in result list
	    result.add(root.data);
	    
	    // step 1 : left side traversal excluding leaf nodes
	    traversalLeft(root.left, result);
	    
	    // step 2 : leaf node traversal 
	    traversalLeaf(root.left, result);
	    traversalLeaf(root.right, result);
	    
	    // step 3 : right side traversal excluding leaf nodes(reverse order)
	    traversalRight(root.right, result);
	    
	    // returning updated result list
	    return result;
	    
	    
	}
}
