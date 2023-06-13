// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/'


class Solution {
    public int minCost(String colors, int[] cost) {
        
        int result = 0;        
        char[] ch = colors.toCharArray();
        
        for(int i=1; i<ch.length; i++){
            
            // if color is same then we have to cut one balloon which has less cost
            if(ch[i] == ch[i-1]){
                
                // so adding minimum cost out of both same colored balloons.
                result = result + Math.min(cost[i], cost[i-1]);
                
                //Thinking about this case, you will get to know.s = "bbb"; cost = [5,4,8]if not update, the result is 8. Actually, the answer is 9. so if we taking min cost above then it should use next time so we update that with remaining value which max value. 
                cost[i] = Math.max(cost[i], cost[i-1]);
            }
        }
        
        return result;
    }
}