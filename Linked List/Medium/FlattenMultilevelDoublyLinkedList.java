// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        // Two pointers
        Node current = head;
        Node tail = head;
        
        // creating stack to store next nodes if we find any child
        Stack<Node> stack = new Stack<>();
        
        // keep iterating till we reach null
        while(current != null){
            
            // if we find there is child attach with current node then ->
            if(current.child != null){
                // store that child
                Node child = current.child;
                // if that current having child as well as next node then store that in stack and make its prev null as we need to break their chain
                if(current.next != null){
                    stack.push(current.next);
                    current.next.prev = null;
                }
                // now make connection between current.next and current.child and remove that child connection
                current.next = child;
                child.prev = current;
                current.child = null;
            }
            
            // if current doesnt have child then just move ahead
            tail = current;
            current = current.next;
        }
        
        // once we finished with LL then start poping out nodes from stack attach with current node till stack becomes empty
        while(!stack.isEmpty()){
            // once we pop out node then make connections(current should point to node which are coming from stack and tail is pointing to last node of LL)
            current = stack.pop();
            tail.next = current;
            current.prev = tail;
            // iterate through all nodes which we pop from stack so we can again pop another node
            while(current != null){
                tail = current;
                current = current.next;
            }
        }
        
        // return head at last as per requirement
        return head;
        
    }
}