// https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // step 1 -> Linked new node of deep copy in between two nodes of origial LL.
        
        Node prev = head;
        Node current = head;
        while(prev != null){
            // keeping current ahead of prev
            current = prev.next;
            
            // creating node of deep copy LL and attaching between prev and current node
            Node copy = new Node(prev.val);
            prev.next = copy;
            copy.next = current;
            
            // updating pointer
            prev = current;
            
        }
        
        // step 2 -> Connecting random pointer of deep copy nodes to deep copy of nodes only same as original LL
        
        Node temp = head; 
        while(temp != null){
            
            // if in orginal LL -> a node's random pointing to null then no need to update random pointer of copy node(as while creating copy node its both next and random pointing to null only)
            if(temp.random != null)
                // if not pointing to null then make connection of random nodes of copy nodes to copy nodes with help of original LL.
                temp.next.random = temp.random.next;
            
            // updating pointer
            temp = temp.next.next;
        }
        
        // step 3 -> removing next pointer of each original and copy node to make both LL separate 
        
        Node dummy = new Node(-1); // creating dummy node which points to copy of LL
        Node copy = dummy; // creating copy node which will iterate over copy of LL
        prev = head;
        while(prev != null){
            // keeping current ahead of prev by 2(as it conatins copy node in between)
            current = prev.next.next;
            
            // breaking connection of next pointer to make LL separate
            copy.next = prev.next;
            prev.next = current;
            
            // updating pointers
            prev = current;
            copy = copy.next;
        }
        
        // returing copy of LL
        return dummy.next;
    }
}