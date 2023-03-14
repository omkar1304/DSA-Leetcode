// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/

class Solution {
    // Idea : consider only 2 city i.e from city a to city b. now we have total 4 pepople to travel and we have seats per car is 2 so from a to b we only going to spend 1 litere fuel so as per no of cars fuel will get updated. and no of cars its depend on no of people and seats. so hence fuel = no of people / no of seats. so for path a to b we can calculate fuel so for the same for every path we calculat with help of no of people and seats
    
    long fuel = 0;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        
        // creating adj list 
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<=roads.length; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // applying DFS to update fuel
        DFS(0, -1, adj, seats);
        return fuel;
    }
    
    public int DFS(int currCity, int prevCity, List<List<Integer>> adj, int seats){
        
        // at every city there will be 1 person 
        int people = 1;
        
        // check for its neighbours
        for(Integer nextCity : adj.get(currCity)){
            
            // to avoid parent city in iteration(draw graph like tree)
            if(nextCity == prevCity)
                continue;
            
            // calculate no of people in neighbour or childeren in tree
            people = people + DFS(nextCity, currCity, adj, seats);
        }
        
        // if its not root of tree or captial then update required fuel as per no of people and available seats
        if(currCity != 0)
            fuel = fuel + (long)(Math.ceil((double)people / seats));
        
        // and return people so if you think like tree then parent node will get idea how many childeren are there in bottom
        return people;
    }
}