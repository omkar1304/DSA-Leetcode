import java.util.Arrays;

public class PrintLongestCommonSubsequence {

    public static void printLCS1(String x, String y){
        int m = x.length();
        int n = y.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                // initialization
                if(i==0 || j==0)
                    dp[i][j] = 0;
                // fill remaining

                // if char is matching then add 1 
                else if(x.charAt(i-1) == y.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                // if not then reduce either first string and continue or second string and continue
                else
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }

        // to print lCS

        int i = m;
        int j = n;
        String s = "";

        while(i>0 && j>0){
            // if char matches then we know that we got that value from i-1 and j-1 hence add that char in s and do same.
            if(x.charAt(i-1) == y.charAt(j-1)){
                s = x.charAt(i-1) + s;
                i--;
                j--;
            }
            // else we know that we have to max of out of i-1 or j-1 then just take it
            else{
                if(dp[i-1][j] > dp[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        // printing LCS
        System.out.println(s);
    }

    // using string dp matrix ->
    public static void printLCS2(String str1, String str2){

        String[][] dp = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ?  dp[i - 1][j] : dp[i][j - 1]; 
                }
            }
        }
        
        System.out.println(dp[str1.length()][str2.length()]);

    }

    public static void main(String[] args) {
        String x = "abcde";
        String y = "ace";

        printLCS1(x, y);
        printLCS2(x, y);
    }
}
