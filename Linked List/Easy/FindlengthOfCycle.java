// https://practice.geeksforgeeks.org/problems/find-length-of-loop/1

/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

//Function should return the length of the loop in LL.

class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        // Two pointer ->
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // if both pointers meet then we need to just traverse from that node to again that node to get cycle length
            if(slow == fast){
                int length = 0;
                // creating temp node to traverse from slow to slow node(loop)
                Node entry = slow;
                do{
                    entry = entry.next;
                    length++;
                }while(entry != slow);
                
                // returning calculate length
                return length;
            }
        }
        
        // if loop not present then length will be 0
        return 0;
    }
}