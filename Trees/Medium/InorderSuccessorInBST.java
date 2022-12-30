// https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1


//User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x){
	    
	    // creating succesor node which will store node which are greater than x
	    Node successor = null;
	    Node tempNode = root;
	    
	    while(tempNode != null){
	        
	       // if tempnode value is less then we are sure that we wont get it in left side 
	       // hence move rigth side
	       if(tempNode.data <= x.data){
	           tempNode = tempNode.right;
	       }
	       // if greater than node then it might be possiblity that its successort
	       // so store it and check for another close successor by moving left side
	       else{
	           successor = tempNode;
	           tempNode = tempNode.left;
	       }
	    }
	    
	    // return successor at last
	    return successor;
	}
}