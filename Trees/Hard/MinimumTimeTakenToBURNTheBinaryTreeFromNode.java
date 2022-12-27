// https://practice.geeksforgeeks.org/problems/burning-tree/1?track=amazon-trees

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = toBuildParentMap(root, parentMap, target);
        int min = helper(targetNode, parentMap);
        return min;
        
    }
    // to get traget node and fill parentMap
    public static Node toBuildParentMap(Node root, Map<Node, Node> parentMap, int target){
        
        // to store level wise node
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        // to find target node
        Node ans = root;
        
        // putting root parent as null in parentMap
        parentMap.put(root, null);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int index=0; index<size; index++){
                
                Node tempNode = queue.poll();
                
                // if values matches then we found our targetNode
                if(tempNode.data == target){
                    ans = tempNode;
                }
                
                // if left not null then add in queue and add its parent in parentMap
                if(tempNode.left != null){
                    queue.offer(tempNode.left);
                    parentMap.put(tempNode.left, tempNode);
                }
                
                // if right not null then add in queue and add its parent in parentMap
                if(tempNode.right != null){
                    queue.offer(tempNode.right);
                    parentMap.put(tempNode.right, tempNode);
                }
            }
        }
        
        // return tragetNode
        return ans;
    }

    // to get minimum time 
    public static int helper(Node targetNode, Map<Node, Node> parentMap){
        
        // to store parent and left and right node of current node at each level
        Queue<Node> queue = new LinkedList<>();
        queue.offer(targetNode);
        
        // it will store visited nodes set
        Set<Node> set = new HashSet<>();
        
        // at start time = 0
        int time = 0;
        
        while(!queue.isEmpty()){
            // if flag = 0 means no nodes burn else flag = 1 means at least one node burned
            int flag = 0;
            int size = queue.size();
            
            for(int index=0; index<size; index++){
                
                Node tempNode = queue.poll();
                
                // if tempNode has parent and its not visisted then add in queue and visited set and make flag = 1 as we can burn this node
                if(parentMap.get(tempNode) != null && !set.contains(parentMap.get(tempNode))){
                    flag = 1;
                    set.add(parentMap.get(tempNode));
                    queue.offer(parentMap.get(tempNode));
                }
                
                // if tempNode has left and its not visisted then add in queue and visited set and make flag = 1 as we can burn this node
                if(tempNode.left != null && !set.contains(tempNode.left)){
                    flag = 1;
                    set.add(tempNode.left);
                    queue.offer(tempNode.left);
                }
                
                // if tempNode has right and its not visisted then add in queue and visited set and make flag = 1 as we can burn this node
                if(tempNode.right != null && !set.contains(tempNode.right)){
                    flag = 1;
                    set.add(tempNode.right);
                    queue.offer(tempNode.right);
                }
            }
            
            // if we atleast burn one node then flag will be 1 so increase time by 1
            if(flag == 1){
                time = time + 1;
            }
        }
        
        // return total minimum time
        return time;
        
    }
    
}