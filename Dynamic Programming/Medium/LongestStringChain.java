// https://leetcode.com/problems/longest-string-chain/

class Solution {
    public boolean checkPossible(String s1, String s2){
        // if length are not matching as per condition -> prev string length + 1 = current string length
        // return false
        if(s1.length() != s2.length() + 1)
            return false;
        
        int index1 = 0;
        int index2 = 0;
        
        // travel through whole string and if both index at last position then it can be part of LSC
        // for example -> bcad , bcd -> consider this and iterate through code
        while(index1 < s1.length()){
            if(index2 < s2.length() && s1.charAt(index1) == s2.charAt(index2)){
                index1++;
                index2++;
            }
            else{
                index1++;
            }
        }
        
        if(index1 == s1.length() && index2 == s2.length())
            return true;
        else
            return false;
        
    }  
    
    public int longestStrChain(String[] words) {
        int n = words.length; 
        // sorting as we need to get prev string length + 1 = current string length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        // single string can be LSC. hence filling dp array with 1
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                // checking if prev string can be part of LSC and value of prev dp + 1 is greater than value of current dp
                if(checkPossible(words[i], words[j]) && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            // storing max
            max = Math.max(max, dp[i]);
        }
        
        // return max LSC
        return max;
    }
}