// https://leetcode.com/problems/keys-and-rooms/

// here we can consider room as node and keys as their neighbours so we can start from room 0 i,e node 0 and traverse it neighbours recusrively using DFS. Also keep visited array to avoid visiting node again. After all DFS call check if all rooms i.e nodes are visited or not.
// Same way we can use BFS for this problem
    
// DFS ->
class Solution {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        int[] visited = new int[n];
        
        DFS(0, rooms, visited);
        
        for(int i=0; i<n; i++)
            if(visited[i] == 0)
                return false;
        
        return true;
    }
    
    public void DFS(int room, List<List<Integer>> rooms, int[] visited){
        
        visited[room] = 1;
        
        for(Integer it : rooms.get(room)){
            if(visited[it] == 0)
                DFS(it, rooms, visited);
        }
    }
}

// BFS ->
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        int[] visited = new int[n];        
        Queue<Integer> queue = new LinkedList<>();
        
        visited[0] = 1;
        queue.offer(0);
        
        while(!queue.isEmpty()){
            
            int room = queue.peek();
            queue.poll();
            
            for(Integer it : rooms.get(room)){
                
                if(visited[it] == 0){
                    visited[it] = 1;
                    queue.offer(it);
                }
            }
        }
        
        for(int i=0; i<n; i++)
            if(visited[i] == 0)
                return false;
        
        return true;
    }
}