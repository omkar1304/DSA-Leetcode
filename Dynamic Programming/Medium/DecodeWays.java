// https://leetcode.com/problems/decode-ways/

public class DecodeWays {
    public boolean check(String s, int i, int j){
        // this function helps us to check if number is valid or not
        
        String temp = s.substring(i, j+1);
        
        // if number is more than 2 digit then its not valid (1 to 26 are valid)
        if(temp.length() > 2)
            return false;
        
        int number = Integer.parseInt(temp);
        //  --checking limit(1 to 26)--  ----if number having two digit and value less then 10 then it must be leading zeros which is not valid 
        if(number > 26 || number <= 0 || (temp.length() == 2 && number < 10))
            return false;
        
        return true;
    }
    
    public int solve(String s, int i, int j, int[][] dp){
        
        // if i > j means we dont have any string so -> no. of decode ways 0
        if(i > j)
            return 0;
        
        // if i == j means we have string with 1 char -> no. of decode ways 1
        if(i == j)
            return 1;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int count = 0;
        for(int k=i; k<j; k++){
            // checking if left part is valid then only we can go for right part and update count variable
            if(check(s,i, k)){
                count = count + solve(s, k+1, j, dp); // calculating right part
            } 
        }
        
        // storing for future use
        return dp[i][j] = count;
    }
    
    public int numDecodings(String s) {
        // Memoization ->
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return solve(s, 0, s.length(), dp);
    }
}
