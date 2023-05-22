// https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/

class Solution {
    public int isWinner(int[] player1, int[] player2) {
        
        // calculate sum for both player 
        int sum1 = simulate(player1);
        int sum2 = simulate(player2);
        
        // return result based on both sum
        return (sum1 == sum2 ? 0 : (sum1 > sum2) ? 1 : 2);
    }
    
    public int simulate(int[] player){
        
        // calculate sum
        int sum = 0;
        
        for(int i=0; i<player.length; i++){
            
            // as per condition mentioned in question(check last two scores if equals to 10. if its true then multiply current score with 2
            if((i > 0 && player[i-1] == 10) || (i > 1 && player[i-2] == 10))
                sum = sum + 2 * player[i];
            // else add as it is
            else
                sum = sum + player[i];
        }
        
        // return sum
        return sum;
    }
}