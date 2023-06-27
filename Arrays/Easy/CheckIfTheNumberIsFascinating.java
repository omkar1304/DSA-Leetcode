// https://leetcode.com/problems/check-if-the-number-is-fascinating/


class Solution {
    public boolean isFascinating(int n) {
        
        // check every no seperately and mark there element in visited array. if any element is already visited then or its 0 then return false else return true
        
        boolean[] visited = new boolean[10];
        
        if(!check(n, visited))
            return false;
        
        if(!check(2*n, visited))
            return false;
        
        if(!check(3*n, visited))
            return false;
        
        return true;
    }
    
    public boolean check(int n, boolean[] visited){
        
        while(n > 0){
            
            int temp = n % 10;
            
            if(temp == 0)
                return false;
            
            if(visited[temp] == true)
                return false;
            
            visited[temp] = true;
            n = n / 10;
                            
        }
        
        return true;
    }
}