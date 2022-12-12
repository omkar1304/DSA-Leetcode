// https://leetcode.com/problems/shortest-common-supersequence/

public class PrintShortestCommonSupersequence {
    public String LCS(String str1, String str2, int m, int n){
        // to get LCS as string ->
        String[][] dp = new String[m + 1][n + 1];
        for (int i = 0; i < m+1; i++) {
            for(int j = 0; j < n+1; j++){
                dp[i][j] = "";
            }
        }
        
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ?  dp[i - 1][j] : dp[i][j - 1]; 
                }
            }
        }
        return dp[m][n];
    }
    
    public String SCS(String str1, String str2, String lcs){
        // to get SCS as string ->
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lcs.length(); i++) {
            
            // if LCS char is not matching then keep adding char of str1 in result string
            while(p1 < str1.length() && str1.charAt(p1) != lcs.charAt(i)) {
                sb.append(str1.charAt(p1++));
            }
            // if LCS char is not matching then keep adding char of str2 in result string
            while(p2 < str2.length() && str2.charAt(p2) != lcs.charAt(i)) {
                sb.append(str2.charAt(p2++));
            }
            // once we hit same char as LCS in both string then store that char once only and increment pointers
            sb.append(lcs.charAt(i));
            p1++;
            p2++;
        }
        
        // if LCS get finished before both strings then add remaining chars in result string and return
        sb.append(str1.substring(p1)).append(str2.substring(p2));
        return sb.toString();
    }
    
    public String shortestCommonSupersequence(String x, String y) {
        
        int m = x.length();
        int n = y.length();
        
        String lcs = LCS(x, y, m, n);
        String scs = SCS(x, y, lcs);
        
        return scs;
        
    }
}
