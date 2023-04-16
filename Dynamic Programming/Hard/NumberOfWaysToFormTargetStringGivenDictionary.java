// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/


// Recursion + Memoization ->
class Solution {
    /*
    Problem Statement - we have to form target string from given words. so if we pick words[0][k] then we cant pick any char at words[1][k] or words[2][k]....words[j][k] and also if we pick words[j][k] then we cant pick words[j][0] to words[j][k] so in short we have to pick from left to right we cant go back. 
    
    so at every step we have two choice 
    1. skip current index of word for every word in words and move for next
    2. if target(i) == words[j][k] then pick that element and move to next
    
    To reduce TC we can pre calculate the frequency of each char at particular index for example char 'a' occurs how many times at index 0 in every word in words array. So instead of apply recusrive call evertime where target(i) == words[j][k] we can apply simply count * helper() at only once
    */
    
    
    public int numWays(String[] words, String target) {
        
        // building pre calculated count for char at index of every word in words
        int[][] charAtIndexCnt = new int[128][words[0].length()];
        
        for(int i=0; i<words.length; i++){
            
            for(int j=0; j<words[0].length(); j++){
                
                char c = words[i].charAt(j);
                charAtIndexCnt[c][j]++;
            }
        }
        
        // Memoization ->
        Integer[][] dp = new Integer[target.length()][words[0].length()];
        
        return helper(0, 0, charAtIndexCnt, words, target, dp);
    }
    
    public int helper(int index, int k, int[][] charAtIndexCnt, String[] words, String target, Integer[][] dp){
        
        // if we complete the target string then we found one way to form traget string hence return 0
        if(index == target.length())
            return 1;
        
        // if we reached end of word index then we cant go back so we cant form string hence return no of ways is 0
        if(k == words[0].length())
            return 0;
        
        // if present then return
        if(dp[index][k] != null)
            return dp[index][k];
        
        // picking current char at index target
        char c = target.charAt(index);
        
        // 1. skip current index of word for every word in words and move for next 
        long res = helper(index, k+1, charAtIndexCnt, words, target, dp);
        // 2. pick element and only run once and multiply with count of char at index of every word in words
        res += (long)helper(index+1, k+1, charAtIndexCnt, words, target, dp) * charAtIndexCnt[c][k];
        res %= 1_000_000_007;
        
        // store for future 
        return dp[index][k] = (int)res;
    }
}