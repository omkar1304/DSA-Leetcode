// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

public class Knapsack01Problem {

    // Recusrsion + Memoization
    static int helper(int[] wt, int[] val, int c, int n, int[][] t){
        // if array size is 0 or capacity is 0 return profit 0
        if(n == 0 || c == 0){
            return 0;
        }
        // if searching value already calculatd then return 
        if(t[n][c] != -1){
            return t[n][c];
        }
        
        // if current weight is greater than capacity then move to next element
        if(wt[n-1] > c){
            return t[n][c] = helper(wt, val, c, n-1, t);
        }
        
        // if weight is small or equal than capacity then we have two choice
        // get max of pick and skip (while picking we need to store value -> val[n-1])
        else {
            return t[n][c] = Math.max(
                + helper(wt, val, c-wt[n-1], n-1, t), helper(wt, val, c, n-1, t));
        }
     
    }

    /*  Bottom up Approach -> tabulation
     * 
     * static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n+1][w+1];
         for(int i=0; i<n+1; i++){
             for(int j=0; j<w+1; j++){
                // initialization -> 
                 if(i == 0 || j == 0){
                     dp[i][j] = 0;
                 }
                 // if current size is less or equal than capacity then use max of skip or pick 
                 else if(wt[i-1] <= j){
                     dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                 }
                 // if current size is greater than capacity -> just skip it
                 else{
                     dp[i][j] = dp[i-1][j];
                 }
             }
         }
         
         return dp[n][w];
    } 
     */
    
    
    static int knapSack(int c, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] t = new int[n+1][c+1];
         for(int i=0; i<n+1; i++){
             for(int j=0; j<c+1; j++){
                 t[i][j] = -1;
             }
         }
         return helper(wt, val, c, n, t);
    } 
}
