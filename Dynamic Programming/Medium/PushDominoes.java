// https://leetcode.com/problems/push-dominoes/

public class PushDominoes {
    public String pushDominoes(String d) {
        StringBuilder sb = new StringBuilder(d);
        int n = sb.length();
        int right = -1;
        
        for(int index=0; index<n; index++){
            // If we encounter L in string
            if(sb.charAt(index) == 'L'){
                //if index of right is -1, we make all the left index L until we see any other L
                if(right == -1){
                    for(int j=index-1; j>=0 && sb.charAt(j)=='.'; j--)
                        sb.setCharAt(j, 'L');
                }
                // if not then we simultaneously change string from left and right side till two pointers reach each other. After that right moves back to -1
                else{
                    for(int j=right+1, i=index-1; j < i; j++, i--){
                        sb.setCharAt(j, 'R');
                        sb.setCharAt(i, 'L');
                    }
                    right = -1;
                }
            }
            // If we encounter R in string
            else if(sb.charAt(index) == 'R'){
                // if index of right is -1, then we didnt encounter R yet hence update right with new R's index
                if(right == -1)
                    right = index;
                // if right is not -1, then from previous R to current we need to make all char as R.
                else{
                    for(int j=right+1; j<index; j++)
                        sb.setCharAt(j, 'R');
                    right = index;
                }
            }
        }
        
        // if right is not -1 then we are at middle of string and we need to make all remaing char as R
        if(right != -1){
            for(int j=right+1; j<n; j++)
                sb.setCharAt(j, 'R');
        }
       
        // return string
        return sb.toString();
    }
}
