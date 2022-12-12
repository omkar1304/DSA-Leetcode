// https://leetcode.com/problems/di-string-match/

public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n+1];
        int left = 0;
        int right = n;
        // if I then store left value which will be smaller
        // if D then store right value which wile be greater
        for(int i=0; i<n; i++)
            res[i] = s.charAt(i) == 'I' ? left++ : right--;
        
        res[n] = left;
        return res;
      
    }
}
