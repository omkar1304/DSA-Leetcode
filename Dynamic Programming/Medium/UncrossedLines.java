// https://leetcode.com/problems/uncrossed-lines/

public class UncrossedLines {
    public int helper(int[] nums1, int[] nums2, int m, int n, int[][] dp){
        // base case
        
        // if any index of both length is goes out of bound then return 0 as we dont have any numbers to make line
        if(m < 0 || n < 0)
            return 0;
        
        // if present then return
        if(dp[m][n] != -1)
            return dp[m][n];
        
        // if both are matching then we can form 1 line thats why 1
        // and we need to increment both pointer as we cant use same number to make line
        if(nums1[m] == nums2[n])
            return dp[m][n] = 1 + helper(nums1, nums2, m-1, n-1, dp);
        
        // if not matching then we can either increment pointer of nums1 or nums2 and check and store max out of it.
        else
            return dp[m][n] = Math.max(helper(nums1, nums2, m-1, n, dp) , helper(nums1, nums2, m, n-1, dp));
    }
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int m = nums1.length - 1;
        int n = nums2.length - 1;
        
        // Memoization ->
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(nums1, nums2, m, n, dp);
        
    }
}
