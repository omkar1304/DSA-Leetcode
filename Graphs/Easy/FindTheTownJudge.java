// https://leetcode.com/problems/find-the-town-judge/

class Solution {
    public int findJudge(int n, int[][] trust) {
        
        // to store trust value for each person. if that person is judge then it should have n-1 value as all other person giving their trust value to him except himself
        int[] trusted = new int[n+1];
        
        for(int[] person : trust){
            
            // here suppose ther is a, b then a giving its trust to b so trust value of a will get dec by 1 and trust value of b will get inc by 1
            trusted[person[0]] = trusted[person[0]] - 1;
            trusted[person[1]] = trusted[person[1]] + 1;
        }
        
        // if we find trust value == n-1 then that person is judge hence return it else not exist so return -1
        for(int i=1; i<trusted.length; i++)
            if(trusted[i] == n-1)
                return i;
        
        return -1;
    }
}