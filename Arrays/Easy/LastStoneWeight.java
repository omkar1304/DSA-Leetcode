// https://leetcode.com/problems/last-stone-weight/

class Solution {
    public int lastStoneWeight(int[] stones) {
        
        // put all stone weight in pq in descending order ->
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(Integer stone : stones)
            pq.offer(stone);
        
        // pop out two top weights from pq until its size > 1
        while(pq.size() > 1){
            
            // poping out top 2 weights
            int weight1 = pq.poll();
            int weight2 = pq.poll();
            
            // taking difference
            int diff = weight1 - weight2;
            
            // if diff is greater than 0 then put in pq else leave it
            if(diff > 0)
                pq.offer(diff);
        }
        
        // at last either pq will be empty or 1 weight of weight will be there
        return pq.size() == 0 ? 0 : pq.peek();
    }
}