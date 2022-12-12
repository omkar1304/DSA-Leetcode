// https://leetcode.com/problems/stickers-to-spell-word/

class Solution {
    public int minStickers(String[] stickers, String target) {
        // to store stickers count with chars 
        // map = {with={t=1, w=1, h=1, i=1}, science={s=1, c=2, e=2, i=1, n=1}, example={p=1, a=1, e=2, x=1, l=1, m=1}}
        HashMap<String, HashMap<Character, Integer>> map = new HashMap<>();
        for(String str:stickers)
        {
            HashMap<Character, Integer>x = new HashMap<>();
            
            for(int i=0;i<str.length();i++)
            {
                x.put(str.charAt(i), x.getOrDefault(str.charAt(i), 0) + 1);
            }
            
            map.put(str, x);
        }
        
        // memoization -> Key -> String | value -> min stickers required to form target
        HashMap<String, Integer> dp = new HashMap<>();
        
        // if res is >= max value then its impossible to form hence return -1 else return res
        int res =  helper(target, dp, map);
        return res<1 || res>=Integer.MAX_VALUE ? -1 : res;
    }
    
    
    public int helper(String target, HashMap<String, Integer>dp, HashMap<String, HashMap<Character, Integer>> map)
    {
        // base case
        
        // if string is empty then return 0
        if(target.length()==0)
            return 0;
        
        // if present then return
        if(dp.containsKey(target))
            return dp.get(target);
        
        // storing max value as need to return min
        int res = Integer.MAX_VALUE;
        
        // here we are taking frequency table of each sticker
        for(String str: map.keySet())
        {
            HashMap<Character, Integer>x = new HashMap(map.get(str)); // to get frequency table of that particular string
            String temp = target;
            
            // if first char of temp is present in fre. table then 
            //  use all the character present in the sticker which can be used to create the target string.
            // and also remove that char count by 1 as we use ones also remove that char from string as we already form that 
            char ch = temp.charAt(0);
            if(x.containsKey(ch))
            {
                for(int i=0;i<temp.length();i++)
                {
                    ch = temp.charAt(i);
                    if(x.containsKey(ch) && x.get(ch)>0)
                    {
                        x.put(ch, x.get(ch)-1);
                        temp = temp.substring(0,i) + temp.substring(i+1);
                        i--;
                    }
                }
                
                // if length are not same that means we have form some chars by using chars of stickers 
                // hence pass remaining string and take out min of it
                // why 1 ? as we used 1 sticker
                if(temp.length() != target.length())
                {
                    
                    res = Math.min( res,1+ helper(temp, dp, map));  
                    dp.put(target, res );
                }
            }
        }
        // return res
        return res;
    }
}